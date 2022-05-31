package com.sparta.centres;

public class Centre {




    public ArrayList<Centre> increaseCurrentCapacityFromWaitingList(ArrayList<Centre> centreList, int waitingList) {
        Random rand = new Random();
        int randomIntakeNumber = rand.nextInt(51);
        // if (centreListMaxCapacity < 100){
        if (waitingList > 0) {
            for (int randNum = 0; randNum < randomIntakeNumber; randNum++) {
                for (int i = 0; i < waitingList; i++) {
                    for (int j = 0; j < centreList.size(); j++) {
                        int freeSpaceInCentre = centreList.get(j).getMaxCapacity() - centreList.get(j).getCurrentCapacity();
                        if (freeSpaceInCentre > 0 && waitingList > 0 && centreList.get(j).currentCapacity < 100){
                            waitingList--;
                            centreList.get(j).currentCapacity++;
                        } else if (freeSpaceInCentre == 0) {
                            continue;
                        }
                    }
                }
            }
        }
        return centreList;
    }
}
