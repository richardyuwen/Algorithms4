package com.lc.array;

/**
 * Created by i305765 on 18/04/2017.
 */
public class PlusOne {
    public int[] plusOne(int[] digits) {
        int carry = 1;
        for (int i = digits.length - 1; i >= 0; i--) {
            int sum = digits[i] + carry;
            if (sum == 10) {
                digits[i] = 0;
                carry = 1;
            } else {
                digits[i] = sum;
                carry = 0;
                break;
            }
        }
        if (carry == 1) {
            int[] newDigits = new int[digits.length + 1];
            for (int i = 0; i < digits.length; i++) {
                newDigits[i + 1] = digits[i];
            }
            newDigits[0] = 1;
            return newDigits;
        }
        return digits;
    }
}
