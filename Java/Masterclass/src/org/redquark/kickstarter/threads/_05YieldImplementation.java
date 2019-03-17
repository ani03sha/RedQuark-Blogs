package org.redquark.kickstarter.threads;

public class _05YieldImplementation {
    public static void main(String[] args) {
        Thread t = new Thread(new YieldDemo());
        t.start();
        for (int i = 0; i < 4; i++) {
            // passing the control
            Thread.yield();
            // Now the child thread should execute and after its execution,
            // the main thread will resume execution
            System.out.println(Thread.currentThread().getName() + " is running");
        }
    }
}

class YieldDemo implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 4; i++) {
            System.out.println(Thread.currentThread().getName() + " is running");
        }
    }
}
