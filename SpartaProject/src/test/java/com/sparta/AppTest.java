package com.sparta;


import com.sparta.centreManager.Manager;
import com.sparta.generateCentres.genCentres;
import com.sparta.generateTrainees.genTrainees;
import com.sparta.getMonths.Input;
import io.cucumber.java.sl.Ce;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static com.sparta.App.getCentres;

public class AppTest {
    int waitingList;
    int totalTrainees;
    int fullCentres;
    int totalCentres;
    ArrayList<Centre> centreList = new ArrayList<>();


    @BeforeEach
    void setup(){
        ArrayList<Centre> centreList = new ArrayList<>();
        int waitingList = 0;
        int totalTrainees = 0;
        int fullCentres = 0;
        int totalCentres = 0;

    }
    @Test
    @DisplayName("check that it returns a number")
    void checkNumberReturn() {

        int var1 = genTrainees.generateTrainees(1);
        int var2 = genTrainees.generateTrainees(1);

        Assertions.assertEquals(false, var1 == var2);
    }
    @Test
    @DisplayName("Generate 6 centres over 12 months")
    void sixCentresOver12Months(){
        int months = 12;
        totalCentres = genCentres.generatecenter(months);
        Assertions.assertEquals(6, totalCentres);
    }
    @Test
    @DisplayName("6 Centres should be generated using the genCentre method")
    void genCentres(){
        String reporting = "A";
        int months = 12;
        int expectedCentres = 6;
        centreList = getCentres(months, reporting, centreList);
        Assertions.assertEquals(6, centreList.size());
    }

    @Test
    @DisplayName("24 months should generate more trainees than 12")
    void moreAfter24(){
        ArrayList<Centre> twentyFourMonths = new ArrayList<>();
        centreList = getCentres(12, "B", centreList);
        int traineesAfter12 = 0;
        int traineesAfter24 =0;
        twentyFourMonths = getCentres(24, "B", twentyFourMonths);
        for (int i = 0; i<centreList.size(); i++){
            traineesAfter12 += centreList.get(i).currentCapacity;
        } for (int j = 0; j<centreList.size();j++){
            traineesAfter24 += twentyFourMonths.get(j).currentCapacity;
        }
        Assertions.assertTrue(traineesAfter12<traineesAfter24, "There are more trainees after 24 months");
    }
    @Test
    @DisplayName("More centres full after 24 months than 12 months")
    void moreCentresFullAfter24() {
        ArrayList<Centre> twentyFourMonths = new ArrayList<>();
        centreList = getCentres(12, "B", centreList);
        int fullAfter12 = 0;
        int fullAfter24 = 0;
        twentyFourMonths = getCentres(24, "B", twentyFourMonths);
        for (Centre centre : centreList) {
            if (centre.isFull) fullAfter12++;
        }
        for (Centre centre : twentyFourMonths) {
            if (centre.isFull) fullAfter24++;
        }
        Assertions.assertTrue(fullAfter12<fullAfter24, "There are more full centres after 24 months");
    }

    @Test
    @DisplayName("Test max centre capacity cannot be incremented above 100")
    void testMaxCapacity(){
        Centre centre = new Centre();
        centre.setCurrentCapacity(100);
        centre.setCurrentCapacity(101);
        Assertions.assertEquals(100, centre.getCurrentCapacity());
    }
    @Test
    @DisplayName("Test to see if setting to max turns centre to full")
    void convertsToFull(){
        Centre centre1 = new Centre();
        Centre centre2 = new Centre();
        centre1.setCurrentCapacity(100);
        centre2.setCurrentCapacity(50);
        Assertions.assertTrue(centre1.isFull != centre2.isFull, "Setting a centre to max capacity makes it full");

    }
}



