package com.sparta;

public class Centre {
    private static final int maxCapacity = 100;
    public int currentCapacity = 0;
    public boolean isFull = false;


    public int getMaxCapacity() {
        return maxCapacity;
    }

    public int getCurrentCapacity() {
        return currentCapacity;
    }

}
