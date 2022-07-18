package MyGit.Rome_calc.MainTask;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Start {
    static Scanner scanner = new Scanner(System.in);
    static String operator;
    static long answer;
    public static void run() {
        String input = scanner.nextLine();
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
        StringBuilder builder = new StringBuilder();
        for (String item : array) {
            builder.append(item);
        }
        String text = String.valueOf(builder);
        System.out.println(text);

        boolean foundWords = Pattern.matches("[^ABEFGHJKNOPQRSTUWYZ\\d]+", text);
        boolean foundNums = Pattern.matches("[^A-Z]+", text);

        if (foundWords) {
            answer = Long.parseLong(Converter.getOperation(text));
            System.out.println(Converter.toRoman(answer));
        } else if(foundNums) {
            System.out.println("Цифры");
            String[] splitter = text.split("[+\\-*/]", 2);
            String a = splitter[0].replaceAll(" ", "");
            String b = splitter[1].replaceAll(" ", "");
            System.out.println
                    (Calculator.Calculate(Integer.parseInt(a), operator, Integer.parseInt(b)));
        } else {
            System.out.println("Ошибка! т.к. используются одновременно разные системы счисления");
        }

    }
}
