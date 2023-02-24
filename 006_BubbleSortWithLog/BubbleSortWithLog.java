import java.io.IOException;
import java.util.logging.*;

/**
 * Реализуйте алгоритм сортировки пузырьком числового массива,
 * результат после каждой итерации запишите в лог-файл.
 */

public class BubbleSortWithLog {
    public static void main(String[] args) throws IOException {
        Logger logger = Logger.getLogger(BubbleSortWithLog.class.getName());
        FileHandler fh = new FileHandler("log.txt");
        logger.addHandler(fh);
        SimpleFormatter sFormat = new SimpleFormatter();
        fh.setFormatter(sFormat);

        int[] array = { 92, 82, 1, 99, 43 };
        printArray(array);

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                if (array[i] < array[j]) {
                    logger.info(String.format("%d moved from index %d to index %d", array[i], i, j));
                    logger.info(String.format("%d moved from index %d to index %d", array[j], j, i));
                    int tmp = array[i];
                    array[i] = array[j];
                    array[j] = tmp;                    
                }
            }
        }
        printArray(array);
    }

    private static void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
            System.out.print(" ");
        }
        System.out.println();
    }
}
