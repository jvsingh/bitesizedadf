package com.singhpora.model;

import com.mongodb.DBObject;
import com.mongodb.ReflectionDBObject;

import com.singhpora.model.entities.EmployeeMEO;

import java.util.Date;

public class Employee {
    public Employee() {
        super();
    }
    
    
    String objectId;
    
    String employeeId;
    String firstName;
    String lastName;
    String email;
    String phoneNumber;
    String jobId;
    Date hireDate;

    public Employee(String employeeId, String firstName, String lastName,
                    String email, String phoneNumber, String jobId,
                    Date hireDate) {
        super();
        this.employeeId = employeeId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.jobId = jobId;
        this.hireDate = hireDate;
    }

    /**
     *Due to this bug, it currently has to be the generic DBObject type and not EmployeeMEO
     * @param me
     */
    Employee(DBObject me) {
        super();
        this.employeeId = (String) me.get("EmployeeId");
        this.firstName = (String) me.get("FirstName");
        this.lastName = (String) me.get("LastName");
        this.email = (String) me.get("Email");
        this.phoneNumber = (String) me.get("PhoneNumber");
        this.jobId = (String) me.get("JobId");
        this.hireDate = (Date) me.get("HireDate");
        
    }

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
}
