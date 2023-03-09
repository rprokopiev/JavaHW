import java.util.Scanner;

/**
 * LaptopSelection
 */
public class LaptopSelection {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Select Laptop name");
        Integer name = GetRequiredIntegerFromUser("1 - HP\n2 - Lenovo\n3 - Dell\n4 - Samsung", scanner, 1, 4);
        System.out.println("Select RAM");
        Integer ram = GetRequiredIntegerFromUser("1 - 8Gb\n2 - 16Gb\n3 - 4Gb", scanner, 1, 3);
        System.out.println("Select Hard Drive");
        Integer hd = GetRequiredIntegerFromUser("1 - 1000Gb\n2 - 500Gb\n3 - 250Gb", scanner, 1, 3);
        System.out.println("Select OS");
        Integer os = GetRequiredIntegerFromUser("1 - Windows\n2 - Linux", scanner, 1, 2);
        System.out.println("Select Color");
        Integer color = GetRequiredIntegerFromUser("1 - black\n2 - white", scanner, 1, 2);

        scanner.close();

        Laptops userSelection = new Laptops(LaptopsSet.LaptopNames().get(name), LaptopsSet.RamAmount().get(ram),
                LaptopsSet.HdAmount().get(hd), LaptopsSet.OsNames().get(os), LaptopsSet.ColorNames().get(color));

        System.out.println("User selected:");
        System.out.println(userSelection);

        if (LaptopsSet.main(args).contains(userSelection) == true){
            System.out.println("Selected settings are available");
        }
        else{
            System.out.println("Not found");
        } 
    }

    // получить от пользователя Integer в заданом диапазоне
    private static Integer GetRequiredIntegerFromUser(String message, Scanner scan, int min, int max) {
        Integer input = GetIntegerFromUser(message, scan);
        while (input > max || input < min) {
            input = GetIntegerFromUser(message, scan);
        }
        return input;
    }

    // получить от пользователя Integer
    private static Integer GetIntegerFromUser(String message, Scanner scan) {
        System.out.println(message);
        String input = scan.nextLine();
        while (IsInteger(input) == false) {
            System.out.println(message);
            input = scan.nextLine();
        }
        return Integer.parseInt(input);
    }

    // проверка, если пользователь ввёл integer
    private static Boolean IsInteger(String st) {
        for (int i = 0; i < st.length(); i++) {
            char l = st.charAt(i);
            if (i == 0 && l == '0' && st.length() > 1) {
                return false;
            }
            if (!Character.isDigit(l)) {
                return false;
            }
        }
        return true;
    }
}