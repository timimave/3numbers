package MyGit.Rome_calc.MainTask;

import static MyGit.Rome_calc.MainTask.Calculator.Calculate;

public class Converter {

    static String operator;


    private static final int[] intervals =
            {0, 1, 4, 5, 9, 10, 40, 50, 90,
                    100, 400, 500, 900, 1000};
    private static final String[] numerals =
            {"", "I", "IV", "V", "IX", "X", "XL",
                    "L", "XC", "C", "CD", "D", "CM", "M"};


    public static String toRoman(long num) {

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
            System.out.println("Ошибка! в римской системе нет отрицательных чисел");
            throw new IllegalArgumentException();
        }
    }
    public static String getOperation(String input) {

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
        return String.valueOf(Calculate(toArabic(a), operator, toArabic(b)));

    }

    public static int toArabic(String roman) {

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