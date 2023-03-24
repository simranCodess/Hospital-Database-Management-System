package com.example.demo111;

public class Benefits {
    private int benefit_id;
    private int employee_id;

  //constructor

    public Benefits(int benefit_id, int employee_id) {
        this.benefit_id = benefit_id;
        this.employee_id = employee_id;
    }

    //getters and setters

    public int getBenefit_id() {
        return benefit_id;
    }

    public int getEmployee_id() {
        return employee_id;
    }

}
