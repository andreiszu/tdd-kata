package com.example.tdd.katas.kata1.util;

import java.util.ArrayList;
import java.util.List;

public class StringSplitter {

    public static final String DEFAULT_DELIMITER_1 = ",";
    public static final String DEFAULT_DELIMITER_2 = "\n";
    private final static String CUSTOM_DELIMITER = ";";

    private final static StringSplitStrategy DEFAULT_1_STRATEGY = new StringSplitStrategy(DEFAULT_DELIMITER_1);
    private final static StringSplitStrategy DEFAULT_2_STRATEGY = new StringSplitStrategy(DEFAULT_DELIMITER_2);

    private List<StringSplitStrategy> splitStrategyList;

    public StringSplitter() {
        this.splitStrategyList = new ArrayList<>(List.of(DEFAULT_1_STRATEGY, DEFAULT_2_STRATEGY));
    }

    public String[] splitNumbers(String input) {
        String resultString = input;
        for (StringSplitStrategy stringSplitStrategy : splitStrategyList) {
            resultString = resultString.replace(stringSplitStrategy.getDelimiter(), CUSTOM_DELIMITER);
        }
        return resultString.trim().split(CUSTOM_DELIMITER);
    }

    public void addStrategy(StringSplitStrategy stringSplitStrategy) {
        splitStrategyList.add(stringSplitStrategy);
    }

}
