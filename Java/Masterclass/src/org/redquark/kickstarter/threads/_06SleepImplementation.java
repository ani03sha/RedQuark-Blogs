package org.redquark.kickstarter.threads;

public class _06SleepImplementation {
    public static void main(String[] args) {
        Thread t = new Thread(new SleepDemo());
        t.start();
    }
}

class SleepDemo implements Runnable {

    @Override
    public void run() {
        try {
            long start = System.currentTimeMillis();
            // Make the thread sleep for two seconds
            Thread.sleep(2000);
            long end = System.currentTimeMillis();
            System.out.println("Time slept: " + (end - start) / 1000.0 + " seconds");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}