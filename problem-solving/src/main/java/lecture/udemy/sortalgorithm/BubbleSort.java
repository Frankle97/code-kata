package lecture.udemy.sortalgorithm;

import java.util.Arrays;

public class BubbleSort {

    public static void main(String[] args) {
        int[] array = {11, -2, 3, 5, 14, 92, 53, 9};

        for (int i = array.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (array[j] > array[j + 1]) {
                    swap(array, j, j + 1);
                }
            }
        }

        System.out.println("array = " + Arrays.toString(array));
    }

    public static void swap(int[] array, int i, int j) {
        if (i == j) {
            return;
        }

        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
