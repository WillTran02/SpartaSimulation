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



    public void setCurrentCapacity(int currentCapacity){
        if (currentCapacity <= 100){
            this.currentCapacity = currentCapacity;
            if (currentCapacity == 100){
                this.isFull = true;
            }
        }
    }
    }


