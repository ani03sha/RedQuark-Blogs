package org.redquark.kickstarter.threads;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;


public class _20CallableFutureImplementation {

    public static void main(String[] args) {

        ThreadPoolExecutor threadPoolExecutor = (ThreadPoolExecutor) Executors.newFixedThreadPool(2);
        List<Future<Integer>> resultList = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < 4; i++) {
            int n = random.nextInt(10);
            Factorial factorial = new Factorial(n);
            Future<Integer> future = threadPoolExecutor.submit(factorial);
            resultList.add(future);
        }

        for (Future<Integer> result : resultList) {
            try {
                System.out.println("Future result is: " + result.get() + " and Task done is: " + result.isDone());
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }
        threadPoolExecutor.shutdown();
    }

    static class Factorial implements Callable<Integer> {

        private int number;

        Factorial(int number) {
            this.number = number;
        }

        @Override
        public Integer call() throws Exception {

            int result = 1;

            if (number == 0 || number == 1) {
                return number;
            } else {
                for (int i = 2; i <= number; i++) {
                    result = result * i;
                    TimeUnit.MILLISECONDS.sleep(100);
                }
            }
            System.out.println("Factorial of " + number + " is: " + result);
            return result;
        }
    }
}
