
/*
 * Реализовать простой калькулятор Введите число 2 
 * Введите операцию 1 + 2 - 3 * 4
 * Введите число 2 
 * 2 + 2 = 4
 */
import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int a = Selection("Enter number 1 ", scan);
        int math = Selection("Enter math operation: \n1 for +\n2 for -\n3 for *\n4 for /", scan);
        while (math < 1 && math > 4) {
            math = Selection("Enter math operation: \n1 for +\n2 for -\n3 for *\n4 for /", scan);
        }
        int b = Selection("Enter number 2 ", scan);
        if (math == 1) {
            int c = a + b;
            System.out.println(String.format("%d + %d = %d", a, b, c));
        } else if (math == 2) {
            int c = a - b;
            System.out.println(String.format("%d - %d = %d", a, b, c));
        } else if (math == 3) {
            int c = a * b;
            System.out.println(String.format("%d * %d = %d", a, b, c));
        } else if (math == 4) {
            int c = a / b;
            System.out.println(String.format("%d / %d = %d", a, b, c));
        }

    }

    static int Selection(String message, Scanner scan) {
        System.out.println(message);
        int userSelection = Integer.parseInt(scan.nextLine());
        return userSelection;
    }
}
