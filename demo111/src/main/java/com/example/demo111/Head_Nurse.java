package com.example.demo111;

public class Head_Nurse {
    int nurseID;

    int empID;

    int cabinNumber;

    public Head_Nurse(int nurseID, int empID, int cabinNumber) {
        this.nurseID = nurseID;
        this.empID = empID;
        this.cabinNumber = cabinNumber;
    }

    public int getNurseID() {
        return nurseID;
    }

    public int getEmpID() {
        return empID;
    }

    public int getCabinNumber() {
        return cabinNumber;
    }
}
