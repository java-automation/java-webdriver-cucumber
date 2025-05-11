package support;

public class CodingChallengePractice {

    public static void main(String[] args) {
        swapNums(3, 5);
        mathOps(3, 5);
        divBy3and5(15);
    }

    public static void swapNums(int a, int b) {
        System.out.println("Before swapping: a = " + a + " b = " + b);
        int temp = a;
        a = b;
        b = temp;
        System.out.println("After swapping: a = " + a + " b = " + b);
    }

    public static void mathOps(int a, int b) {
        System.out.println("Addition: " + (a + b));
        System.out.println("Subtraction: " + (a - b));
        System.out.println("Multiplication: " + (a * b));
        System.out.println("Division: " + (a / b));
    }

    public static double calcMathOpsSwitch(int a, int b, String operator) {
        switch (operator) {
            case "+":
                return a + b;
            case "-":
                return a - b;
            case "*":
                return a * b;
            case "/":
                return a / b;
            default:
                return 0;
        }
    }

    public static void divBy3and5(int n) {
        if (n % 3 == 0 && n % 5 == 0) {
            System.out.println("Div by 3 and 5");
        } else if (n % 5 == 0) {
            System.out.println("Div by 5");
        }else if (n % 3 == 0) {
            System.out.println("Div by 3");
        } else {
            System.out.println("Not div by 3 or 5");
        }
    }

}