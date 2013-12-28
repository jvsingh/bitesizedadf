package com.singhpora.model;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;

import com.singhpora.model.entities.DepartmentMEO;

import java.io.Serializable;

import java.net.UnknownHostException;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import java.util.Iterator;

import oracle.adf.model.BindingContext;

import oracle.binding.AttributeContext;
import oracle.binding.RowContext;

import oracle.jbo.JboException;

/**
 * Custom data control to provide a standard fascade to underlying business services. 
 * Exposes a collection of Department objects that internally 
 */
public class HRDataControl {

    
    private Collection<Department> departments;


    public HRDataControl() {
        super();

        initialise();


    }

    private void initialise() {
        departments = new ArrayList<Department>();

        try {
            DBCollection departmentsColl = MongoDAO.getDB().getCollection("Departments");
            departmentsColl.setObjectClass(DepartmentMEO.class);
            DBCursor cursor = departmentsColl.find();
            while (cursor.hasNext()) {

                DepartmentMEO dbObject = (DepartmentMEO) cursor.next();
                Department department = new Department(dbObject);

                departments.add(department);
                
                System.out.println("Datacontrol initialised. ");

            }
        } catch (UnknownHostException uhe) {
            // TODO: Add catch code
            uhe.printStackTrace();
            throw new JboException(uhe);
        }
    }


    public void setDepartments(Collection<Department> departments) {
        this.departments = departments;
    }

    public Collection<Department> getDepartments() {
        return departments;
    }


    /**
     * ADF somehow automatically knows when modifications are made on the UI
     * @return
     */
    public boolean isTransactionDirty() {

        return false;

    }

    public void rollbackTransaction() {
        initialise();
    }

    public void commitTransaction() {
        try {
            DepartmentMEO dbObject = null;
            DBCollection departmentsCollection = MongoDAO.getDB().getCollection("Departments");
            Iterator<Department> i = departments.iterator();
            while (i.hasNext()) {
                Department department = i.next();
                //dbObject = new DepartmentMEO(department);

                DBObject queryObject = new BasicDBObject("DepartmentId", department.getDepartmentId());
                //((DepartmentMEO)queryObject).setDepartmentId(department.getDepartmentId());
                departmentsCollection.setObjectClass(DepartmentMEO.class);
                dbObject = (DepartmentMEO) departmentsCollection.findOne(queryObject);
                if (dbObject != null) {
                    //this will ensure that the queried object doesn't lose its identity but an still be set with the new values
                    dbObject.setDepartment(department);
                    System.out.println(dbObject);
                    departmentsCollection.save(dbObject);
                } else {
                    System.out.println("creating new.. ");
                    departmentsCollection.insert(new DepartmentMEO(department));
                }

            }

        } catch (Exception e) {
            // TODO: Add catch code
            e.printStackTrace();
            throw new RuntimeException(e);
        }


    }


    /**
     *Set a 
     * @param attributeContext
     * @param p1
     * @return
     */
    public boolean setAttributeValue(AttributeContext attributeContext, Object p1) {
        System.out.println(attributeContext.getMasterRowDataProvider());

        System.out.println(attributeContext.getRowDataProviderType() + " :: " + attributeContext.getAttributeName() +
                           " :: " + p1);
        
        
        return false;
    }

    public Object createRowData(RowContext rowContext) {
        if (rowContext.getMasterRowDataProvider() != null &&
            rowContext.getMasterRowDataProvider() instanceof Department) {
            Department dept = (Department) rowContext.getMasterRowDataProvider();
            if (dept.getEmployees() == null)
                dept.setEmployees(new ArrayList<Employee>());
            //auto-generated key for employees (this is different from the internal object ID set by MongoDB
            
           // ((Employee)rowContext.getRowDataProvider()).setEmployeeId(dept.getDepartmentId() +dept.getEmployees().size() +1 );
        }
        return null;
    }

    public Object registerDataProvider(RowContext rowContext) {


        return null;
    }

    public boolean removeRowData(RowContext p0) {
        return false;
    }

    public void validate() {
    }

    public Serializable createSnapshot() {
        return null;
    }

    public void restoreSnapshot(Serializable p0) {
    }

    public void removeSnapshot(Serializable p0) {
    }
}
