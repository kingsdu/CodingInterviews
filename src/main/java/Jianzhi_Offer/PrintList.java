package Jianzhi_Offer;

import java.util.ArrayList;

/**
 *
 * 输入一个链表，按链表从尾到头的顺序返回一个ArrayList。
 * {67,0,24,58}
 * [58,24,0,67]
 *
 */
public class PrintList {

    /**
     *
     * 递归法
     * @param node
     * @return
     */
    public ArrayList<Integer> printListFromTailToHead_1(ListNode.Node node){
        ListNode.Node curNode = node;
        ArrayList<Integer> resList = new ArrayList<>();

        if(curNode.next != null){
            this.printListFromTailToHead_1(curNode.next);
            resList.add(curNode.val);
        }
        return resList;
    }
}
