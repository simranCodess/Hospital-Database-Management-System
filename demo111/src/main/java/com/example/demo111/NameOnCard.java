package com.example.demo111;


import java.sql.Date;

public class NameOnCard {
   String name_on_card;
    int card_number;
    Date exp_date;
    int cvv;
   int reciept_number;

    public NameOnCard(String name_on_card, int card_number, Date exp_date, int cvv, int reciept_number) {
         this.name_on_card = name_on_card;
         this.card_number = card_number;
         this.exp_date = exp_date;
         this.cvv = cvv;
         this.reciept_number = reciept_number;
    }

    public String getName_on_card() {
        return name_on_card;
    }

    public int getCard_number() {
        return card_number;
    }

    public Date getExp_date() {
        return exp_date;
    }

    public int getCvv() {
        return cvv;
    }

    public int getReciept_number() {
        return reciept_number;
    }


}
