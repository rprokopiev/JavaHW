import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class LaptopsSet {
    public static HashSet <Laptops> main(String[] args) {
        HashSet <Laptops> totalList = new HashSet<>();
        Laptops laptop1 = new Laptops("HP", 8, 1000, "Windows", "black");
        Laptops laptop2 = new Laptops("HP", 16, 500, "Windows", "white");
        Laptops laptop3 = new Laptops("HP", 4, 250, "Windows", "black");
        Laptops laptop4 = new Laptops("Lenovo", 8, 1000, "Windows", "black");
        Laptops laptop5 = new Laptops("Lenovo", 16, 500, "Windows", "white");
        Laptops laptop6 = new Laptops("Lenovo", 4, 250, "Windows", "black");
        Laptops laptop7 = new Laptops("Dell", 8, 1000, "Windows", "black");
        Laptops laptop8 = new Laptops("Dell", 16, 500, "Windows", "white");
        Laptops laptop9 = new Laptops("Dell", 4, 250, "Windows", "black");
        Laptops laptop10 = new Laptops("Samsung", 8, 1000, "Linux", "black");
        Laptops laptop11 = new Laptops("Samsung", 16, 500, "Linux", "white");
        Laptops laptop12 = new Laptops("Samsung", 4, 250, "Linux", "black");
        totalList.add(laptop1);
        totalList.add(laptop2);
        totalList.add(laptop3);
        totalList.add(laptop4);
        totalList.add(laptop5);
        totalList.add(laptop6);
        totalList.add(laptop7);
        totalList.add(laptop8);
        totalList.add(laptop9);
        totalList.add(laptop10);
        totalList.add(laptop11);
        totalList.add(laptop12);

        return totalList;
    }

    public static Map <Integer,String> ColorNames (){
        Map <Integer,String> color = new HashMap<>();
        color.put(1,"black");
        color.put(2,"white");
        return color;
    }

    public static Map <Integer,String> OsNames (){
        Map <Integer,String> os = new HashMap<>();
        os.put(1,"Windows");
        os.put(2,"Linux");
        return os;
    }

    public static Map <Integer,String> LaptopNames (){
        Map <Integer,String> names = new HashMap<>();
        names.put(1,"HP");
        names.put(2,"Lenovo");
        names.put(3,"Dell");
        names.put(4,"Samsung");
        return names;
    }

    public static Map <Integer,Integer> RamAmount (){
        Map <Integer,Integer> ram = new HashMap<>();
        ram.put(1,8);
        ram.put(2,16);
        ram.put(3,4);
        return ram;
    }

    public static Map <Integer,Integer> HdAmount (){
        Map <Integer,Integer> hd = new HashMap<>();
        hd.put(1,1000);
        hd.put(2,500);
        hd.put(3,250);
        return hd;
    }
}