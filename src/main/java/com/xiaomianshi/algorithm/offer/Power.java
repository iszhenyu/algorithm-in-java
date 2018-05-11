package com.xiaomianshi.algorithm.offer;

/**
 * @author zhen.yu
 * @since 2018/5/11
 */
public class Power {

    /**
     * 不考虑特殊处理
     */
    public static int pow(int base, int e) {
        if (e == 0) {
            return 1;
        }
        if (e == 1){
            return base;
        }

        int res = pow(base, e >> 1);
        res *= res;
        if ((e & 1) > 0) {
            res *= base;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(pow(2, 5));
    }

}
