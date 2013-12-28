package com.singhpora.model.entities;

import com.mongodb.ReflectionDBObject;

import com.singhpora.model.Department;
import com.singhpora.model.Employee;

import java.util.ArrayList;
import java.util.Collection;

import java.util.Iterator;

import oracle.binding.AttributeContext;
import oracle.binding.RowContext;

/**
 *This is the "MongoDB Entity Object" i.e. the java representation of the object that is actually persisted. 
 */
public class DepartmentMEO extends ReflectionDBObject {
    public DepartmentMEO() {
        super();
    }

    public DepartmentMEO(Department department) {
        super();
      //  _id = department.getDepartmentId();
        this.setDepartment(department);
    }
    //String _id;
    /**
     *This method just initialises all the fields of the Department entity from the value object
     * 
     * @param department
     */
    public void setDepartment(Department department) {
        this.setDepartmentId(department.getDepartmentId());
        this.setDepartmentName(department.getDepartmentName());
        
        Collection<Employee> employees = department.getEmployees();
        this.setEmployees(new ArrayList<EmployeeMEO>());
        int counter = 0;
        for(Employee e:employees) {
            counter++;
            EmployeeMEO me = new EmployeeMEO(e);      
            if(me.getEmployeeId() == null) {
                String id = department.getDepartmentId() + counter ;
                e.setEmployeeId(id);
                me.setEmployeeId(id);
            }
            this.getEmployees().add(me);
        }
    }

    
    String departmentId;
    String departmentName;
    Collection<EmployeeMEO> employees;

    public void setEmployees(Collection<EmployeeMEO> employees) {
        this.employees = employees;
    }

    public Collection<EmployeeMEO> getEmployees() {
        return employees;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }

    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getDepartmentName() {
        return departmentName;
    }
    


    public boolean isTransactionDirty() {
        return false;
    }

    public void rollbackTransaction() {
    }

    public void commitTransaction() {
    }

    public boolean setAttributeValue(AttributeContext p0, Object p1) {
        return false;
    }

    public Object createRowData(RowContext p0) {
        return null;
    }

    public Object registerDataProvider(RowContext p0) {
        return null;
    }

    public boolean removeRowData(RowContext p0) {
        return false;
    }

    public void validate() {
    }
}
