package basic;

public class ShellSort {
    public static int[] shellSort(int[] array) {
        int len = array.length;

        int temp, gap = len / 2;
        while (gap > 0) {
            for (int i = gap; i < len; i++) {
                temp = array[i];
                int preIndex = i - gap;
                while (preIndex >= 0 && array[preIndex] > temp) {
                    array[preIndex + gap] = array[preIndex];
                    preIndex -= gap;
                }
                array[preIndex + gap] = temp;
            }
            gap /= 2;
        }
        return array;
    }

    // 希尔排序
    public static void sort(int[] arr) {
        int n = arr.length;
        for (int h = n / 2; h > 0; h = h / 2) {
            // 内部是一个插入排序
            for (int i = 0; i < n; i = i + h) {

                int e = arr[i];
                int j = i;
                for (; j > 0; j = j - h) {
                    if (e < arr[j - h]) {
                        arr[j] = arr[j - h];
                    } else {
                        break;
                    }
                }
                arr[j] = e;
            }
        }
    }


    // 希尔排序2
    public static void sort2(int[] arr) {
        int n = arr.length;
        // 计算 increment sequence: 1, 4, 13, 40, 121, 364, 1093...
        int h = 1;
        while (h < n / 3) {
            h = 3 * h + 1;
        }

        System.out.println(h);

        while (h >= 1) {
            // h-sort the array
            for (int i = h; i < n; i++) {

                // 对 arr[i], arr[i-h], arr[i-2*h], arr[i-3*h]... 使用插入排序
                int e = arr[i];
                int j = i;
                for (; j >= h && e < arr[j - h]; j -= h) {
                    arr[j] = arr[j - h];
                }
                arr[j] = e;
            }

            h /= 3;

        }
    }
}
