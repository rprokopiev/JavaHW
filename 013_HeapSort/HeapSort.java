public class HeapSort {

    public static void main(String[] args) {
        int[] array = { 7, 2, 9, 3, 4, 1, 8, 5, 6 };
        System.out.println();
        
        // PringIntArray(array);
    }
    // private static int[] HeapSort(int [] array){

    // }
    private static void PringIntArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            if (i == 0)
                System.out.printf("[%d, ", array[i]);
            else if (i == array.length - 1)
                System.out.printf("%d]", array[i]);
            else
                System.out.printf("%d, ", array[i]);
        }
    }
}