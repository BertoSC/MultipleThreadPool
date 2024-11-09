package org.example;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class Main {
    public final static int TOTAL_NUMBERS = 50;
    public final static int SECOND_THREAD_POOL = 12;
    public static void main(String[] args) {

        ExecutorService pool1 = Executors.newFixedThreadPool(1);
        List<String> numbers = new ArrayList<String>(TOTAL_NUMBERS);

        for (int i = 0; i < TOTAL_NUMBERS; i++) {
            Callable<String> c = new CallableGenerateNumber();
            Future<String> fut = pool1.submit(c);
            try {
                numbers.add(fut.get());
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }

        ExecutorService pool2 = Executors.newFixedThreadPool(SECOND_THREAD_POOL);
        for (String num: numbers) {
            Runnable r = new RunnableMultiple(num);
            pool2.execute(r);
        }

        pool1.shutdown();
        pool2.shutdown();


    }
}