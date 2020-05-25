package basic;

public class QuickSort {
    public static void quickSort(int[] arr,int l,int r){
        if(l>=r) {
            return;
        }
        int p = partition(arr,l,r);
        quickSort(arr,l,p-1);
        quickSort(arr,p+1,r);
    }

    // 将数组通过p分割成两部分
// 对arr[l...r]部分进行partition操作
// 返回p, 使得arr[l...p-1] < arr[p] ; arr[p+1...r] > arr[p]
    public static int partition(int[] arr, int l, int r) {
        swap(arr, l, (int) (Math.random() % (r - l + 1)) + l);  // 加入这一行变成随机快速排序

        int v = arr[l];
        int j = l;
        for(int i = j +1;i<=r;i++){
            if(arr[i] < v){
                j++;
                swap(arr,i,j);
            }
        }
        swap(arr,l,j);
        return j;
    }

    public static void swap(int[] arr,int i,int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
