package org.example;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.*;

public class Main {
    public final static int TOTAL_NUMBERS = 50;
    public final static int SECOND_THREAD_POOL = 12;

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        // se crea el primer pool para generar números

        ExecutorService pool1 = Executors.newFixedThreadPool(1);
        Set<Future> numbers = new HashSet(TOTAL_NUMBERS);
        Set<Future> results = new HashSet<>();

        // se crea Callable y Future para mandarlos a la pool mediante submit()

        for (int i = 0; i < TOTAL_NUMBERS; i++) {
            Callable<String> c = new CallableGenerateNumber();
            Future<String> fut = pool1.submit(c);
            numbers.add(fut);
            // hacerlo de task mejor y hacerlo un set
            // recuperamos el resultado y lo añadimos a la lista de números
        }

        // VERSIÓN CON LOS RUNNABLES

  /*      ExecutorService pool2 = Executors.newFixedThreadPool(SECOND_THREAD_POOL);

        for (String num: numbers) {
            Runnable r = new RunnableMultipleThree(num);
            Runnable r2 = new RunnableMultipleFive(num);
            Runnable r3 = new RunnableMultipleEleven(num);
            pool2.execute(r);
            pool2.execute(r2);
            pool2.execute(r3);
        }
  */
        // VERSIÓN CON LOS CALLABLES

        ExecutorService pool2 = Executors.newFixedThreadPool(SECOND_THREAD_POOL);
        for (Future num: numbers){   // reacerlo para iterar sobre la lsita de task
            Callable c1 = new CallableMultipleThree(num.get().toString());
            Future <String> fut1 = pool2.submit(c1);

            Callable c2 = new CallableMultipleFive(num.get().toString());
            Future <String> fut2 = pool2.submit(c2);

            Callable c3 = new CallableMultipleEleven(num.get().toString());
            Future <String> fut3 = pool2.submit(c3);

            results.add(fut1);
            results.add(fut2);
            results.add(fut3);

        }

        for (Future res: results){
            System.out.println(res.get());   // imprimirlo en un for diverente

        }

        pool1.shutdown();
        pool2.shutdown();


    }
}