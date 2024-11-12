package org.example;

public class RunnableMultipleThree implements Runnable {
    String numStr;

    public RunnableMultipleThree(String n) {
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

    @Override
    public void run() {
        checkMultipleThree(numStr);
    }
}
