package org.sigarev;

public class Test {

    public static void main(String[] args) throws InterruptedException {
        Thread threa = new Thread(
                        () ->
                            {
                                while (true) {
                                    System.out.print("demom is run");
                                    try {
                                        Thread.sleep(500);
                                    } catch (InterruptedException e) {
                                        e.printStackTrace();
                                    }
                                }
                            }
                        );
        threa.setDaemon(true);
        threa.start();
        Thread.sleep(3000);
    }
}
