package com.singhpora.model;

import com.mongodb.DBObject;

import com.singhpora.model.entities.DepartmentMEO;

import java.util.ArrayList;
import java.util.Collection;

public class Department {
    public Department() {
        super();
    }

    String departmentId;
    String departmentName;
    Collection<Employee> employees;

    public Department(String departmentId, String departmentName, Collection<Employee> employees) {
        super();
        this.departmentId = departmentId;
        this.departmentName = departmentName;
        this.employees = employees;
    }

    Department(DepartmentMEO dbObject) {
        super();
        this.setDepartmentId(dbObject.getDepartmentId());
        this.setDepartmentName(dbObject.getDepartmentName());
        this.setEmployees(new ArrayList<Employee>());

        for (DBObject me : dbObject.getEmployees()) {


            this.employees.add(new Employee(me));
        }
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

    public void setEmployees(Collection<Employee> employees) {
        this.employees = employees;
    }

    public Collection<Employee> getEmployees() {
        return employees;
    }
}
