package org.sigarev.Bank;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.util.Queue;

public class Hallway <T> {

    private static final Logger LOG = LogManager.getLogger(Hallway.class.getName());

    private Queue<T> temps;

    public Hallway( Queue<T> temps) {
        this.temps = temps;
    }

    public synchronized T getOb() throws InterruptedException {

        LOG.debug("Clerk is free");
        while (temps.isEmpty()) {
            this.wait();
        }
        return temps.poll();
    }

    public synchronized void add(T temp) {
        LOG.debug("Add client in queue, All clients in queue : {}", temps.size());
        temps.add(temp);
        notify();
    }
}
