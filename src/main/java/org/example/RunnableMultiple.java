package org.example;

public class RunnableMultiple implements Runnable {
    String numStr;

    public RunnableMultiple(String n) {
        this.numStr = n;
    }

    public void checkMultipleThree(String n) {
        int sumOfDigits = 0;

        for (char c : n.toCharArray()) {
            sumOfDigits += Character.getNumericValue(c);
        }

        if (sumOfDigits % 3 == 0) {
            System.out.println(numStr + " is a multiple of 3");
        }
    }

    public void checkMultipleFive(String n) {
        char lastChar = n.charAt(n.length() - 1);
        if (lastChar == '5' || lastChar == '0') {
            System.out.println(numStr + " is a multiple of 5");
        }
    }

    public void checkMultipleEleven(String n) {
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

        int difference = sumOddPositions - sumEvenPositions;

        if (difference % 11 == 0){
            System.out.println(n + " is a multiple of 11");
        }
    }

    @Override
    public void run() {
        checkMultipleThree(numStr);
        checkMultipleFive(numStr);
        checkMultipleEleven(numStr);
    }
}
