package Offer_Interview;


import java.util.ArrayList;
import java.util.Stack;

/**
 * 在一个二维数组中（每个一维数组的长度相同），
 * 每一行都按照从左到右递增的顺序排序，
 * 每一列都按照从上到下递增的顺序排序。
 * 请完成一个函数，输入这样的一个二维数组和一个整数，
 * 判断数组中是否含有该整数。
 */

public class Solution {

    /***
     * 1 发现可使用的规律  -- 左上 右下
     * 2 确定变化的是什么  -- Col Row
     * 3 循环的方式  -- 1 范围；2 怎么变化；3 如何实现
     */
    public static Integer Find(Integer[][] array,Integer target){
        Integer col = array.length-1;
        Integer row = 0;

        while(col >=0 && row<=array[0].length-1){
            if(target == array[col][row]){
                return target;
            }else if(target < array[col][row]){
                col--;
            }else if(target > array[col][row]){
                row++;
            }
        }

        return null;
    }


    /**
     * 请实现一个函数，将一个字符串中的每个空格替换成“%20”。
     * 例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
     * @param str
     * @return
     */
    public static String replaceSpace(StringBuffer str){
        StringBuffer resStr = new StringBuffer();
        for (int i = 0; i < str.length(); i++) {
            if(str.charAt(i) == 32){
                resStr.append("%20");
            }else{
                resStr.append(str.charAt(i));
            }
        }
        return resStr.toString();
    }



    /**
     * 输入一个链表，按链表值从尾到头的顺序返回一个ArrayList。
     * @param listNode
     * @return
     */
    public static ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> resArrayList = new ArrayList<Integer>();
        if (listNode != null){
            printListFromTailToHead(listNode.next);
            resArrayList.add(listNode.val);
        }
        return resArrayList;
    }


    public static ArrayList<Integer> printListFromTailToHead_1(ListNode listNode) {
        ArrayList<Integer> resArrayList = new ArrayList<Integer>();
        while (listNode != null){
            resArrayList.add(listNode.val);
            listNode = listNode.next;
        }
        return resArrayList;
    }


    public static ArrayList<Integer> printListFromTailToHead_2(ListNode listNode) {
        Stack<Integer> stack = new Stack<Integer>();
        while (listNode != null){
            stack.push(listNode.val);
            listNode = listNode.next;
        }

        ArrayList<Integer> list = new ArrayList<Integer>();

        while (!stack.isEmpty()) {
            list.add(stack.pop());
        }
        return list;
    }





}
