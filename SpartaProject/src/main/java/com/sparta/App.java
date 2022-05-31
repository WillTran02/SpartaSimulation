package com.sparta;

public class App {
    public static int totalCentres = 0; //to be incremented as centres are generated
    public static int fullCentres = 0; //to be incremented +1 when centres hit maxCapacity
    public static int totalTrainees = 0; //to be incremented as trainees are generated,
    // decremented when centres perform intake and waitingList == 0
    public static int waitingList = 0; //incremented after centres perform their intakes,
    // decremented first before totalTrainees
    public static void main(String[] args) {

    }
}
