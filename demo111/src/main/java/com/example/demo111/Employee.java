package com.example.demo111;
import java.sql.Date;
public class Employee {
    private int empId;
    private int hours;
    private String name;

    private Date startDate;

    private Date endDate;

    private int hospitalID;




    //constructor
    public Employee(Date startDate,Date endDate, int hours, String name,int empId, int hospitalID) {
        this.empId = empId;
        this.hours = hours;
        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate;
        this.hospitalID = hospitalID;
    }


    //getters and setters
    public int getEmpId() {
        return empId;
    }

    public int getHours() {
        return hours;
    }

    public String getName() {
        return name;
    }

    public Date getStartDate() {
        return startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public int getHospitalID() {
        return hospitalID;
    }






}
