package com.example.demo111;

public class Hospital {
    private int facilityNumber;
    private String systemNumber;
    private String hospitalName;

    private String locationId;

    public Hospital(int facilityNumber, String systemNumber, String hospitalName, String locationId) {
        this.facilityNumber = facilityNumber;
        this.systemNumber = systemNumber;
        this.hospitalName = hospitalName;
        this.locationId = locationId;
    }

    public int getFacilityNumber() {
        return facilityNumber;
    }

    public String getSystemNumber() {
        return systemNumber;
    }

    public String getHospitalName() {
        return hospitalName;
    }

    public String getLocationId() {
        return locationId;
    }
}
