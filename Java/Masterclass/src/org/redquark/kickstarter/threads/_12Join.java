package org.redquark.kickstarter.threads;

public class _12Join {

    public static void main(String[] args) {
        JoinDemo demo = new JoinDemo();
        Thread t1 = new Thread(demo);
        Thread t2 = new Thread(demo);
        Thread t3 = new Thread(demo);

        // Starting first thread
        t1.start();

        // Start second thread after when first thread is died
        try {
            System.out.println("Current Thread: " + Thread.currentThread().getName());
            t1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Starting second thread
        t2.start();

        // Start third thread after when second thread is died
        try {
            System.out.println("Current Thread: " + Thread.currentThread().getName());
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        t3.start();
    }

    static class JoinDemo implements Runnable {

        @Override
        public void run() {
            for (int i = 0; i < 3; i++) {
                try {
                    Thread.sleep(500);
                    System.out.println("Current Thread: " + Thread.currentThread().getName());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(i);
            }
        }
    }

}