package org.redquark.kickstarter.threads;

import java.util.concurrent.CountDownLatch;

public class _17CountDownLatchImplementation {

    public static void main(String[] args) {

        final CountDownLatch latch = new CountDownLatch(3);
        Thread loginService = new Thread(new Service("Login Service", 1000, latch));
        Thread databaseService = new Thread(new Service("Database Service", 1000, latch));
        Thread cloudService = new Thread(new Service("Cloud Service", 1000, latch));

        // Starting all the services
        loginService.start();
        databaseService.start();
        cloudService.start();

        try {
            latch.await();
            System.out.println("All services are up. Now the waiting thread can start execution.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    static class Service implements Runnable {

        private final String name;
        private final int startTime;
        private final CountDownLatch latch;

        Service(String name, int startTime, CountDownLatch latch) {
            this.name = name;
            this.startTime = startTime;
            this.latch = latch;
        }

        @Override
        public void run() {

            try {
                Thread.sleep(startTime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(name + " is up!");
            latch.countDown();
        }
    }
}
