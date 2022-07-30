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
        // System.out.println(text);

        boolean foundWords = Pattern.matches("[^ABEFGHJKNOPQRSTUWYZ\\d]+", text);
        boolean foundNum = Pattern.matches("[^A-Z]+", text);

        if (foundWords) {
            try {
                answer = Long.parseLong(Converter.getOperation(text));
                System.out.println(Converter.toRoman(answer));
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Ошибка! т.к. строка не является математической операцией");
            }
        } else if (foundNum) {
            // System.out.println("Цифры");
            try {
                String[] splitter = text.split("[+\\-*/]", 2);
                String a = splitter[0].replaceAll(" ", "");
                String b = splitter[1].replaceAll(" ", "");
                System.out.println
                        (Calculator.Calculate(Integer.parseInt(a), operator, Integer.parseInt(b)));
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Ошибка! т.к. строка не является математической операцией");
            } catch (NumberFormatException e) {
                System.out.println("Ошибка! т.к. формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
            }
        } else {
            System.out.println("Ошибка! т.к. используются одновременно разные системы счисления");
        }

    }
}
