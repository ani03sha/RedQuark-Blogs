package org.redquark.kickstarter.threads;

import java.util.concurrent.Semaphore;

public class _16SemaphoreImplementation {

    public static void main(String[] args) throws InterruptedException {

        // Initializing semaphore object
        Semaphore semaphore = new Semaphore(1);

        Thread threadA = new Thread(new SemaphoreDemo(semaphore, "ThreadA"));
        Thread threadB = new Thread(new SemaphoreDemo(semaphore, "ThreadB"));

        // Starting both threads
        threadA.start();
        threadB.start();

        threadA.join();
        threadB.join();

        System.out.println("Final value of the shared resource: " + SharedResource.count);
    }
}

class SharedResource {
    static int count = 0;
}

class SemaphoreDemo implements Runnable {

    private Semaphore semaphore;
    private String name;

    SemaphoreDemo(Semaphore s, String n) {
        this.semaphore = s;
        this.name = n;
    }

    @Override
    public void run() {

        if (this.name.equals("ThreadA")) {
            operation(semaphore, name);
        } else {
            operation(semaphore, name);
        }
    }

    private void operation(Semaphore semaphore, String name) {

        System.out.println("Executing: " + name);

        try {
            System.out.println(name + " is waiting for a permit.");
            semaphore.acquire();
            System.out.println(name + " gets a permit.");

            // Accessing the shared resource
            for (int i = 0; i < 5; i++) {
                SharedResource.count++;
                System.out.println(name + ": " + SharedResource.count);

                // Below code will allow context switching for the other thread, if possible.
                Thread.sleep(10);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(name + " releases the permit.");
        semaphore.release();
    }
}