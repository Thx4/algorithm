package arraywithstring;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Intersect {
    /**
     给定两个数组，编写一个函数来计算它们的交集。

     示例 1：
     输入：nums1 = [1,2,2,1], nums2 = [2,2]
     输出：[2,2]

     说明：
     输出结果中每个元素出现的次数，应与元素在两个数组中出现次数的最小值一致。
     我们可以不考虑输出结果的顺序。
     进阶：

     如果给定的数组已经排好序呢？你将如何优化你的算法？
     如果nums1的大小比nums2小很多，哪种方法更优？
     如果nums2的元素存储在磁盘上，内存是有限的，并且你不能一次加载所有的元素到内存中，你该怎么办？
     */

    public int[] intersect(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return intersect(nums2, nums1);
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int n : nums1) {
            int count = map.getOrDefault(n, 0) + 1;
            map.put(n, count);
        }
        int[] intersection = new int[nums1.length];

        int index = 0;

        for (int n : nums2) {
            int count = map.getOrDefault(n, 0);
            if (count > 0) {
                intersection[index++] = n;
                count--;
                //may exist duplicates
                if (count > 0) {
                    map.put(n, count);
                } else {
                    map.remove(n);
                }
            }
        }
        return Arrays.copyOfRange(intersection, 0, index);
    }

    public int[] intersect1(int[] nums1, int[] nums2){
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int length1 = nums1.length, length2 = nums2.length;
        int[] intersection = new int[Math.min(length1, length2)];
        int idx1 = 0, idx2 = 0, idx = 0;

        while (idx1 < length1 && idx2 < length2) {
            if (nums1[idx1] < nums2[idx2]) {
                idx1++;
            } else if (nums1[idx1] > nums2[idx2]) {
                idx2++;
            } else {
                intersection[idx] = nums1[idx1];
                idx++;
                idx1++;
                idx2++;
            }

        }
        return Arrays.copyOfRange(intersection, 0, idx);
    }
}
