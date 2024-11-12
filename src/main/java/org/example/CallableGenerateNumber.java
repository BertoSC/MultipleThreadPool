package org.example;

import java.math.BigInteger;
import java.util.Random;
import java.util.concurrent.Callable;

public class CallableGenerateNumber implements Callable {
    final static Random rm = new Random ();

    public String generateNumber() {
        int size = rm.nextInt(20, 50);
        StringBuilder number = new StringBuilder(size);
        number.append(rm.nextInt(1,10));
        for (int i = 0; i < size-1; i++) {
            number.append(rm.nextInt(9) + 1);
        }
        return number.toString();
    }

    @Override
    public String call() throws Exception {
        return generateNumber();
    }
}
