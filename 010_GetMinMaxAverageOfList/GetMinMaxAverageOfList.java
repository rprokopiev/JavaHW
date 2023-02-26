import java.util.ArrayList;
import java.util.Random;

/**
 * Найти минимальное, максимальное и среднее арифметичское списка целых чисел .
 */

public class GetMinMaxAverageOfList {

    public static void main(String[] args) {
        ArrayList<Integer> list = RandomIntListGenerator(5, 1, 15);
        System.out.println(list);
        System.out.printf("Minimum number - %d \n", FindMinInList(list));
        System.out.printf("Maximum number - %d \n", FindMaxInList(list));
        System.out.printf("List Average - %.2f \n", FindAverageOfList(list));
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

    private static Integer FindMinInList(ArrayList<Integer> list){
        Integer min = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i) < min){
                min = list.get(i);
            }
        }
        return min;
    }

    private static Integer FindMaxInList(ArrayList<Integer> list){
        Integer max = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i) > max){
                max = list.get(i);
            }
        }
        return max;
    }

    private static Double FindAverageOfList(ArrayList<Integer> list){
        Double average = Double.valueOf(list.get(0));
        for (int i = 1; i < list.size(); i++) {
            average = average + Double.valueOf(list.get(i));
        }
        average = average/Double.valueOf(list.size());
        return average;
    }
}