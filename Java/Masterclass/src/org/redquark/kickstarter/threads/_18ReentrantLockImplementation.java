package org.redquark.kickstarter.threads;

import java.util.concurrent.locks.ReentrantLock;

public class _18ReentrantLockImplementation {

    private static ReentrantLock reentrantLock = new ReentrantLock();
    private static int count = 0;

    public static void main(String[] args) {

        Thread t1 = new Thread(() -> {
            while (getCount() < 4) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread t2 = new Thread(() -> {
            while (getCount() < 4) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        t1.start();
        t2.start();
    }

    /*
     * Locking using Lock and Reentrant Lock
     * @return count
     */
    private static int getCount() {
        reentrantLock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + " gets the count as: " + count);
            return count++;
        } finally {
            reentrantLock.unlock();
        }
    }
}
