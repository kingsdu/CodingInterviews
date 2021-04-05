package Jianzhi_Offer;

import java.util.ArrayList;
import java.util.Stack;

/**
 *
 * 输入一个链表，按链表从尾到头的顺序返回一个ArrayList。
 * {67,0,24,58}
 * [58,24,0,67]
 *
 */
public class PrintList {

    ArrayList<Integer> resList = new ArrayList<>();

    /**
     *
     * 递归法
     * @param node
     * @return
     */
    public ArrayList<Integer> printListFromTailToHead_1(ListNode.Node node){
        ListNode.Node curNode = node;

        if(curNode != null){

            this.printListFromTailToHead_1(curNode.next);
            resList.add(curNode.val);
        }
        return resList;
    }


    /**
     *
     * 通过Java自带的Stack类实现
     *
     * @param node
     * @return
     */
    public ArrayList<Integer> printListFormToHead_2(ListNode.Node node){
        Stack<Integer> stackInt = new Stack<>();

        while (node != null){
            stackInt.push(node.val);
            node = node.next;
        }

        while (!stackInt.isEmpty()){
            resList.add(stackInt.pop());
        }

        return resList;
    }


    /**
     *
     * 通过改变链表的前后指向实现
     *
     *
     * @param node
     * @return
     */
    public ArrayList<Integer> printListFormToHead_3(ListNode.Node node){

        ListNode.Node pre = null;
        ListNode.Node next= null;

        /**
         *
         * 1存储正序的node.next
         * 2改变node指向
         * 3交换node和pre的顺序
         */
        while (node!=null){
            next = node.next;
            node.next = pre;//很重要，改变node的前后指向，由1->2->3 变为 3->2->1
            pre = node;
            node = next;
        }

        while (pre!=null){
            resList.add(pre.val);
            pre = pre.next;
        }

        return resList;
    }



}
