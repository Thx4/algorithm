package arraywithstring;

public class RotateArray {
/**
    给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
*/
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[(i + k) % n] = nums[i];
        }
        System.arraycopy(arr, 0, nums, 0, n);
    }

    public void rotate1(int[] nums, int k){
        int n = nums.length;
        k = k % n;
        int count = gcd(k, n);
        for (int start = 0; start < count; start++) {
            int curr = start;
            int pre = nums[start];
            do {
                int next = (curr + k) % n;
                int tmp = nums[next];
                nums[next] = pre;
                pre = tmp;
                curr = next;
            } while (start != curr);
        }
    }

    public int gcd(int x, int y) {
        return y > 0 ? gcd(y, x % y) : x;
    }

    public void rotate3(int[] nums, int k) {
        k %= nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    public void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start += 1;
            end -= 1;
        }
    }


}
