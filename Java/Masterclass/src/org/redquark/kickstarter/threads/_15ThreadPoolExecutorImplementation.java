package org.redquark.kickstarter.threads;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class _15ThreadPoolExecutorImplementation {

    public static void main(String[] args) {

        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(2);

        for (int i = 0; i < 5; i++) {
            Task task = new Task("Task - " + i);
            System.out.println("Created: " + task.getName());
            executor.execute(task);
        }
        executor.shutdown();
    }

    static class Task implements Runnable {

        private String name;

        Task(String n) {
            this.name = n;
        }

        String getName() {
            return name;
        }

        @Override
        public void run() {
            try {
                long duration = (long) (Math.random() * 10);
                System.out.println("Executing: " + name);
                // Sleep for random time
                TimeUnit.SECONDS.sleep(duration);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}