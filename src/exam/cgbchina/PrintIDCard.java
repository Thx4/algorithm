package exam.cgbchina;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

public class PrintIDCard {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (sc.hasNextInt()) {
            int num = sc.nextInt();
            if (sc.hasNextInt()) {
                int times = sc.nextInt();
                System.out.println(sumCal(num, times));
            }
        }

    }

    public static long sumCal(int num, int times) {
        // write code here
        long res = 0;
        int temp = 0;
        int n = 1;
        for (int i = 0; i < times; i++) {
            temp += num * n;
            n *= 10;
            res += temp;
        }
        return res;
    }

    public static String printIDCard(String str) {

        char[] cr = str.toCharArray();
        String res =" ";
        for (char c : cr) {
            int i = 0;
            if (Character.isDigit(c)) {
                boolean flag = true;
                for (int idx = 0; idx < 17; idx++) {
                    if (!Character.isDigit(cr[i + idx])) {
                        flag = false;
                        break;
                    }
                }
                if (flag == true) {
                    String string = Arrays.copyOfRange(cr, i, i + 18).toString();
                    if (!checkAreaCode(string)) {
                        continue;
                    }
                    if(!checkBirthday(string)){
                        continue;
                    }
                    if(!checkValidCode(string)){
                        continue;
                    }

                    res =res + string +" ";
                }
            }
            i++;
        }
        return res;
    }

    public static boolean checkAreaCode(String str){
        Set<Integer> areaCode = new HashSet<>();
        areaCode.addAll(Arrays.asList(11, 12, 13, 14, 15, 21, 22, 23, 31, 32, 33, 34, 35, 36, 3, 41, 42, 43, 44, 45, 46,
                50, 51, 52, 53, 54, 61, 62, 63, 64, 65, 71, 81, 82, 91));
        String subString = str.substring(0, 2);
        return areaCode.contains(subString);
    }

    public static boolean checkBirthday(String str) {
        Integer month = Integer.parseInt(str.substring(6, 10));
        Integer day = Integer.parseInt(str.substring(12, 14));
        if (month >= 1 && month <= 12) {
            LocalDate date = LocalDate.parse(str);
            if (day <= date.getDayOfMonth() && day >= 1) {
                return true;
            }
        }
        return false;
    }

    public static boolean checkValidCode(String str) {
        int[] wi = new int[]{7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2};
        List<String> y_p = Arrays.asList("1", "0", "X", "9", "8", "7", "6", "5", "4", "3", "2");
        String subString = str.substring(0, 17);
        char[] cr = subString.toCharArray();
        int num = 0;
        for (int i = 0; i < 17; i++) {
            num += Integer.parseInt(String.valueOf(cr[i])) * wi[i];
        }

        int idx = 0;
        String y = str.substring(17, 18);
        for (String s : y_p) {
            if (s.equals(y)) {
                break;
            }
            idx++;
        }
        return idx == (num % 11);
    }


}
