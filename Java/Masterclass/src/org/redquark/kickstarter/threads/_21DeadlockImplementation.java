package org.redquark.kickstarter.threads;

public class _21DeadlockImplementation {

    public static void main(String[] args) {

        _21DeadlockImplementation deadlockImplementation = new _21DeadlockImplementation();

        final A a = deadlockImplementation.new A();
        final B b = deadlockImplementation.new B();

        // Thread-1
        Runnable runnableA = () -> {
            synchronized (a) {
                try {
                    System.out.println(a.getI());
                    // Delay is introduced so that both threads can try to lock resources
                    Thread.sleep(100);
                    // Thread-1 has A but needs B also
                    synchronized (b) {
                        System.out.println("Acquiring resource B from Thread-1: " + b.getI());
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        // Thread-2
        Runnable runnableB = () -> {
            synchronized (b) {
                // Thread-2 had B but needs A also
                synchronized (a) {
                    System.out.println("Acquiring resource A from Thread-2: " + a.getI());
                }
            }
        };

        Runnable runnableC = () -> {
            synchronized (a) {
                synchronized (b) {
                    System.out.println("Acquiring resource B from Thread-3: " + a.getI());
                }
            }
        };

        // Starting both threads
        new Thread(runnableA).start();
        //new Thread(runnableB).start();
        new Thread(runnableC).start();
    }

    // Resource A
    private class A {

        private int i = 10;

        public int getI() {
            return i;
        }

    }


    // Resource B
    private class B {

        private int i = 20;

        public int getI() {
            return i;
        }
    }
}
