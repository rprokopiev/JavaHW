import java.util.LinkedList;
import java.util.Scanner;

/**
 * Реализуйте очередь с помощью LinkedList со следующими методами:
 * enqueue() - помещает элемент в конец очереди,
 * dequeue() - возвращает первый элемент из очереди и удаляет его,
 * first() - возвращает первый элемент из очереди, не удаляя.
 */

public class LinkedListQueue {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        LinkedList<Integer> list = GetIntegerListFromUser("Enter 5 numbers to make a list", scan, 5);
        Integer methodSelection = GetRequiredIntegerFromUser("Enter 1 for enqueue(),\n2 for dequeue(),\n3 for first() ", scan, 1, 3);
        System.out.println(list);
        if (methodSelection == 1){
            Integer n = GetRequiredIntegerFromUser("Enter Index 0-4", scan, 0, 4);
            list = Enqueue(list,n);
            System.out.println(list);
        }
        else if (methodSelection == 2){
            list = Dequeue(list);
            System.out.println(list);
        }
        else{
            System.out.println(list.getFirst());
            System.out.println(list);
        }
    }
    
    private static LinkedList<Integer> Enqueue(LinkedList<Integer> list, Integer n) {
        for (int i = 0; i < list.size(); i++) {
            if (i == n){
                list.add(list.get(i));
                list.remove(i);
            }
        }
        return list;
    }

    private static LinkedList<Integer> Dequeue(LinkedList<Integer> list) {
        int i = list.get(0);
        System.out.println(i);
        list.removeFirst();
        return list;
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

    // получить от пользователя LinkedList заданного размера
    private static LinkedList<Integer> GetIntegerListFromUser(String message, Scanner scan, Integer n) {
        System.out.println(message);
        LinkedList<Integer> list = new LinkedList<>();
        String input = "";
        for (int i = 0; i < n; i++) {
            input = scan.nextLine();
            while (IsInteger(input) == false) {
                System.out.println("Enter number");
                input = scan.nextLine();
            }
            list.add(Integer.parseInt(input));
        }
        return list;
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