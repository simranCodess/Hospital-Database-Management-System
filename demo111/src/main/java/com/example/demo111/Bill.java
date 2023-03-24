package com.example.demo111;

public class Bill {
    private int recieptNumber;
    private int empID;

    private int amount;

    private int reportId;

    public Bill(int recieptNumber, int empID, int amount, int reportId) {
        this.recieptNumber = recieptNumber;
        this.empID = empID;
        this.amount = amount;
        this.reportId = reportId;
    }

    public int getRecieptNumber() {
        return recieptNumber;
    }

    public int getEmpID() {
        return empID;
    }

    public int getAmount() {
        return amount;
    }

    public int getReportId() {
        return reportId;
    }


}
