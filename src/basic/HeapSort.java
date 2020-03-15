package basic;

public class HeapSort {
    static int len;

    public static int[] heapSort(int[] array) {
        len = array.length;
        if (len < 1) {
            return array;
        }

        buildMaxHeap(array);

        while (len > 0) {
            swap(array,0,len-1);
            len--;
            adjustHeap(array, 0);
        }
        return array;
    }

    public static void buildMaxHeap(int[] array) {
        for (int i = (len / 2 - 1); i >= 0; i--) {
            adjustHeap(array,i);
        }
    }

    public static void adjustHeap(int[] array, int i) {
        int maxIndex = i;
        //如果有左子树，且左子树大于父节点，则将最大指针指向左子树
        if (i * 2 < len && array[i * 2] > array[maxIndex]) {
            maxIndex = i * 2;
        }
        //如果有右子树，且右子树大于父节点，则将最大指针指向右子树
        if (i * 2 + 1 < len && array[i * 2 + 1] > array[maxIndex]) {
            maxIndex = i * 2 + 1;
        }
        //如果父节点不是最大值，则将父节点与最大值交换，并且递归调整与父节点交换的位置。
        if (maxIndex != i) {
            swap(array, maxIndex, i);
            adjustHeap(array, maxIndex);
        }
    }

    public static void swap(int[] array, int i, int j) {
        array[j] += array[i];
        array[i] = array[j] - array[i];
        array[j] -= array[i];
    }
}
