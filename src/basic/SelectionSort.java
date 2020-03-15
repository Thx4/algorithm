package basic;

public class SelectionSort {
    public static int[] selectionSort(int[] array) {
        if (array.length == 0) {
            return array;
        }

        for (int i = 0; i < array.length; i++) {
            int minIndex = i;
            for (int j = i; j < array.length; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }

            array[i] += array[minIndex];
            array[minIndex] = array[i] - array[minIndex];
            array[i] -= array[minIndex];
        }
        return array;
    }
}
