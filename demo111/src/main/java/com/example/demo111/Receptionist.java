package com.example.demo111;
import java.sql.Date;
public class Receptionist extends Employee{
    private int DeskNumber;


    public Receptionist(Date startDate, Date endDate, int hours, String name, int empId, int hospitalID, int deskNumber) {
        super(startDate, endDate, hours, name, empId, hospitalID);
        DeskNumber = deskNumber;

    }

    //getters and setters

    public int getDeskNumber() {
        return DeskNumber;
    }



    public void setDeskNumber(int deskNumber) {
        DeskNumber = deskNumber;
    }



}
