package org.redquark.kickstarter.threads;

public class _09NotifyAndNotifyAll {

    private volatile boolean go = false;

    public static void main(String[] args) throws InterruptedException {

        final _09NotifyAndNotifyAll waitAndNotify = new _09NotifyAndNotifyAll();

        Runnable waitTask = () -> {
            try {
                waitAndNotify.shouldGo();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread() + " finished execution");
        };

        Runnable notifyTask = () -> {
            waitAndNotify.go();
            System.out.println(Thread.currentThread() + " finished execution");
        };

        Thread t1 = new Thread(waitTask, "W1");
        Thread t2 = new Thread(waitTask, "W2");
        Thread t3 = new Thread(waitTask, "W3");
        Thread t4 = new Thread(notifyTask, "N1");

        // starting all the waiting threads
        t1.start();
        t2.start();
        t3.start();

        Thread.sleep(2000);

        // starting the notifying threads
        t4.start();
    }

    private synchronized void go() {
        while (!go) {
            System.out.println(Thread.currentThread() + " is going to notify all the threads waiting on this object");
            // making condition true for the waiting thread
            go = true;
            // Only one thread among W1, W2, W3 will be woken up
            //notify();
            // All threads will wake up
            notifyAll();
        }
    }

    private synchronized void shouldGo() throws InterruptedException {
        while (!go) {
            System.out.println(Thread.currentThread() + " is going to wait on this object");
            // Releases lock and reacquires on wake up
            wait();
            System.out.println(Thread.currentThread() + " is woken up");
        }
        go = false;
    }
}