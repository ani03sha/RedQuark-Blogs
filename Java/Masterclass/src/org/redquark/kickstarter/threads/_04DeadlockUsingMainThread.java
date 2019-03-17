package org.redquark.kickstarter.threads;

public class _04DeadlockUsingMainThread {
    public static void main(String[] args) {
        try {
            System.out.println("Going to enter deadlock!");
            // Calling join() method on the current thread will cause
            // the current thread to wait on itself
            Thread.currentThread().join();
            // This statement will never execute as the thread will
            // not be able to move forward after calling the join() method
            System.out.println("This statement will never execute!");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
