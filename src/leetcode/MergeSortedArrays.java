package leetcode;

public class MergeSortedArrays {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int p1 = 0, p2 = 0;
        int[] res = new int[m + n];
        int curr;

        while (p1 < m || p2 < n) {
            if (p1 == m) {
                curr = nums2[p2++];
            } else if (p2 == n) {
                curr = nums1[p1++];
            } else if (nums1[p1] < nums2[p2]) {
                curr = nums1[p1++];
            } else {
                curr = nums2[p2++];
            }
            res[p1 + p2 - 1] = curr;
        }
        for (int i = 0; i != m + n; i++) {
            nums1[i] = res[i];
        }
    }
}
