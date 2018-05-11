package com.xiaomianshi.algorithm.offer;

/**
 * @author zhen.yu
 * @since 2018/5/11
 */
public class NumberOf1 {

    /**
     * 获取一个整数转化为二进制后1的个数
     */
    public static int num(int number) {
        int positiveNumber = number > 0 ? number : -number;
        int count = 0;
        while (positiveNumber > 0) {
            if ((positiveNumber & 1) > 0) {
                count++;
            }
            positiveNumber = positiveNumber >> 1;
        }
        return count;
    }

    /**
     * 最优
     */
    public static int num2(int number) {
        int count = 0;
        while (number > 0) {
            number = number & (number - 1);
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(num2(13));
    }
}
