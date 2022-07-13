package MyGit.Rome_calc.MainTask;

public class romanCalculator {
    private static final int[] intervals={0, 1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000};
    private static final String[] numerals={"", "I", "IV", "V", "IX", "X", "XL", "L", "XC", "C", "CD", "D", "CM", "M"};

    public static String toRoman(long num) {

        if (num <= 0) {
            throw new IllegalArgumentException();
        }
        StringBuilder buf = new StringBuilder();
        final romanNumber[] values = romanNumber.values();
        for (int i = values.length - 1; i >= 0; i--) {
            while (num >= values[i].value) {
                buf.append(values[i]);
                num -= values[i].value;
            }
        }
        return buf.toString();
    }
    public static int toArabic(String roman) {
        final romanNumber[] values = romanNumber.values();
        int result = 0;
        for (int i = intervals.length-1; i >= 0; i-- ) {
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