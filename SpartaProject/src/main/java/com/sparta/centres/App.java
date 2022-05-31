package com.sparta.centres;

import java.util.Random;

public class app {

    public static void main(String[] args) {
        Random rand = new Random();
        int n = rand.nextInt(51);
        System.out.println(n);

        final Integer maxCapacity = new Integer(100);

    }

    public static boolean isFull (int capacity){
        if(capacity >= 100){
            return true;
        } if (capacity < 100){
        }
        return false;
    }

    public int currentCapacity(int capacity){

    }
}