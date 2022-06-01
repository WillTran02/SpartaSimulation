package com.sparta.getMonths;

import java.util.Scanner;

public class Input {

    public static int getMonths() {

        Scanner console = new Scanner(System.in);
        String input;
        int months = 0;
        boolean isValid;

        do {
            isValid = true; // reset the validity
            System.out.println("Please enter the number of months you would like to run the simulation for: ");
            input = console.nextLine();


            try {
                months = Integer.parseInt(input);
                if (months < 12) {
                    isValid = false;
                    System.out.println("Please enter a minimum of 12 months: ");
                }
            } catch (NumberFormatException e) {
                isValid = false;
                System.out.println("You have not entered a number, please try again: ");
            }

        } while (!isValid);

        return months;
    }

    public static String reportOption() {

        Scanner console = new Scanner(System.in);
        String input;
        boolean isValid;

        do {
            isValid = true; // reset the validity
            System.out.println("Would you like to see [A] monthly reports, or a [B] summary at the end?");
            input = console.nextLine();
            if (!(input.equalsIgnoreCase("A")) || !(input.equalsIgnoreCase("B"))) {
                isValid = false;
                System.out.println("Please enter \"A\", or \"B\".");
            }
        } while (!isValid);

        return input;
    }
}
