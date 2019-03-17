package org.redquark.kickstarter.threads;

public class _03MainThread extends Thread {

    public static void main(String[] args) {

        // Getting the reference of the current thread
        Thread t = Thread.currentThread();
        // Name of the current thread
        System.out.println("Name: " + t.getName());
        // Setting the name of the thread
        t.setName("RedQuark");
        // Getting the updated name
        System.out.println("Updated name: " + t.getName());
        // Getting the priority of the thread
        System.out.println("Priority: " + t.getPriority());
        // Changing the priority of the thread
        t.setPriority(MAX_PRIORITY);
        // Getting the updated priority
        System.out.println("Updated priority: " + t.getPriority());
        for (int i = 0; i < 5; i++) {
            System.out.println("Main thread");
        }
        // Creating a child thread
        ChildThread ct = new ChildThread();
        // Getting the ChildThread's priority and it should be inherited
        // from its parent which is the main thread
        System.out.println("Child Thread's priority: " + ct.getPriority());
        // Changing the priority
        ct.setPriority(MIN_PRIORITY);
        //Getting the updated priority
        System.out.println("Child Thread's updated priority: " + ct.getPriority());
        // Starting the child thread
        ct.start();
    }
}

class ChildThread extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println("Child thread");
        }
    }
}
