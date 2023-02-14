/*
 * Вывести все простые числа от 1 до 1000
 */
public class GetPrimeNumbersOfN {
    public static void main(String[] args) {
        // System.out.println(3%2);
        for (int i = 2; i < 1001; i++) {     
            if (i == 2) {
                System.out.print(i);
                System.out.print(" ");
            }
            int count = 0;
            if (i % 2 != 0) {
                for (int j = 1; j <= i; j++) {
                    if (i % j == 0) {
                        count += 1;
                    }
                }

                if (count <= 2) {
                    System.out.print(i);
                    System.out.print(" ");
                }
            }
        }
    }
}