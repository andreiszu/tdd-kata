package com.example.tdd.katas.kata1.util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StringSplitterTest {
    private static final Integer ITEM_1 = 1;
    private static final Integer ITEM_2 = 2;
    private static final Integer ITEM_3 = 3;


    private static final String DELIMITER = "alpha";
    private static final String MATCHING_INPUT = ITEM_1 + DELIMITER + ITEM_2 + DELIMITER + ITEM_3;
    private static final String NON_MATCHING_INPUT = ITEM_1 + "," + ITEM_2 + "," + ITEM_3;

    @Test
    void CommaDelimited_StringInput() {
        String input = ITEM_1 + "," + ITEM_2 + "," + ITEM_3;

        StringSplitter stringSplitter = new StringSplitter();

        String[] items = stringSplitter.splitNumbers(input);

        assertEquals(3, items.length);
        assertEquals(ITEM_1.toString(), items[0]);
        assertEquals(ITEM_2.toString(), items[1]);
        assertEquals(ITEM_3.toString(), items[2]);
    }


    @Test
    void NewLineDelimited_StringInput() {
        String input = ITEM_1 + "\n" + ITEM_2 + "\n" + ITEM_3;

        StringSplitter stringSplitter = new StringSplitter();

        String[] items = stringSplitter.splitNumbers(input);

        assertEquals(3, items.length);
        assertEquals(ITEM_1.toString(), items[0]);
        assertEquals(ITEM_2.toString(), items[1]);
        assertEquals(ITEM_3.toString(), items[2]);
    }

    @Test
    void NewLine_And_Comma_Delimited_StringInput() {
        String input = ITEM_1 + "\n" + ITEM_2 + "," + ITEM_3;

        StringSplitter stringSplitter = new StringSplitter();

        String[] items = stringSplitter.splitNumbers(input);

        assertEquals(3, items.length);
        assertEquals(ITEM_1.toString(), items[0]);
        assertEquals(ITEM_2.toString(), items[1]);
        assertEquals(ITEM_3.toString(), items[2]);
    }


    @Test
    void NewStrategy_With_Alpha_Delimited_Matching_StringInput() {

        StringSplitter stringSplitter = new StringSplitter();
        stringSplitter.addStrategy(new StringSplitStrategy(DELIMITER));

        String[] items = stringSplitter.splitNumbers(MATCHING_INPUT);

        assertEquals(3, items.length);
        assertEquals(ITEM_1.toString(), items[0]);
        assertEquals(ITEM_2.toString(), items[1]);
        assertEquals(ITEM_3.toString(), items[2]);
    }

    @Test
    void NewStrategy_With_NonMatching_StringInput() {

        StringSplitter stringSplitter = new StringSplitter();

        String[] items = stringSplitter.splitNumbers(NON_MATCHING_INPUT);

        assertEquals(3, items.length);
        assertEquals(ITEM_1.toString(), items[0]);
        assertEquals(ITEM_2.toString(), items[1]);
        assertEquals(ITEM_3.toString(), items[2]);
    }
}