package DoExercise.JianzhiOffer;

import java.util.ArrayList;
import java.util.Stack;

/**
 * 输入一个链表，按链表从尾到头的顺序返回一个ArrayList。
 * {67,0,24,58}
 * [58,24,0,67]
 * <p>
 * 1、递归法：node != null 递归，递归到最后回溯时逐个将数字存到数组
 * 2、Stack类实现：存、取
 * 3、每插入新元素时，改变链表元素的前后指向
 */
public class Offer003_从头到尾打印链表
{
    
    static ArrayList<Integer> resList = new ArrayList<>();
    
    public static void main(String[] args)
    {
        Node node1 = new Node(67);
        Node node2 = new Node(0);
        Node node3 = new Node(24);
        Node node4 = new Node(58);
        
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        
        printListFormToHead_3(node1);
    }
    
    /**
     * 递归法
     *
     * @param node
     * @return
     */
    public static ArrayList<Integer> printListFromTailToHead_1(Node node)
    {
        Node curNode = node;
        
        if (curNode != null)
        {
            printListFromTailToHead_1(curNode.next);
            resList.add(curNode.val);
        }
        return resList;
    }
    
    
    /**
     * 通过Java自带的Stack类实现
     *
     * @param node
     * @return
     */
    public static ArrayList<Integer> printListFormToHead_2(Node node)
    {
        Stack<Integer> stackInt = new Stack<>();
        
        while (node != null)
        {
            stackInt.push(node.val);
            node = node.next;
        }
        
        while (!stackInt.isEmpty())
        {
            resList.add(stackInt.pop());
        }
        
        return resList;
    }
    
    
    /**
     * 通过改变链表的前后指向实现
     *
     * @param node
     * @return
     */
    public static ArrayList<Integer> printListFormToHead_3(Node node)
    {
        
        Node pre = null;
        Node next = null;
        
        /**
         *
         * 1 存储node.next，因为后面会改变node的指向，存起来保证node能正序向后
         * 2 改变node的指向，实现从逆序
         * 3 将改变后的node作为下一个节点的pre
         * 4 node 向后移动一位
         *
         */
        while (node != null)
        {
            next = node.next;
            node.next = pre;//很重要，改变node的前后指向，由1->2->3 变为 3->2->1
            pre = node;
            node = next;
        }
        
        while (pre != null)
        {
            resList.add(pre.val);
            pre = pre.next;
        }
        
        return resList;
    }
    
    
    public static class Node
    {
        int val;
        Node next = null;
        
        public Node(int val)
        {
            this.val = val;
            this.next = null;
        }
    }
    
}
