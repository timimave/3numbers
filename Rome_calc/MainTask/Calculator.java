package MyGit.Rome_calc.MainTask;

public class Calculator {

    public static int Calculate(int a, String operator, int b) {
        if (a > 10 || b > 10) {
            try {
                throw new Exception();
            } catch (Exception e) {
                e.printStackTrace();
                System.err.println("Ограничение вводимого числа до 10");
            }
        }
            if (a != 0 && b != 0)
                if (operator.equals("+")) return a + b;
                else if (operator.equals("-")) return a - b;
                else if (operator.equals("/")) return a / b;
                else if (operator.equals("*")) return a * b;
                else return 0;


        if (a == 0 || b == 0)
            if (operator.equals("/")) return 0;
            else if (operator.equals("-")) return a - b;
            else if (operator.equals("+")) return a + b;
            else if (operator.equals("*")) return a * b;
            else return 0;
        return 0;
    }


}
