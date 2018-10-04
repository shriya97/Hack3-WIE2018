package com.example.shriya.hack3_wie2018;

/**
 * Created by diksha on 4/10/18.
 */

public class Salary {
    String employeeName;
    String salary;
    String pendingAmount;

    public Salary(String employeeName, String salary, String pendingAmount){
        this.employeeName = employeeName;
        this.salary = salary;
        this.pendingAmount = pendingAmount;
    }
    public String getEmployeeName() {
        return employeeName;
    }

    public String getPendingAmount() {
        return pendingAmount;
    }

    public String getSalary() {
        return salary;
    }
}
