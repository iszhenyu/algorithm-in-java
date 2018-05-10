package com.xiaomianshi.algorithm;

/**
 * @author zhen.yu
 * @since 2018/5/9
 */
public class LargeInteger {
    static final String NUM_STR = "0123456789";

    /**
     * 加法
     */
    public static String add(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        char[] num1Arr = num1.toCharArray();
        char[] num2Arr = num2.toCharArray();

        int digitPos = 1;
        int fromLow = 0;
        while (digitPos <= num1Arr.length && digitPos <= num2Arr.length) {
            int tmp = NUM_STR.indexOf(num1Arr[num1Arr.length - digitPos]) + NUM_STR.indexOf(num2Arr[num2Arr.length - digitPos]);
            tmp += fromLow;
            if (tmp >= 10) {
                fromLow = tmp / 10;
                tmp = tmp % 10;
            } else {
                fromLow = 0;
            }
            sb.append(tmp);
            digitPos++;
        }
        while (digitPos <= num1Arr.length) {
            sb.append(num1Arr[num1Arr.length - digitPos]);
            digitPos++;
        }
        while (digitPos <= num2Arr.length) {
            sb.append(num2Arr[num2Arr.length - digitPos]);
            digitPos++;
        }
        return sb.reverse().toString();
    }

    /**
     * 减法
     */
    public static String minus(String num1, String num2) {
        boolean isNum1Bigger = true;
        char[] num1Arr = num1.toCharArray();
        char[] num2Arr = num2.toCharArray();
        if (num1Arr.length < num2Arr.length) {
            isNum1Bigger = false;
        } else if (num1Arr.length == num2Arr.length) {
            for (int i = 0; i < num1Arr.length; i++) {
                if (num1Arr[i] == num2Arr[i]) {
                    continue;
                }
                if (num1Arr[i] < num2Arr[i]) {
                    isNum1Bigger = false;
                }
                break;
            }
        }

        StringBuilder sb = new StringBuilder();
        if (isNum1Bigger) {
            int borrow = 0;

            int i = num1Arr.length - 1;
            int j = num2Arr.length - 1;
            for (; i >= 0 && j >= 0; i--, j--) {
                int num1Val = NUM_STR.indexOf(num1Arr[i]);
                int num2Val = NUM_STR.indexOf(num2Arr[j]);
                if (num1Val - borrow >= num2Val) {
                    sb.append(num1Val - borrow - num2Val);
                    borrow = 0;
                } else {
                    sb.append(num1Val + 10 - borrow - num2Val);
                    borrow = 1;
                }
            }
            while (i >= 0) {
                int val = NUM_STR.indexOf(num1Arr[i]);
                if (val >= borrow) {
                    sb.append(val - borrow);
                    borrow = 0;
                } else {
                    borrow = 1;
                    sb.append(val + 10 - borrow);
                }
                i--;
            }
        }

        String result = sb.reverse().toString();
        int firstNoneZeroIdx = -1;
        for (int i = 0; i < result.length(); i++) {
            if (result.charAt(i) == '0') {
                firstNoneZeroIdx++;
                continue;
            }
            break;
        }
        return firstNoneZeroIdx >= 0 ? result.substring(firstNoneZeroIdx + 1) : result;
    }

    /**
     * 乘法
     */
    public static String multiply(String num1, String num2) {
        char[] num1Arr = num1.toCharArray();
        char[] num2Arr = num2.toCharArray();
        String result = "0";
        for (int i = num2Arr.length - 1; i >= 0; i--) {
            int num2Val = NUM_STR.indexOf(num2Arr[i]);
            String tmpNum = multiplyOne(num1Arr, num2Val);
            int zeroCount = num2Arr.length - 1 - i;
            while (zeroCount > 0) {
                tmpNum = tmpNum + "0";
                zeroCount--;
            }
            result = add(result, tmpNum);
        }
        return result;
    }

    private static String multiplyOne(char[] numArr, int oneDig) {
        StringBuilder sb = new StringBuilder();
        int upperDigit = 0;
        for (int i = numArr.length - 1; i >= 0; i--) {
            int digitVal = NUM_STR.indexOf(numArr[i]);
            int tmpVal = oneDig * digitVal + upperDigit;
            sb.append(tmpVal % 10);
            upperDigit = tmpVal / 10;
        }
        return sb.reverse().toString();
    }

    /**
     * 除法
     */
    public static String divide(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        return sb.toString();
    }
}
