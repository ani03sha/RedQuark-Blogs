package org.redquark.kickstarter.threads;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class _08InterThreadCommunication {

    public static void main(String[] args) {

        // Shared queue in which values are produced and consumed
        final Queue<Integer> sharedQueue = new LinkedList<>();
        Thread producer = new Thread(new Producer(sharedQueue, 4), "Producer");
        Thread consumer = new Thread(new Consumer(sharedQueue), "Consumer");

        // Starting both threads
        producer.start();
        consumer.start();
    }
}

/**
 * The producer thread will produce the value and add it into the shared queue
 */
class Producer implements Runnable {

    // Shared queue instance between producer and consumer thread
    private final Queue<Integer> sharedQ;
    // Maximum size of the shared queue
    private final int maxSize;

    Producer(Queue<Integer> sharedQ, int maxSize) {
        this.sharedQ = sharedQ;
        this.maxSize = maxSize;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (sharedQ) {
                while (sharedQ.size() == maxSize) {
                    try {
                        // If the size is equal to maxSize, i.e., the queue is full then this thread has to wait
                        // for the consumer thread to consume from the queue
                        System.out.println("Queue is full!");
                        sharedQ.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                Random random = new Random();
                int number = random.nextInt(100);
                System.out.println("Produced value: " + number);
                sharedQ.add(number);
                // After producing the value this thread has to notify the consumer that a value can be consumed from the shared queue
                sharedQ.notify();
            }
        }
    }
}

/**
 * Consumer thread will consume value from the shared queue.
 */
class Consumer implements Runnable {

    // Shared queue instance between producer and consumer thread
    private final Queue<Integer> sharedQ;

    Consumer(Queue<Integer> sharedQ) {
        this.sharedQ = sharedQ;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (sharedQ) {
                while (sharedQ.isEmpty()) {
                    try {
                        // If the queue is empty then this thread has to wait until some element is added into
                        // it before consuming
                        System.out.println("Queue is empty!");
                        sharedQ.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                int number = sharedQ.poll();
                System.out.println("Consumer value: " + number);
                // If the queue is not empty then after consuming, it needs to notify the producer to wake up
                sharedQ.notify();
            }
        }
    }
}