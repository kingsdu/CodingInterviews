package DataStruct;

import java.util.*;

/**
 * 数组方面常见的面试题
 */
public class ArrayHandle {

    /**
     * 从一个给定的、无序的数组中，寻找数组中第二小的元素
     * 用两个变量来存，注意重复数字情况
     */
    public static int getLastsecondElement(int[] array) {
        int min = array[0];//最小数
        int sec_min = Integer.MAX_VALUE;

        for (int i = 0; i < array.length; i++) {
            if (array[i] < min) {
                sec_min = min;
                min = array[i];
            } else {
                if (array[i] > min && array[i] < sec_min) {
                    sec_min = array[i];
                }
            }
        }
        return sec_min;
    }


    /**
     * 1 找到数组中第一个不重复出现的整数
     * 思路：
     * 使用LinkedHashMap，特点：按照存入的顺序取出值。
     * 先存入，然后遍历，找出第一个次数是1的数
     * <p>
     * 2 找出数组中第一个重复的数字
     * 这个题可以使用map的方式，第一个出现2次的数
     *
     * @param array
     * @return
     */
    public static int getFirstNoRepNum(int[] array) {
        LinkedHashMap<Integer, Integer> hashMap = new LinkedHashMap<>();
        for (int i = 0; i < array.length; i++) {
            if (hashMap.containsKey(array[i])) {
                hashMap.put(array[i], hashMap.get(array[i]) + 1);
            } else {
                hashMap.put(array[i], 0);
            }
        }

        for (int i = 0; i < hashMap.size(); i++) {
            Iterator<Map.Entry<Integer, Integer>> iterator =
                    hashMap.entrySet().iterator();
            while (iterator.hasNext()) {
                Map.Entry<Integer, Integer> next = iterator.next();//注意此处的坑
                if (next.getValue() == 0) {
                    return next.getKey();
                }
            }
        }
        return -1;
    }


    /**
     * 合并两个有序数组
     * <p>
     * 思路：类似归并排序
     *
     * @param array1
     * @param array2
     */
    public static int[] mergeSortArray(int[] array1, int[] array2) {
        int length = array1.length + array2.length;
        int[] temp = new int[length];

        int i = 0, j = 0, t = 0;

        while (i < array1.length && j < array2.length) {
            if (array1[i] <= array2[j]) {
                temp[t++] = array1[i++];
            } else {
                temp[t++] = array2[j++];
            }
        }

        while (i < array1.length) {
            temp[t++] = array1[i++];
        }

        while (j < array2.length) {
            temp[t++] = array2[j++];
        }

        return temp;
    }


    /**
     * 将数组里的负数排在数组的前面，正数排在数组的后面。
     * 但不改变原先负数和正数的排列顺序
     * <p>
     * input: -5，2，-3, 4，-8，-9, 1, 3，-10
     * output: -5, -3, -8, -9, -10, 2, 4, 1, 3
     * <p>
     * 冒泡排序
     *
     * @param array
     * @return
     */
    public static int[] sortPositiveAndNegative(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j] >= 0 && array[j + 1] < 0) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
        return array;
    }


    public static void main(String[] args) {
        int[] array = {-5,2,-3,4,-8,-9,1,3,-10};
        System.out.println(sortPositiveAndNegative(array));
    }


}
