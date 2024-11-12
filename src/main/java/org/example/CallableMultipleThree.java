package org.example;

import java.util.concurrent.Callable;

public class CallableMultipleThree implements Callable {
    String numStr;

    public CallableMultipleThree(String n){
        this.numStr= n;
    }

    public String checkMultipleThree(String n) {
        int sumOfDigits = 0;

        for (char c : n.toCharArray()) {
            sumOfDigits += Character.getNumericValue(c);
        }

        if (sumOfDigits % 3 == 0) {
            return numStr + " is a multiple of 3";

        } else {
            return numStr + " is not a multiple of 3";
        }
    }

    @Override
    public String call() throws Exception {
        return checkMultipleThree(numStr);
    }
}
