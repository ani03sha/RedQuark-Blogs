package org.redquark.kickstarter.threads;

public class _01ThreadImplementation {

    public static void main(String[] args) {

        /* This object will be shared by different threads. This is the difference between the objects created by Thread and Runnable.
        *  Each thread is associated with the unique object in case it is created by extending the thread class.
        *  While threads using the Runnable objects share the same.
        *
        *  Below we are creating the Runnable object which will be shared with all the threads created in the for loop.
        *  While we are creating new object of Thread each time and they have one to one mapping
        */
        RunnableDemo runnableDemo = new RunnableDemo();

        for (int i = 0; i < 3; i++) {
            // Below threads are created via extending Thread class
            ThreadDemo threadDemo = new ThreadDemo();
            threadDemo.start();

            // Below threads are created via implementing Runnable interface
            Thread t = new Thread(runnableDemo);
            t.start();
        }
    }
}

class ThreadDemo extends Thread {
    @Override
    public void run() {
        System.out.println("Thread created by extending Thread class " + Thread.currentThread().getId() + " is running");
    }
}

class RunnableDemo implements Runnable {
    @Override
    public void run() {
        System.out.println("Thread created by implementing Runnable interface " + Thread.currentThread().getId() + " is running");
    }
}
