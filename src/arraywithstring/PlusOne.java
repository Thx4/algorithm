package arraywithstring;

import java.util.Arrays;

public class PlusOne {
    public int[] plusOne(int[] digits) {
        int carry = 1;
        for (int i = digits.length-1; i >= 0; i--) {
            digits[i] = digits[i] + carry;
            carry = digits[i] / 10;
            digits[i] = digits[i] % 10;
        }
        if (digits[0] == 0) {
            int[] res = new int[digits.length + 1];
            res[0] = carry;
            for (int i = 1; i <= digits.length; i++) {
                res[i] = digits[i - 1];
            }
            return res;
        }
        return digits;
    }
}
