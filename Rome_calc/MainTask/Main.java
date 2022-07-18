package MyGit.Rome_calc.MainTask;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static String operator;
    static long answer;

    public static void main(String[] args) {
        start();
    }
    public static void start() {
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

         boolean foundWords = Pattern.matches("\\D+", text);
         boolean foundNums = Pattern.matches("[^A-Z]+", text);

        if (foundWords) {
            answer = Long.parseLong(Converter.getOperation(text));
            System.out.println(Converter.toRoman(answer));
        } else if(foundNums) {
            System.out.println("Цифры");
            String[] splitter = text.split("[+\\-*/]", 2);
            String a = splitter[0].replaceAll(" ", "");
            String b = splitter[1].replaceAll(" ", "");
            System.out.println(Calculator.Calculate(Integer.parseInt(a), operator, Integer.parseInt(b)));
        }

    }
}















/*private static String convertToRoman(int num) {
        StringBuilder result = new StringBuilder();
        while(num > 0) {
            if(num >= 1000) {
                result.append("M");
                num -= 1000;
            }else if(num >= 900){
                result.append("CM");
                num -= 900;
            }
            else if(num >= 500){
                result.append("D");
                num -= 500;
            }else if(num >= 400){
                result.append("CD");
                num -= 400;
            }else if(num >= 100){
                result.append("C");
                num -= 100;
            }else if(num >= 90){
                result.append("XC");
                num -= 90;
            }else if(num >= 50){
                result.append("L");
                num -= 50;
            }else if(num >= 40){
                result.append("XL");
                num -= 40;
            }
            else if(num >= 10){
                result.append("X");
                num -= 10;
            }else if(num >= 9){
                result.append("IX");
                num -= 9;
            }
            else if(num >= 5){
                result.append("V");
                num -= 5;
            }else if(num >= 4){
                result.append("IV");
                num -= 4;
            }else if(num >= 1){
                result.append("I");
                num -= 1;
            }

            else {
                break;
            }
        }

        return result.toString();
    }*/



/* String[] roman = {"M", "XM", "CM", "D", "XD", "CD", "C",
                "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int[] arabic = {1000, 990, 900, 500, 490, 400, 100, 90,
                50, 40, 10, 9, 5, 4, 1};

        StringBuilder result = new StringBuilder();
        int i = 0;
        while (true) {
            if (number <= 0 && arabic.length != (i - 1)) break;
            while ((number - arabic[i]) >= 0) {
                number = number - arabic[i];
                result.append(roman[i]);
            }
            i++;
        }
        return result.toString();*/



// -------------------------------------------------------------------------------

//        String input = scanner.nextLine();
//        String[] array = input.split("");
//        label:
//        for (String s : array) {
//
//            switch (s) {
//                case "+":
//                    operator = "+";
//                    break label;
//                case "-":
//                    operator = "-";
//                    break label;
//                case "*":
//                    operator = "*";
//                    break label;
//                case "/":
//                    operator = "/";
//                    break;
//            }
//        }
//
//        // сделать проверку на символы и взависимости от того вызывать нужный метод
//        StringBuilder builder = new StringBuilder();
//        for (String item : array) {
//            builder.append(item);
//        }
//        //  System.out.println(builder);
//        String test = String.valueOf(builder);
//        System.out.println(test);
//
//
//        boolean foundWords = Pattern.matches("\\D+", test);
//        boolean foundNums = Pattern.matches("[^A-Z]+", test);
//        //  System.out.println("words: " + foundWords);
//        //  System.out.println("nums: " + foundNums);;
//
//        if (foundWords) {
//            answer = Long.parseLong(Converter.getOperation(test));
//            System.out.println(Converter.toRoman(answer));
//        } else
//            System.out.println("Цифры");
//        String[] splitter = test.split("[+\\-*/]", 2);
//        String a = splitter[0].replaceAll(" ", "");
//        String b = splitter[1].replaceAll(" ", "");
//        System.out.println(Calculator.Calculate(Integer.parseInt(a), operator, Integer.parseInt(b)));


//        // System.out.println(builder);
//        for (int i = 0; i < array.length; i++) {
//            if (array[i].equals("I")) { // или или или или ...
//                Converter.getOperation(test);
//            } else if (array[i].equals("1")) { // или или или или ...
//                String[] splitter = test.split("[+\\-*/]", 2);
//                String a = splitter[0].replaceAll(" ", "");
//                String b = splitter[1].replaceAll(" ", "");
//                System.out.println(Calculator.Calculate(Integer.parseInt(a),operator,Integer.parseInt(b)));
//            }
//        }

//--------------------------------------------------------------------