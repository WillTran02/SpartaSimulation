package com.sparta.getMonths;

import java.util.Scanner;

public class getMonths {

    public static void main(String args[]) {

        Scanner console = new Scanner(System.in);
        String input;
        int months;
        boolean isValid;

        do {
            isValid = true; // reset the validity
            System.out.println("Please enter the months of months you would like to run the simulation for: ");
            input = console.nextLine();


            try {
                months = Integer.parseInt(input);
                if (months < 12) {
                    isValid = false;
                    System.out.println("Please enter a minimum of 12 months: ");
                }
            } catch (NumberFormatException e) {
                isValid = false;
                System.out.println("You have not entered a months, please try again: ");
            }

        } while (!isValid);
    }
}
