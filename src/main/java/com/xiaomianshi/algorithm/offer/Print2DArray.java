package com.xiaomianshi.algorithm.offer;

/**
 * @author zhen.yu
 * @since 2018/5/11
 */
public class Print2DArray {

    public static void print(int[][] arr) {
        int rows = arr.length;
        int cols = arr[0].length;
        int size = rows < cols ? rows : cols;

        int totalRound;
        boolean flag = false;  // 最后一圈是一行、一列或一个元素
        if ((size & (size - 1)) == 0) {
            totalRound = size / 2;
        } else {
            totalRound = size / 2 + 1;
            flag = true;
        }

        for (int i = 0; i < totalRound; i++) {
            if (!(flag && i == totalRound - 1)) {
                printRow(arr, i, i, cols - 2 - i);
                printCol(arr, cols - 1 - i, i, rows - 2 - i);
                printRow(arr, rows - 1 - i, cols - 1 - i, i + 1);
                printCol(arr, i, rows - 1 - i, i + 1);
            }
        }
        if (flag) {
            if (cols == rows) {
                System.out.println(arr[totalRound - 1][totalRound - 1]);
            } else if (rows < cols) {
                for (int i = totalRound - 1; i <= cols - totalRound; i++) {
                    System.out.println(arr[totalRound - 1][i]);
                }
            } else {
                for (int i = totalRound - 1; i <= rows - totalRound; i++) {
                    System.out.println(arr[i][totalRound - 1]);
                }
            }
        }
    }

    private static void printRow(int[][] arr, int row, int colStart, int colEnd) {
        if (colStart <= colEnd) {
            for (int i = colStart; i <= colEnd; i++) {
                System.out.println(arr[row][i]);
            }
        } else {
            for (int i = colStart; i >= colEnd; i--) {
                System.out.println(arr[row][i]);
            }
        }
    }

    private static void printCol(int[][] arr, int col, int rowStart, int rowEnd) {
        if (rowStart <= rowEnd) {
            for (int i = rowStart; i <= rowEnd; i++) {
                System.out.println(arr[i][col]);
            }
        } else {
            for (int i = rowStart; i >= rowEnd; i--) {
                System.out.println(arr[i][col]);
            }
        }
    }

    public static void main(String[] args) {
        int[][] arr = new int[][]{
                {1, 2, 3, 4, 5, 1},
                {5, 6, 7, 8, 9, 2},
                {9, 10, 11, 12, 13, 3},
                {13, 14, 15, 16, 17, 4},
                {1, 2, 3, 4, 5, 6}
        };
        print(arr);
    }

}
