package org.example;

import java.util.concurrent.Callable;

public class CallableMultipleEleven implements Callable {
    String numStr;

    public CallableMultipleEleven(String num){
        this.numStr = num;
    }

    public String checkMultipleEleven(String n) {
        int sumEvenPositions = 0;
        int sumOddPositions = 0;
        StringBuilder nReverse = new StringBuilder(n);
        String nR = nReverse.reverse().toString();

        for (int i = 0; i < n.length(); i += 2) {
            int digit = Character.getNumericValue(nReverse.charAt(i));
            sumOddPositions += digit;
        }

        for (int i = 1; i < n.length(); i += 2) {
            int digit = Character.getNumericValue(nReverse.charAt(i));
            sumEvenPositions += digit;
        }

        int difference = Math.abs(sumOddPositions - sumEvenPositions);

        if (difference % 11 == 0){
            return n + " is a multiple of 11";
        } else {
            return n + " is not a multiple of 11";
        }
    }


    @Override
    public Object call() throws Exception {
        return checkMultipleEleven(numStr);
    }
}
