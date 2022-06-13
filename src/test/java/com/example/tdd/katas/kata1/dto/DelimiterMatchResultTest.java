package com.example.tdd.katas.kata1.dto;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DelimiterMatchResultTest {

    @Test
    void shouldReturnNotFoundDelimiterMatchResult() {
        String numbers = "NUMBERS";
        Boolean found = false;

        DelimiterMatchResult delimiterMatchResult = DelimiterMatchResult.NOT_FOUND(numbers);

        assertEquals(found, delimiterMatchResult.isFound());
        assertEquals(numbers, delimiterMatchResult.getNumbers());
    }

    @Test
    void shouldReturnFoundDelimiterMatchResult() {
        String numbers = "NUMBERS";
        String delimiter = "tony";
        Boolean found = true;

        DelimiterMatchResult delimiterMatchResult = DelimiterMatchResult.FOUND(delimiter, numbers);

        assertEquals(found, delimiterMatchResult.isFound());
        assertEquals(numbers, delimiterMatchResult.getNumbers());
        assertEquals(delimiter, delimiterMatchResult.getDelimiter());
    }

}