package com.example.tdd.katas.kata1.util;

import com.example.tdd.katas.kata1.dto.DelimiterMatchResult;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DelimiterMatcher {

    private static final String NEW_DELIMITER = "//(?<delimiter>.*)\\n(?<numbers>\\S*)";

    public static DelimiterMatchResult matchExpression(String input) {
        Pattern pattern = Pattern.compile(NEW_DELIMITER, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(input);

        if (matcher.find()) {
            String delimiter = matcher.group("delimiter");
            String numbers = matcher.group("numbers");
            return DelimiterMatchResult.FOUND(delimiter, numbers);
        }
        return DelimiterMatchResult.NOT_FOUND(input);
    }


}
