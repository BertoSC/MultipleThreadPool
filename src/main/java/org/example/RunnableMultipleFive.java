package org.example;

public class RunnableMultipleFive implements Runnable {
    String numStr;

    RunnableMultipleFive(String n){
        this.numStr=n;
    }

    public void checkMultipleFive(String n) {
        char lastChar = n.charAt(n.length() - 1);
        if (lastChar == '5' || lastChar == '0') {
            System.out.println(numStr + " is a multiple of 5");
        }
    }

    @Override
    public void run() {
        checkMultipleFive(numStr);

    }




}
