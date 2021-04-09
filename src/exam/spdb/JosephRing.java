package exam.spdb;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class JosephRing {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            System.out.println();
            josephRing(sc.nextInt(),0,3);
        }
    }
    /**
     * @param n 总人数
     * @param start 起始下标 0
     * @param m 数到几的被剔除 3
     */
    private static void josephRing(int n, int start, int m) {
        List<Integer> list = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            list.add(i);
        }
        //将数1 2 ... m-1的添加到队尾 直接跳过数m的
        while (list.size() > 0) {
            for (int i = 0; i < m - 1; i++) {
                list.add(list.remove(start));
            }
            if (list.size() == 1) {
                System.out.println(list.get(0));
                break;
            }
            list.remove(start);

        }
    }
}
