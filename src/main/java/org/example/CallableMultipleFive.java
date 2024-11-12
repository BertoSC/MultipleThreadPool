package org.example;

import java.util.concurrent.Callable;

public class CallableMultipleFive implements Callable {
    String numStr;

    public CallableMultipleFive (String num){
        this.numStr = num;
    }

    public String checkMultipleFive(String n) {
        char lastChar = n.charAt(n.length() - 1);
        if (lastChar == '5' || lastChar == '0') {
            return numStr + " is a multiple of 5";
        } else {
            return numStr + " is not a multiple of 5";
        }
    }

    @Override
    public Object call() throws Exception {
        return checkMultipleFive(numStr);
    }
}
