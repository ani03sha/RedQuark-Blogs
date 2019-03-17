package org.redquark.kickstarter.threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class _14ThreadPoolImplementation {

    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(3);
        for (int i = 0; i < 5; i++) {
            Runnable task = new Task(i + "");
            service.execute(task);
        }
        service.shutdown();
        System.out.println("Finished all threads");
    }

    static class Task implements Runnable {

        private String command;

        Task(String c) {
            this.command = c;
        }

        void executeCommand() {
            try {
                System.out.println("Command is processing...");
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + " - Start. Command - " + command);
            executeCommand();
            System.out.println(Thread.currentThread().getName() + " End.");
        }
    }
}
