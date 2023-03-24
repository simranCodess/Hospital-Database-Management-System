package com.example.demo111;

import java.sql.Date;

public class Nurse extends Employee{
    private int NurseID;



    private int AssignedRoom;

        public Nurse(Date startDate, Date endDate, int hours, String name, int empId, int hospitalID, int nurseID, int assignedRoom) {
            super(startDate, endDate, hours, name, empId, hospitalID);
            NurseID = nurseID;

            AssignedRoom = assignedRoom;
        }

        //getters and setters

        public int getNurseID() {
            return NurseID;
        }



        public int getAssignedRoom() {
            return AssignedRoom;
        }

        public void setNurseID(int nurseID) {
            NurseID = nurseID;
        }



        public void setAssignedRoom(int assignedRoom) {
            AssignedRoom = assignedRoom;
        }



}

