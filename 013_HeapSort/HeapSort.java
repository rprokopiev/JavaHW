public class HeapSort {

    public static void main(String[] args) {
        int[] array = { 7, 2, 9, 3, 4 };
        PrintIntArray(array);
        int lght = array.length;
        for (int j = 0; j < array.length; j++) {
            for (int i = lght / 2 - 1; i >= j; i--) {
                DoubleNodeSort(array, lght, i);
            }
        }
        PrintIntArray(array);
    }

    // сортировка 3х значений массива, таким образом, чтобы наибольшее значение было в верху,
    // и наименьшее было внизу справа.
    private static int[] DoubleNodeSort(int[] array, int lght, int i) {
        int max = i;
        int left = i * 2 + 1;
        int right = i * 2 + 2;
        if (array[left] > array[max]){
            max = left;
        }
        if (array[right] > array[max]){
            max = right;
        }
        if (max != i){
            int tmp = array[i];
            array[i] = array[max];
            array[max] = tmp;
            if (array[left]<array[right]){
                tmp = array[left];
                array[left] = array[right];
                array[right] = tmp;
            }
        }
        return array;
    }

    private static void PrintIntArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            if (i == 0)
                System.out.printf("[%d, ", array[i]);
            else if (i == array.length - 1)
                System.out.printf("%d]\n", array[i]);
            else
                System.out.printf("%d, ", array[i]);
        }
    }
}