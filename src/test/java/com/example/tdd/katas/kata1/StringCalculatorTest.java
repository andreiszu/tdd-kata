package com.example.tdd.katas.kata1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StringCalculatorTest {

    @Test
    void testCalculator_TwoNumbersInput(){
        StringCalculator stringCalculator = new StringCalculator();
        String input = "3,4";

        assertEquals(7, stringCalculator.add(input));
    }

    @Test
    void testCalculator_TwoNumbers_NewLineBetweenNumbers() {
        StringCalculator stringCalculator = new StringCalculator();
        String input = "1\n2\n3";

        Assertions.assertEquals(6, stringCalculator.add(input));
    }

    @Test
    void testCalculator_CustomDelimiter() {
        StringCalculator stringCalculator = new StringCalculator();
        String input = "//@\n1@2";
        Assertions.assertEquals(3, stringCalculator.add(input));
    }

}