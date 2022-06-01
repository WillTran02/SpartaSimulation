package com.sparta;

import com.sparta.centreManager.Manager;
import com.sparta.generateCentres.genCentres;
import com.sparta.generateTrainees.genTrainees;
import com.sparta.getMonths.Input;

import java.util.ArrayList;

public class App {
    public static int totalCentres = 0; //to be incremented as centres are generated
    public static int fullCentres = 0; //to be incremented +1 when centres hit maxCapacity
    public static int totalTrainees = 0; //to be incremented as trainees are generated,
    // decremented when centres perform intake and waitingList == 0
    public static int waitingList = 0; //incremented after centres perform their intakes,
    // decremented first before totalTrainees
    public static void main(String[] args) {
        do {
            totalCentres = 0;
            fullCentres = 0;
            totalTrainees = 0;
            waitingList = 0;
            int months = Input.getMonths();
            String reporting = Input.reportOption();
            totalCentres = genCentres.generatecenter(months);
            ArrayList<Centre> centreList = new ArrayList<>();
            centreList = getCentres(months, reporting, centreList);
            for (Centre centre : centreList) {
                if (centre.isFull) fullCentres++;
//            System.out.println(centre.getCurrentCapacity());
            }
            if (reporting.equalsIgnoreCase("B")) {
                //End Summary
                printEndSummary(months);
            }
        } while (true);
    }

    public static ArrayList<Centre> getCentres(int months, String reporting, ArrayList<Centre> centreList) {
        for (int i = 1; i <= months; i++) {
            int traineesThisMonth = genTrainees.generateTrainees(1);
            totalTrainees += traineesThisMonth;
            waitingList += traineesThisMonth;
            if (i != 0 && i % 2 == 0) {
                centreList.add(new Centre());
            }
            centreList = Manager.increaseCurrentCapacityFromWaitingList(centreList, waitingList);
            if (reporting.equalsIgnoreCase("A")) {
                //Monthly Report
                int currentlyFullCentres = 0;
                int currentlyTrainingTrainees = 0;
                for (Centre centre : centreList) {
                    if (centre.isFull) currentlyFullCentres++;
                    currentlyTrainingTrainees += centre.getCurrentCapacity();
                }
                printMonthlyReport(centreList, i, currentlyFullCentres, currentlyTrainingTrainees);
            }
        }
        return centreList;
    }

    public static void printEndSummary(int months) {
        System.out.println("After " + months + " months:");
        totalTrainees = totalTrainees - waitingList;
        System.out.println("Total centres opened: " + totalCentres);
        System.out.println("Total centres at full capacity: " + fullCentres);
        System.out.println("Total number of trainees in training: " + totalTrainees);
        System.out.println("Total on the waiting list: " + waitingList);
        System.out.println("End of report.\n");
    }

    public static void printMonthlyReport(ArrayList<Centre> centreList, int i, int currentlyFullCentres, int currentlyTrainingTrainees) {
        System.out.println("Month " + i + ":");
        System.out.println("Total centres opened: " + centreList.size());
        System.out.println("Total centres at full capacity: " + currentlyFullCentres);
        System.out.println("Total number of trainees in training: " + currentlyTrainingTrainees);
        System.out.println("Total on the waiting list: " + waitingList);
        System.out.println("__________________________________________________________");
    }
}
