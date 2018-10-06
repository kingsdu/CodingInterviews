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
    public static int getLastsecondElement(int []array){
        int min = array[0];//最小数
        int sec_min = Integer.MAX_VALUE;

        for (int i = 0; i < array.length; i++) {
            if(array[i] < min){
                sec_min = min;
                min = array[i];
            }else{
                if(array[i]>min && array[i]<sec_min){
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
     *
     * 2 找出数组中第一个重复的数字
     * 这个题可以使用map的方式，第一个出现2次的数
     * @param array
     * @return
     */
    public static int getFirstNoRepNum(int []array){
        LinkedHashMap<Integer,Integer> hashMap = new LinkedHashMap<>();
        for (int i = 0; i < array.length; i++) {
            if(hashMap.containsKey(array[i])){
                hashMap.put(array[i], hashMap.get(array[i])+1);
            }else {
                hashMap.put(array[i],0);
            }
        }

        for (int i = 0; i < hashMap.size(); i++) {
            Iterator<Map.Entry<Integer, Integer>> iterator =
                    hashMap.entrySet().iterator();
            while (iterator.hasNext()){
                Map.Entry<Integer, Integer> next = iterator.next();//注意此处的坑
                if(next.getValue() == 0){
                    return next.getKey();
                }
            }
        }
        return -1;
    }



    public static void main(String[] args) {
        int [] array={8,8,7,7,6,5,4,3,2,1,1};
        System.out.println(getFirstNoRepNum(array));
    }
}
