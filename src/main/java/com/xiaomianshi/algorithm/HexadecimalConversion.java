package com.xiaomianshi.algorithm;

/**
 * @author zhen.yu
 * @since 2018/5/7
 */
public class HexadecimalConversion {

    static char[] CHAR_ARR = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
    static String NUM_STR  = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

    /**
     * n进制转10进制
     */
    public static long nToTen(String number, int n) {
        String positiveNumber = number;
        boolean isMinus = number.contains("-");
        if (isMinus) {
            positiveNumber = number.substring(1, number.length());
        }

        long result = 0;
        int numberLen = positiveNumber.length();
        for (int pos = numberLen - 1; pos >= 0; pos--) {
            char c = positiveNumber.charAt(pos);
            int posVal = NUM_STR.indexOf(c);
            result += Math.pow(n, (numberLen - pos - 1)) * posVal;
        }
        return isMinus ? -result : result;
    }

    /**
     * 十进制数字转任意进制
     */
    public static String tenToN(long number, int n) {
        boolean isMinus = number < 0;
        StringBuilder sb = new StringBuilder();
        long rest = isMinus ? -number : number;

        while (rest > 0) {
            int last = (int) rest % n;
            sb.append(CHAR_ARR[last]);
            rest = rest / n;
        }
        if (isMinus) {
            sb.append("-");
        }
        return sb.reverse().toString();
    }

    /**
     * 二进制转16进制
     */
    public static String c2To16(String number) {
        String positiveNumber = number;
        StringBuilder sb = new StringBuilder();
        char[] numberArr = positiveNumber.toCharArray();

        int bitCount = 0;
        int digit = 0;
        for (int i = numberArr.length - 1; i >= 0; i--) {
            if (numberArr[i] == '1') {
                digit += Math.pow(2, bitCount);
            }
            bitCount++;
            if (bitCount == 4 || i == 0) {
                sb.append(CHAR_ARR[digit]);
                bitCount = 0;
                digit = 0;
            }
        }

        return sb.reverse().toString();
    }
}
