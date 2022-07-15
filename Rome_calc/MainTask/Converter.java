package MyGit.Rome_calc.MainTask;

import java.util.Scanner;

import static MyGit.Rome_calc.MainTask.Calculator.Calculate;

public class Converter {
    static Scanner scanner = new Scanner(System.in);
    static String operator;


    private static final int[] intervals =
            {0, 1, 4, 5, 9, 10, 40, 50, 90,
                    100, 400, 500, 900, 1000};
    private static final String[] numerals =
            {"", "I", "IV", "V", "IX", "X", "XL",
                    "L", "XC", "C", "CD", "D", "CM", "M"};
    public static String start() {
        return getOperation(scanner.nextLine());
    }

    public static String toRoman(long num) {
        //String str = getOperation(scanner.nextLine());
        // long num = Integer.parseInt(str);
        if (num > 0) {
            StringBuilder build = new StringBuilder();
            final romanNumber[] values = romanNumber.values();
            for (int i = values.length - 1; i >= 0; i--) {
                while (num >= values[i].value) {
                    build.append(values[i]);
                    num -= values[i].value;
                }
            }
            return build.toString();
        } else {
            throw new IllegalArgumentException();
        }
    }
    public static String getOperation(String input) {
       // String input = scanner.nextLine();
        String[] array = input.split("");
        label:
        for (String s : array) {

            switch (s) {
                case "+":
                    operator = "+";
                    break label;
                case "-":
                    operator = "-";
                    break label;
                case "*":
                    operator = "*";
                    break label;
                case "/":
                    operator = "/";
                    break;
            }
        }

        String[] splitter = input.split("[+\\-*/]", 2);
        String a = splitter[0].replaceAll(" ", "");
        String b = splitter[1].replaceAll(" ", "");
        return String.valueOf(Calculate(toArabic_A(a), operator, toArabic_B(b)));

    }



    public static int toArabic_A(String roman) {

        int result = 0;
        for (int i = intervals.length - 1; i >= 0; i--) {
            while (roman.indexOf(numerals[i]) == 0 && numerals[i].length() > 0) {
                result += intervals[i];
                roman = roman.substring(numerals[i].length());
            }
        }
        return result;
    }

    public static int toArabic_B(String roman) {

        int result = 0;
        for (int i = intervals.length - 1; i >= 0; i--) {
            while (roman.indexOf(numerals[i]) == 0 && numerals[i].length() > 0) {
                result += intervals[i];
                roman = roman.substring(numerals[i].length());
            }
        }
        return result;
    }
}










/* public static int toArabic(String roman) {
        final romanNumber[] values = romanNumber.values();
        int result = 0;
        for (int i = intervals.length-1; i >= 0; i-- ) {
            while (roman.indexOf(numerals[i]) == 0 && numerals[i].length() > 0) {
                result += intervals[i];
                roman = roman.substring(numerals[i].length());
            }
        }
        return result;
    }*/