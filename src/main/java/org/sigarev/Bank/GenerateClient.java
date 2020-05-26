package org.sigarev.Bank;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class GenerateClient implements Runnable {

    private final Logger LOG = LogManager.getLogger(GenerateClient.class);

    Hallway<Client> hallway;

    public GenerateClient(Hallway<Client> hallway){
        this.hallway = hallway;
    }

    @Override
    public void run() {
        while(true) {
            try {
                Client client = new Client();
                int random = (int) (20_000 + Math.random() * 20_000);
                client.setTimeOfProcessing( random);
                client.setNumber(Math.random() * 200);
                if (Math.random() > 0.5) client.setPurpose(Purpose.DEPOSIT_FUNDS);
                else client.setPurpose(Purpose.WITHDRAW_FUNDS);
                LOG.debug("New client {}", client);
                hallway.add(client);
                Thread.sleep(3_000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
