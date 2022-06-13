package com.example.tdd.katas.kata1.dto;

public class DelimiterMatchResult {
    private Boolean found = true;
    private String delimiter;
    private String numbers;

    private DelimiterMatchResult(String delimiter, String numbers, Boolean found) {
        this.delimiter = delimiter;
        this.numbers = numbers;
        this.found = found;
    }

    public static DelimiterMatchResult NOT_FOUND(String numbers) {
        DelimiterMatchResultBuilder delimiterMatchResultBuilder =
                new DelimiterMatchResultBuilder()
                .withNumbers(numbers)
                .isFound(false);
        return delimiterMatchResultBuilder.build();
    }

    public static DelimiterMatchResult FOUND(String delimiter, String numbers) {
        DelimiterMatchResultBuilder delimiterMatchResultBuilder =
                new DelimiterMatchResultBuilder()
                .withNumbers(numbers)
                .withDelimiter(delimiter)
                .isFound(true);
        return delimiterMatchResultBuilder.build();
    }

    private static class DelimiterMatchResultBuilder {
        private String delimiter;
        private String numbers;
        private Boolean found;

        public DelimiterMatchResultBuilder withDelimiter(String delimiter) {
            this.delimiter = delimiter;
            return this;
        }

        public DelimiterMatchResultBuilder withNumbers(String numbers) {
            this.numbers = numbers;
            return this;
        }

        public DelimiterMatchResultBuilder isFound(Boolean found) {
            this.found = found;
            return this;
        }

        public DelimiterMatchResult build() {
            return new DelimiterMatchResult(this.delimiter, this.numbers, this.found);
        }
    }

    public String getDelimiter() {
        return delimiter;
    }

    public String getNumbers() {
        return numbers;
    }

    public Boolean isFound() {
        return found;
    }
}
