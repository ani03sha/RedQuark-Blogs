package org.redquark.kickstarter.threads;

public class _22DaemonImplementation {

    public static void main(String[] args) {

        DaemonThread daemonThread = new DaemonThread();
        daemonThread.start();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Main thread finishes");
    }

    static class DaemonThread extends Thread {

        DaemonThread() {
            // When false, (i.e. when it's a user thread), the Worker thread continues to run.
            // When true, (i.e. when it's a daemon thread), the Worker thread terminates when the main thread terminates.
            setDaemon(true);
        }

        @Override
        public void run() {

            int count = 0;

            while (true) {
                System.out.println("Count from Daemon: " + count++);
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
