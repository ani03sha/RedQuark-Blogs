package org.redquark.kickstarter.threads;

public class _10StartVsRun {
    public static void main(String[] args) {
        DemoThread demoThread = new DemoThread();
        Thread t = new Thread(demoThread);
        // Calling the start method - a new thread should be spawned.
        t.start();
        // Calling the run method - the code will execute in the current
        // thread from which it is being called. Main thread in this case.
        t.run();
    }
}

class DemoThread implements Runnable {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + ": inside run() method");
    }
}