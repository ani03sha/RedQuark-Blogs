package org.redquark.kickstarter.threads;

public class _13SynchronizationImplementation {

    public static void main(String[] args) {
        Sender sender = new Sender();
        SendThread s1 = new SendThread("Hello World!", sender);
        SendThread s2 = new SendThread("Bye World!", sender);

        Thread t1 = new Thread(s1);
        Thread t2 = new Thread(s2);

        // Starting two threads
        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    static class Sender {
        void send(String msg) {
            System.out.println("Sending\t" + msg);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("\n" + msg + " sent\n\n");
        }
    }

    static class SendThread implements Runnable {

        private final Sender sender;
        private String msg;

        SendThread(String m, Sender s) {
            this.msg = m;
            this.sender = s;
        }

        @Override
        public void run() {
            // Only one thread can access this block at a time
            synchronized (sender) {
                sender.send(msg);
            }
        }
    }
}
