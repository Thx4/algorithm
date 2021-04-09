package exam.spdb;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class FindKNum {
    /**
     * 寻找和为定值的k个数 k=3 和为0
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> list = new ArrayList<>();
        while (sc.hasNextLine()) {
            list.add(sc.nextInt());
        }
        System.out.println(threeNum(list,0));
    }

    public static List<List<Integer>> threeNum(List<Integer> nums, int targetNum) {
        int n = nums.size();
        Collections.sort(nums);
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        //枚举a
        for (int first = 0;first<n;first++) {
            //需要和上一次枚举的数不同
            if (first > 0 && nums.get(first) == nums.get(first - 1)) {
                continue;
            }
            //c对应的指针指向最右
            int third = n - 1;
            //除去a之外的bc和的目标
            int target =targetNum -nums.get(first);
            //枚举b
            for (int second = first + 1; second < n; second++) {
                //和上次枚举数不同
                if (second > first + 1 && nums.get(second) == nums.get(second - 1)) {
                    continue;
                }
                //b的指针在c的左侧
                while (second < third && nums.get(second) + nums.get(third) > target) {
                    third--;
                }

                //b c指针重合 b增加但不会有 符合条件的 b<c的c了 退出这层循环
                if (second == third) {
                    break;
                }
                if (nums.get(second) + nums.get(third) == target) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums.get(first));
                    list.add(nums.get(second));
                    list.add(nums.get(third));
                    res.add(list);
                }
            }
        }
        return res;
    }

}
