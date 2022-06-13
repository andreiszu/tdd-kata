package com.example.tdd.katas.kata1.util;

import com.example.tdd.katas.kata1.dto.DelimiterMatchResult;
import org.junit.jupiter.api.Test;

import static com.example.tdd.katas.kata1.util.StringSplitter.DEFAULT_DELIMITER_1;
import static org.junit.jupiter.api.Assertions.assertEquals;

class DelimiterMatcherTest {
    private static final String ITEM_1 = "1";
    private static final String ITEM_2 = "5";

    private static final String CUSTOM_DELIMITER = "alpha";
    private static final String BASIC_DELIMITER = DEFAULT_DELIMITER_1;
    private static final String CUSTOM_DELIMITED_NUMBERS = ITEM_1 + CUSTOM_DELIMITER + ITEM_2;
    private static final String DELIMITER_PART = "//" + CUSTOM_DELIMITER + "\n";

    private static final String CUSTOM_DELIMITER_INPUT = DELIMITER_PART + CUSTOM_DELIMITED_NUMBERS;
    private static final String BASIC_INPUT = ITEM_1 + BASIC_DELIMITER + ITEM_2;

    @Test
    void testDelimiterMatcherFound() {
        String expectedNumbers = ITEM_1 + CUSTOM_DELIMITER + ITEM_2;
        String expectedDelimiter = CUSTOM_DELIMITER;

        DelimiterMatchResult delimiterMatchResult = DelimiterMatcher.matchExpression(CUSTOM_DELIMITER_INPUT);

        assertEquals(expectedNumbers, delimiterMatchResult.getNumbers());
        assertEquals(expectedDelimiter, CUSTOM_DELIMITER);
    }

    @Test
    void testDelimiterMatcherNotFound() {
        String expectedNumbers = ITEM_1 + BASIC_DELIMITER + ITEM_2;

        DelimiterMatchResult delimiterMatchResult = DelimiterMatcher.matchExpression(BASIC_INPUT);

        assertEquals(expectedNumbers, delimiterMatchResult.getNumbers());
    }

}