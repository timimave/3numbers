package MyGit;

import java.util.Scanner;

public class StringCalculator {
    static Scanner scanner = new Scanner(System.in);
    static String operator;
    public static String[] array;
    public static void main(String[] args) { startOperation(); }

    public static void startOperation() {
        String operationResult = getOperation();
        if (operationResult.length() > 40) {
            String result = operationResult.substring(40);
            result = operationResult.replaceFirst(result, "") + "...";
            System.out.println(result);
        } else {
            System.out.println(operationResult);
        }
    }
    public static String getOperation() {
        String  input = scanner.nextLine();
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
        return calculate(a, operator, b);
    }
    public static String calculate(String a, String operator, String b) {
        try {
            return switch (operator) {
                case "+" -> a.concat(b);
                case "-" -> a.replaceFirst(b, "");
                case "*" -> a.repeat(Integer.parseInt(b));
                case "/" -> a.substring(0, a.length() / Integer.parseInt(b));
                default -> null;
            };
        } catch (Exception exception) {
            System.out.println("Неверное действие: " + exception);
        }
        return null;
    }
}


/*Пример работы программы:
Input:
"100" + "500"

Output:
"100500"

Input:
"Hi World!" - "World!"

Output:
"Hi "

Input:
"Bye-bye!" - "World!"

Output:
"Bye-bye!"

Input:
"Java" * 5

Output:
"JavaJavaJavaJavaJava"

Input:
"Example!!!" / 3

Output:
"Exa"*/
