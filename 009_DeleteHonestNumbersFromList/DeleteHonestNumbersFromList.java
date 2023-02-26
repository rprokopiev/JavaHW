import java.util.ArrayList;
import java.util.Random;

/** Пусть дан произвольный список целых чисел. Удалить из него чётные числа. */

public class DeleteHonestNumbersFromList {

    public static void main(String[] args) {
        ArrayList<Integer> list = RandomIntListGenerator(8, 1, 15);
        System.out.println(list);
        list = RemoveHonestNumbersFromList(list);
        System.out.println(list);
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

    private static ArrayList<Integer> RemoveHonestNumbersFromList(ArrayList<Integer> list){
        for (int i = 0; i < list.size(); i++){
            if (list.get(i)%2 == 0){
                list.remove(i);
                i--;
            }
        }
        return list;
    }
}