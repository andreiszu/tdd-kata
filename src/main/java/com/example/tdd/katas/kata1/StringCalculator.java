package com.example.tdd.katas.kata1;


import com.example.tdd.katas.kata1.dto.DelimiterMatchResult;
import com.example.tdd.katas.kata1.util.DelimiterMatcher;
import com.example.tdd.katas.kata1.util.StringSplitStrategy;
import com.example.tdd.katas.kata1.util.StringSplitter;

public class StringCalculator {

    private static final String NEW_DELIMITER = "//(?<delimiter>.*)\\n(?<numbers>\\S*)";

    public int add(String input) {

        if (input.isEmpty()) return 0;

        int sum = 0;

        StringSplitter stringSplitter = new StringSplitter();

        DelimiterMatchResult delimiterMatchResult = DelimiterMatcher.matchExpression(input);

        if (delimiterMatchResult.isFound()) {
            stringSplitter.addStrategy(new StringSplitStrategy(delimiterMatchResult.getDelimiter()));
        }

        String[] splitNumbers = stringSplitter.splitNumbers(delimiterMatchResult.getNumbers());

        for (String number : splitNumbers) {
            sum += Integer.parseInt(number);
        }

        return sum;
    }

}
