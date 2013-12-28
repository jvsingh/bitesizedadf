package com.singhpora.model.entities;

import com.mongodb.ReflectionDBObject;

import com.singhpora.model.Employee;

import java.util.Date;

public class EmployeeMEO extends ReflectionDBObject {
    public EmployeeMEO() {
        super();
    }
    
    public EmployeeMEO(Employee e) {
        super();
        this.employeeId = e.getEmployeeId();
        this.firstName = e.getFirstName();
        this.hireDate = e.getHireDate();
        this.lastName = e.getLastName();
        
    }
    
    String employeeId;

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setJobId(String jobId) {
        this.jobId = jobId;
    }

    public String getJobId() {
        return jobId;
    }

    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }

    public Date getHireDate() {
        return hireDate;
    }

    public void setDepartment(DepartmentMEO department) {
        this.department = department;
    }

    public DepartmentMEO getDepartment() {
        return department;
    }
    String firstName;
    String lastName;
    String email;
    String phoneNumber;
    String jobId;
    Date hireDate;
    DepartmentMEO department;
    
}
