package org.redquark.kickstarter.threads;

public class _11ThreadPriority {
    public static void main(String[] args) {

        PriorityDemo priorityDemo = new PriorityDemo();

        Thread t1 = new Thread(priorityDemo);
        Thread t2 = new Thread(priorityDemo);
        Thread t3 = new Thread(priorityDemo);

        System.out.println("Default priorities:");
        System.out.println(t1.getName() + " priority: " + t1.getPriority());
        System.out.println(t2.getName() + " priority: " + t2.getPriority());
        System.out.println(t3.getName() + " priority: " + t3.getPriority());

        t1.setPriority(2);
        t2.setPriority(4);
        t3.setPriority(7);

        System.out.println("\nUpdated priorities:");
        System.out.println(t1.getName() + " priority: " + t1.getPriority());
        System.out.println(t2.getName() + " priority: " + t2.getPriority());
        System.out.println(t3.getName() + " priority: " + t3.getPriority());
    }
}

class PriorityDemo implements Runnable {
    @Override
    public void run() {
        System.out.println("Inside run method");
    }
}
