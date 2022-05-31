package com.sparta;


import com.sparta.generateTrainees.genTrainees;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class AppTest {
    @Test
    @DisplayName("check that it returns a number")
    void checkNumberReturn() {

        int var1 = genTrainees.generateTrainees(1);
        int var2 = genTrainees.generateTrainees(1);

        Assertions.assertEquals(false, var1 == var2);
    }


}
