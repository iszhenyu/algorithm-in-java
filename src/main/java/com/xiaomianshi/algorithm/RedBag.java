package com.xiaomianshi.algorithm;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author zhen.yu
 * @since 2018/5/5
 *
 * 红包算法
 */
public class RedBag {

    /**
     * 算法1：二倍均值法
     */
    public static List<Integer> randomAssign1(int totalAmount, int totalPerson) {
        List<Integer> result = new ArrayList<>(totalPerson);
        int restAmount = totalAmount;
        int restPersons = totalPerson;
        Random random = new Random();
        for (int i = 1; i < totalPerson; i++) {
            int max = restAmount / restPersons * 2 - 1;
            int ran = random.nextInt(max) + 1;
            restAmount -= ran;
            restPersons--;

            result.add(ran);
        }
        result.add(restAmount);
        return result;
    }

    /**
     * 算法2：线段切割法
     *
     * 假设100分，分给10个人
     *
     * 1、100分有99个可切割位置，从这个99个位置随机出9个不重复的位置
     * 2、10个人每人先预先分配一分，剩下90分，算上两端共有91个位置，从这91个位置随机出9个位置，可以重复
     */
    public static List<Integer> randomAssign2(int totalAmount, int totalPerson) {
        List<Integer> result = new ArrayList<>(totalPerson);
        int positions = totalAmount - 1;
        Set<Integer> selectedPositions = new HashSet<>();
        Random random = new Random();
        while (selectedPositions.size() <= totalPerson - 1) {
            int pos = random.nextInt(positions) + 1;
            if (!selectedPositions.contains(pos)) {
                selectedPositions.add(pos);
            }
        }

        List<Integer> sortedPos = selectedPositions.stream().sorted(Integer::compare).collect(Collectors.toList());
        int lastPos = 0;
        for (int i = 0; i < sortedPos.size(); i++) {
            int amount = sortedPos.get(i) - lastPos;
            lastPos = sortedPos.get(i);
            result.add(amount);
        }
        result.add(totalAmount - lastPos);
        return result;
    }

    private static List<Integer> segmentMethod1(int totalAmount, int totalPerson) {
        return null;
    }

    private static List<Integer> segmentMethod2(int totalAmount, int totalPerson) {
        return null;
    }

}
