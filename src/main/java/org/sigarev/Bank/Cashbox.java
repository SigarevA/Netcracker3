package org.sigarev.Bank;

import java.awt.*;

public class Cashbox {

    private volatile double amount;


    public Cashbox(double amount) {
        this.amount = amount;
    }

    public synchronized void addAmount(double amount) {
        this.amount += amount ;
    }

    public synchronized boolean withdraw ( double amount) {
        if (this.amount < amount)
            return false;
        else {
            this.amount -= amount;
        }
        return true;
    }
}
