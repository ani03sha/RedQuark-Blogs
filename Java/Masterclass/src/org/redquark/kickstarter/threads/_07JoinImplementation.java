package org.redquark.kickstarter.threads;

public class _07JoinImplementation {
    public static void main(String[] args) {
        Thread t = new Thread(new JoinDemo());
        t.start();
        try {
            // Wait for 2 seconds this thread to die
            t.join(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Joining after 2 seconds");
        System.out.println("Current thread: " + t.getName());
        //Check if this thread is alive
        System.out.println("Is alive? " + t.isAlive());
    }
}

class JoinDemo implements Runnable {
    @Override
    public void run() {
        Thread t = Thread.currentThread();
        System.out.println("Current thread is: " + t.getName());
        System.out.println("Is alive? " + t.isAlive());
    }
}
