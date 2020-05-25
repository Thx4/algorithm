package basic;

public class InsertionSort {

    public static int[] insertionSort(int[] array) {
        if (array.length == 0) {
            return array;
        }

        int current;
        for (int i = 0; i < array.length - 1; i++) {
            current = array[i + 1];
            int preIndex = i;

            while (preIndex >= 0 && current < array[preIndex]) {
                array[preIndex + 1] = array[preIndex];
                preIndex--;
            }

            array[preIndex + 1] = current;
        }
        return array;
    }

    public static void sort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j > 0; j--) {
                if (arr[j] < arr[j - 1]) {
                    swap(arr, j, j - 1); // 大量的交换会消耗时间
                } else {
                    break;
                }
            }
        }
    }

    // 改进版插入排序（减少了数组元素的操作次数）
    public static void better_sort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int e = arr[i];
            int j = i;
            for (; j > 0; j--) {
                if (e < arr[j - 1]) {
                    arr[j] = arr[j - 1];
                } else {
                    break;
                }
            }
            arr[j] = e;
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }
}
