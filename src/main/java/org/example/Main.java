package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class Main {
    public final static int TOTAL_NUMBERS = 50;
    public final static int SECOND_THREAD_POOL = 12;

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        // se crea el primer pool para generar números

        ExecutorService pool1 = Executors.newFixedThreadPool(1);
        List<String> numbers = new ArrayList<String>(TOTAL_NUMBERS);

        // se crea Callable y Future para mandarlos a la pool mediante submit()

        for (int i = 0; i < TOTAL_NUMBERS; i++) {
            Callable<String> c = new CallableGenerateNumber();
            Future<String> fut = pool1.submit(c);
            try {
                numbers.add(fut.get());
                // hacerlo de task mejor y hacerlo un set
                // recuperamos el resultado y lo añadimos a la lista de números
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
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
        for (String num: numbers){   // reacerlo para iterar sobre la lsita de task
            Callable c1 = new CallableMultipleThree(num);
            Future <String> fut1 = pool2.submit(c1);

            Callable c2 = new CallableMultipleFive(num);
            Future <String> fut2 = pool2.submit(c2);

            Callable c3 = new CallableMultipleEleven(num);
            Future <String> fut3 = pool2.submit(c3);

            System.out.println(fut1.get());   // imprimirlo en un for diverente
            System.out.println(fut2.get());
            System.out.println(fut3.get());
        }

        pool1.shutdown();
        pool2.shutdown();


    }
}