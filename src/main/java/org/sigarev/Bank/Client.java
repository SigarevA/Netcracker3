package org.sigarev.Bank;

import java.util.concurrent.Delayed;

public class Client {

    private Purpose purpose;
    private double number;
    private int timeOfProcessing;

    public Client(Purpose purpose, double number) {
        this.purpose = purpose;
        this.number = number;
    }

    public Client() {
    }

    public Purpose getPurpose() {
        return purpose;
    }

    public void setPurpose(Purpose purpose) {
        this.purpose = purpose;
    }

    public double getNumber() {
        return number;
    }

    public void setNumber(double number) {
        this.number = number;
    }

    public int getTimeOfProcessing() {
        return timeOfProcessing;
    }

    public void setTimeOfProcessing(int timeOfProcessing) {
        this.timeOfProcessing = timeOfProcessing;
    }


    @Override
    public String toString() {
        return "Client{" +
                "purpose=" + purpose +
                ", number=" + number +
                ", timeOfProcessing=" + timeOfProcessing +
                '}';
    }
}
