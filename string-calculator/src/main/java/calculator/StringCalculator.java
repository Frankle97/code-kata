package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {
    int add(String text) {
        if (isEmpty(text)) {
            return 0;
        }

        String[] tokens = split(text);
        int[] numbers = toInts(tokens);
        return sum(numbers);
    }

    private int[] toInts(String[] tokens) {
        int[] ints = new int[tokens.length];
        for (int i = 0; i < tokens.length; i++) {
            ints[i] = Integer.parseInt(tokens[i]);
        }
        return ints;
    }

    private String[] split(String text) {
        Matcher matcher = Pattern.compile("//(.)\n(.*)").matcher(text);
        if (matcher.find()) {
            String customDelimiter = matcher.group(1);
            return matcher.group(2).split(customDelimiter);
        }
        return text.split("[,:]");
    }

    private boolean isEmpty(String text) {
        return text == null || text.equals(" ") || text.isEmpty();
    }

    private int sum(int[] numbers) {
        int sum = 0;
        for (int number : numbers) {
            sum += toPositive(number);
        }
        return sum;
    }

    private int toPositive(int number) {
        if (number < 0) {
            throw new RuntimeException();
        }
        return number;
    }
}
