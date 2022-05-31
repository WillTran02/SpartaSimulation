package com.sparta.centreManager;

import com.sparta.App;
import com.sparta.Centre;
import java.util.ArrayList;
import java.util.Random;

public class Manager {
        public static ArrayList<Centre> increaseCurrentCapacityFromWaitingList(ArrayList<Centre> centreList, int waitingList) {
        Random rand = new Random();
        int randomIntakeNumber = (int)(Math.random() * ((50 - 0) + 1));
        // if (centreListMaxCapacity < 100){
        if (waitingList > 0) {
            for (int j = 0; j < centreList.size(); j++) {
//                for (int i = 0; i < waitingList; i++) {
                    for (int randNum = 0; randNum < randomIntakeNumber; randNum++) {
                        int freeSpaceInCentre = centreList.get(j).getMaxCapacity() - centreList.get(j).getCurrentCapacity();
                        if (freeSpaceInCentre > 0 && waitingList > 0 && centreList.get(j).currentCapacity < 100){
                            waitingList--;
                            App.waitingList--;
                            centreList.get(j).currentCapacity++;
                        } else if (freeSpaceInCentre == 0) {
                            centreList.get(j).isFull = true;
                        }
                    }
//                }
            }
        }
        return centreList;
    }
}
