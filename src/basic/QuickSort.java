package basic;

public class QuickSort {
    public static int[] quickSort(int[] array,int start,int end) {
        if (array.length < 1 || start < 0 || end >= array.length || start > end) {
            return null;
        }
        int index = partition(array, start, end);
        if (index > start) {
            quickSort(array, start, index - 1);
        }
        if (index < end) {
            quickSort(array, index + 1, end);
        }
        return array;
    }

    public static int partition(int[] array, int start, int end) {
        int pivot = (int) (start + Math.random() * (end - start + 1));
        int index = start - 1;
        swap(array,pivot,end);
        for (int i = start; i <= end; i++) {
            if (array[i] <= array[end]) {
                index++;
                if (i > index) {
                    swap(array,i,index);
                }
            }
        }
        return index;
    }

    public static void swap(int[] array, int i, int j) {
        array[j] += array[i];
        array[i] = array[j] - array[i];
        array[j] -= array[i];
    }
}
