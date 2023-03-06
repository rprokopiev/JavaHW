import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;

/**
 * Пусть дан список сотрудников: Иван, Пётр, Антон и так далее. 
 * Написать программу, которая найдет и выведет повторяющиеся имена с количеством повторений. 
 * Отсортировать по убыванию популярности.
 */
public class ListOfNamesSorting {

    public static void main(String[] args) {
        ArrayList <String> names = new ArrayList<>();
        names.add("Иван");
        names.add("Пётр");
        names.add("Антон");
        names.add("Иван");
        names.add("Пётр");
        names.add("Антон");
        names.add("Василий");
        names.add("Иван");
        names.add("Семён");
        System.out.println(names);
        System.out.println(FindDoublesInArray(names));
        DecreaseValueHashMapSorting(FindDoublesInArray(names));
    }

    private static HashMap <String, Integer> FindDoublesInArray(ArrayList <String> list){
        HashMap <String, Integer> doublesQuantity = new HashMap<>();
        for (int i = 0; i < list.size(); i++) {
            if (i == 0){
                doublesQuantity.put(list.get(i), 1);
            }
            else{
                if (doublesQuantity.containsKey(list.get(i))){
                    Integer n = doublesQuantity.get(list.get(i))+1;
                    doublesQuantity.replace(list.get(i), n);
                }
                else {
                    doublesQuantity.put(list.get(i), 1);
                }
            }
        }
        return doublesQuantity;
    }

    private static void DecreaseValueHashMapSorting (HashMap <String, Integer> list){
        LinkedHashMap <String, Integer> list1 = new LinkedHashMap<>();
        while (list.isEmpty() == false) {
            Integer max = 0;
            String tmp = "";
            for (String name : list.keySet()) {
                if (list.get(name) > max){
                    max = list.get(name);
                    tmp = name;
                }
            }
            list.remove(tmp,max);
            list1.put(tmp,max);
        }
        System.out.println(list1);     
    }
}