import java.util.Scanner;

/*
* Вычислить n-ое треугольного число(сумма чисел от 1 до n), 
* n! (произведение чисел от 1 до n)
*/

public class TrinagN_Factorial {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int a = Selection("1 - Triangle n \n2 - Factorial n", scan);
        while (a > 2 || a < 1) {
            a = Selection("1 - Triangle n \n2 - Factorial n", scan);
        }
        int n = Selection("Enter number > 0", scan);
        while (n <= 0) {
            n = Selection("Enter number > 0", scan);
        }
        scan.close();
        if (a == 1) {
            System.out.println(Triangle(n));
        } else {
            System.out.println(Factorial(n));
        }
    }

    static int Selection(String message, Scanner scan) {
        System.out.println(message);
        int userSelection = Integer.parseInt(scan.nextLine());
        return userSelection;
    }

    static int Triangle(int n) {
        int j = 0;
        for (int i = 1; i < n + 1; i++) {
            j = j + i;
        }
        return j;
    }

    static int Factorial(int n) {
        int j = 1;
        for (int i = 1; i < n + 1; i++) {
            j = j * i;
        }
        return j;
    }
}