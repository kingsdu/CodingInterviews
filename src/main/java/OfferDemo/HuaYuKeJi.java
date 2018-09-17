package OfferDemo;


import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 华宇科技笔试题
 */
public class HuaYuKeJi {


    /**
     * 对n个学生成绩排序，输入输出如下：
     * score = {4,5,4,2}, 输出数组 = {2,1,2,4}
     * */

    /**
     * 程序有几处写的很不好。
     * 1 数组的复制属于多余操作
     * 2 判断当前数和下一个数不同的方法过于繁琐
     * 3 使用了Map数据结构，可能有更简单的方法
     * 4 花费时间太久，近一个小时
     * 5 中间调试了很多次，程序的写出借助了debug的帮助
     */

    /**
     * 思路：
     * 1 排序
     * 2 计算个分数的排名
     * 3 对比分数，赋值排名
     */
    public void getRank(int[] score,Map<Integer, Integer> map) {
        int[] result = new int[score.length];
        int t = 0;
        for (Integer i :
                score) {
            result[t++] = map.get(i);
        }
        for (int i : result){
            System.out.print(i + " ");
        }
    }


    /**
     *
     * 突破点：根据题目要求明白了：rank 和 k两个因素组合决定的。
     * @param score
     * @return
     */
    public Map<Integer,Integer> rankingScore(int[] score){
        Map<Integer,Integer> ranking = new HashMap<Integer, Integer>();
        quickSort(score,0,score.length-1);
        int i = score.length-1;
        int k = 0;
        int rank = 1;
        while (i >= 0){
            if(i == 0){
                ranking.put(score[i],rank-k);
            }else {
                if(score[i] != score[i-1]){
                    ranking.put(score[i],rank-k);
                    k=0;
                }else{
                    ranking.put(score[i],rank-k++);
                }
            }
            rank++;
            i--;
        }
        return ranking;
    }


    /**
     * 快速排序依旧有几个地方没把握住
     *
     * 1 没有考虑必须写return
     * 2 相等的情况没有考虑
     * @param array
     * @param left
     * @param right
     */
    public void quickSort(int[] array, int left, int right) {
        if(left > right){
            return;
        }
        int i = left;
        int j = right;
        int base = array[left];

        while (i != j) {
            while (i < j && array[j] >= base) {
                j--;
            }
            while (i < j && array[i] <= base) {
                i++;
            }

            if (i < j) {
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }
        array[left] = array[i];
        array[i] = base;

        quickSort(array, left, i - 1);
        quickSort(array, i + 1, right);
    }


    /**
     * 输出金字塔图案
     */
    public void printPartern(int n){
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < n - i; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j < 2 * i - 1; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

        for (int i = n-1; i >= 1; i--) {
            for (int j = 0; j < n - i; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j < 2 * i - 1; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
