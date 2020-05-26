package org.sigarev.Bank;

import java.awt.*;
import java.util.Calendar;

public class Clerk implements Runnable {

    private Hallway<Client> hallway;
    private Cashbox checkbox;

    public Clerk(Hallway<Client> hallway, Cashbox cashbox) {
        this.hallway = hallway;
        this.checkbox = cashbox;
    }


    public Clerk() {
    }

    public void setHallway(Hallway<Client> hallway) {
        this.hallway = hallway;
    }

    public void setCheckbox(Cashbox checkbox) {
        this.checkbox = checkbox;
    }

    @Override
    public void run() {
        while(true) {

            try {
                Client client = hallway.getOb();
                if ( client.getPurpose() == Purpose.DEPOSIT_FUNDS ) {
                    checkbox.withdraw(client.getNumber());
                    continue;
                }
                else checkbox.addAmount(client.getNumber() );
                Thread.sleep(client.getTimeOfProcessing());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
