import java.util.ArrayList;
import java.util.Random;

/** Реализовать алгоритм сортировки слиянием. */

public class MergeSort {

    public static void main(String[] args) {
        ArrayList<Integer> listToSort = RandomIntListGenerator(5, 1, 20);
        System.out.println(listToSort);
        listToSort = MergeSortRecursion(listToSort);
        System.out.println(listToSort);
    }

    // создание листа случайных чисел
    private static ArrayList<Integer> RandomIntListGenerator(Integer n, Integer min, Integer max) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            Random r = new Random();
            list.add(r.nextInt(min, max));
        }
        return list;
    }

    // получение нового листа с половиной аргументов входящего листа
    // если n == false - левая половина, 
    // если n == true - правая полоdина.
    private static ArrayList<Integer> ListHalfDivision(ArrayList<Integer> list, Boolean n) {
        Integer j = list.size() / 2;
        ArrayList<Integer> result = new ArrayList<>();
        if (n == false) {
            for (int i = 0; i < j; i++) {
                result.add(list.get(i));
            }
            return result;
        } else {
            for (int i = j; i < list.size(); i++) {
                result.add(list.get(i));
            }
            return result;
        }
    }

    // получение сортированного листа из 2х предварительно сортированных листов
    private static ArrayList<Integer> MergeSortOfSortedLists(ArrayList<Integer> list1, ArrayList<Integer> list2) {
        ArrayList<Integer> result = new ArrayList<>();
        int resultSize = list1.size() + list2.size();
        int i = 0;
        int j = 0;
        for (int k = 0; k < resultSize; k++) {
            if (list1.get(i) < list2.get(j)) {
                result.add(list1.get(i));
                i++;
                if (i == list1.size()) {
                    while (j < list2.size()) {
                        result.add(list2.get(j));
                        j++;
                    }
                    return result;
                }
            } else if (list1.get(i) > list2.get(j)) {
                result.add(list2.get(j));
                j++;
                if (j == list2.size()) {
                    while (i < list1.size()) {
                        result.add(list1.get(i));
                        i++;
                    }
                    return result;
                }
            } else {
                result.add(list1.get(i));
                result.add(list2.get(j));
                i++;
                if (i == list1.size()) {
                    while (j < list2.size()) {
                        result.add(list2.get(j));
                        j++;
                    }
                    return result;
                }
                j++;
                if (j == list2.size()) {
                    while (i < list1.size()) {
                        result.add(list1.get(i));
                        i++;
                    }
                    return result;
                }
            }
        }
        return result;
    }

    // получение сортированного листа из 2х одно-аргументных листов.
    private static ArrayList<Integer> MergeSortOfOneArgumentsLists(ArrayList<Integer> list1, ArrayList<Integer> list2) {
        ArrayList<Integer> result = new ArrayList<>();
        System.out.println("TwoOf1__START");
        if (list1.get(0) < list2.get(0)) {
            result.add(list1.get(0));
            result.add(list2.get(0));
        } else if (list1.get(0) > list2.get(0)) {
            result.add(list2.get(0));
            result.add(list1.get(0));
        } else {
            result.add(list1.get(0));
            result.add(list2.get(0));
        }
        System.out.println("TwoOf1END");
        return result;
    }

    // основной рекурсивынй метод для сортировки слияния.
    private static ArrayList<Integer> MergeSortRecursion(ArrayList<Integer> list) {
        ArrayList<Integer> right = ListHalfDivision(list, true);
        ArrayList<Integer> left = ListHalfDivision(list, false);
        if (right.size() > 1 && left.size() > 1) {
            System.out.println("1ST");
            return MergeSortOfSortedLists(MergeSortRecursion(left), MergeSortRecursion(right));
        } else if (right.size() == 1 && left.size() > 1) {
            return MergeSortOfSortedLists(MergeSortRecursion(left), right);
        } else if (right.size() > 1 && left.size() == 1) {
            return MergeSortOfSortedLists(MergeSortRecursion(right), left);
        } else {
            ArrayList<Integer> result = MergeSortOfOneArgumentsLists(left, right);
            return result;
        }
    }

}