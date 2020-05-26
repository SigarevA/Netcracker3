package org.sigarev;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.spi.LoggerContextFactory;
import org.sigarev.Bank.*;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.*;

public class Lab3 {

    private static final Logger LOG = LogManager.getLogger(Lab3.class.getName());

    public static void main(String[] args) throws InterruptedException {
        LOG.debug("Start programm!");
        LOG.info("dedfesf");
        Cashbox cashbox = new Cashbox(4000.0);
        LOG.error("do not, {}" , cashbox);
        Hallway<Client> hallway = new Hallway<Client>(new LinkedList<>() {});
        int count = 5;
        ExecutorService executorService = Executors.newFixedThreadPool(count,
                r -> {
                    Thread t = Executors.defaultThreadFactory().newThread(r);
                    t.setDaemon(true);
                    return t;
                });
        for (int i = 0 ; i < count - 1 ; i++) {
            executorService.submit(new Clerk(hallway, cashbox));
        }
        executorService.submit(new GenerateClient(hallway));


        Thread.sleep(10_0000);
    }


}
