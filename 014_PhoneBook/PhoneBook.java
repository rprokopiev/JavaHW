import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Реализуйте структуру телефонной книги с помощью HashMap, учитывая, что один
 * человек может иметь несколько телефонов.
 */
public class PhoneBook {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        HashMap<String, ArrayList<Integer>> phonebook = new HashMap<>();
        phonebook = FillPhonebook(phonebook, scan);
        System.out.println(phonebook);

    }

    // заполнить книгу вручную
    private static HashMap <String, ArrayList<Integer>> FillPhonebook (HashMap <String, ArrayList<Integer>> book, Scanner scan){
        Integer moreRecords = 1;
        while (moreRecords == 1){
            System.out.println("Enter Name");
            String name = scan.nextLine();
            Integer moreNumbers = 1;
            ArrayList <Integer> numbers = new ArrayList<>();
            while (moreNumbers == 1){
                numbers.add(GetIntegerFromUser("Enter number", scan));
                String selection = "More NUMBERS?\nSelect 1 - YES,\nSelect 2 - NO";
                moreNumbers = GetRequiredIntegerFromUser(selection, scan, 1, 2);
            }
            book.put(name,numbers);
            String selection2 = "More RECORDS?\nSelect 1 - YES,\nSelect 2 - NO";
            moreRecords = GetRequiredIntegerFromUser(selection2, scan, 1, 2);
        }
        return book;
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