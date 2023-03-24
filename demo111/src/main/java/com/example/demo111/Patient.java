package com.example.demo111;

public class Patient {
    int report_id ;
    int phone;
    String address ;
    String patient_name ;
    int health_care_num ;
    int facility_num;
    int cabin_number;
    int doctor_id;
    int nurse_id;

    public Patient(int report_id, int phone, String address, String patient_name, int health_care_num, int facility_num, int cabin_number, int doctor_id, int nurse_id) {
        this.report_id = report_id;
        this.phone = phone;
        this.address = address;
        this.patient_name = patient_name;
        this.health_care_num = health_care_num;
        this.facility_num = facility_num;
        this.cabin_number = cabin_number;
        this.doctor_id = doctor_id;
        this.nurse_id = nurse_id;
    }

    public int getReport_id() {
        return report_id;
    }

    public int getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }

    public String getPatient_name() {
        return patient_name;
    }

    public int getHealth_care_num() {
        return health_care_num;
    }

    public int getFacility_num() {
        return facility_num;
    }

    public int getCabin_number() {
        return cabin_number;
    }

    public int getDoctor_id() {
        return doctor_id;
    }

    public int getNurse_id() {
        return nurse_id;
    }


}
