package com.example.demo111;

import java.sql.Date;

public class Doctor extends Employee {
    private String speciality;
    private int DoctorID;

    private int nurseID;

    private int AssignedRoom;

    private int deskNumber;




    public Doctor(Date startDate, Date endDate, int hours, String name, int empId, int hospitalID, String speciality, int doctorID) {
        super(startDate, endDate, hours, name, empId, hospitalID);
        this.speciality = speciality;
        DoctorID = doctorID;

    }

    //getter and setter

    public String getSpeciality() {
        return speciality;
    }

    public int getDoctorID() {
        return DoctorID;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    public void setDoctorID(int doctorID) {
        DoctorID = doctorID;
    }



}
