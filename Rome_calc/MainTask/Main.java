package MyGit.Rome_calc.MainTask;

import static Задачи_из_CODE_WARS.Calculators.MainTask.romanCalculator.toArabic;
import static Задачи_из_CODE_WARS.Calculators.MainTask.romanCalculator.toRoman;

public class Main {
    public static void main(String[] args) {
        int num = 5;
        String roman=toRoman(num);
        int arabic = toArabic(roman);
        System.out.println(arabic);
        System.out.println(roman);
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