package basic;

public class BubbleSort {
    public static int[] bubbleSort(int[] array) {
        if (array.length == 0) {
            return array;
        }

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                if (array[j + 1] < array[j]) {
                    array[j + 1] += array[j];
                    array[j] = array[j + 1] - array[j];
                    array[j + 1] = array[j + 1] - array[j];
                }
            }
        }
        return array;
    }
}
