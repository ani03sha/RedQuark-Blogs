package org.redquark.kickstarter.threads;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class _19CyclicBarrierImplementation {

    public static void main(String[] args) {

        final CyclicBarrier cyclicBarrier = new CyclicBarrier(3,
                () -> System.out.println("This is the action. All the threads have crossed the barrier"));

        Thread t1 = new Thread(new Task(cyclicBarrier), "ThreadA");
        Thread t2 = new Thread(new Task(cyclicBarrier), "ThreadB");
        Thread t3 = new Thread(new Task(cyclicBarrier), "ThreadC");

        // Start all the threads
        t1.start();
        t2.start();
        t3.start();
    }

    private static class Task implements Runnable {

        private CyclicBarrier cyclicBarrier;

        Task(CyclicBarrier cyclicBarrier) {
            this.cyclicBarrier = cyclicBarrier;
        }

        @Override
        public void run() {

            try {
                System.out.println(Thread.currentThread().getName() + " is waiting on the barrier");
                cyclicBarrier.await();
                System.out.println(Thread.currentThread().getName() + " has crossed the barrier");
            } catch (InterruptedException | BrokenBarrierException e) {
                e.printStackTrace();
            }
        }
    }
}
