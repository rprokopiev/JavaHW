import java.util.LinkedList;
import java.util.Random;

/**Пусть дан LinkedList с несколькими элементами. 
 * Реализуйте метод, который вернет “перевернутый” список. */

public class RevertLinkedList {

    public static void main(String[] args) {
        LinkedList<Integer> list = RandomIntListGenerator(7, 1, 10);
        System.out.println(list);
        list = GetReturnList(list);
        System.out.println(list);

    }
    // создание листа случайных чисел
    private static LinkedList<Integer> RandomIntListGenerator(Integer n, Integer min, Integer max) {
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            Random r = new Random();
            list.add(r.nextInt(min, max));
        }
        return list;
    }

    private static LinkedList<Integer> GetReturnList(LinkedList<Integer> list){
        for (int i = list.size()-1; i > -1; i--) {
            list.add(list.get(i));
            list.remove(i);
        }
        return list;
    }
}