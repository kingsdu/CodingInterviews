package Jianzhi_Offer;

import java.util.ArrayList;

/**
 *
 * 单链表数据结构
 *
 */
public class ListNode {

    public Node head;

    public class Node{
        int val;
        Node next = null;

        public Node(int val){
            this.val = val;
            this.next = null;
        }
    }
    
    
    public static void main(String[] args)
    {
        /** 反向打印链表*/
        ListNode node = new ListNode();
        ListNode.Node curNode;
        PrintList printList = new PrintList();
    
        node.addNodeOrder(1);
        node.addNodeOrder(2);
        node.addNodeOrder(3);
        curNode = node.head;
    
        node.printListNode();
    
        System.out.println();
    
        ArrayList<Integer> resList = printList.printListFormToHead_3(curNode);
    
        for (Integer number :
                resList) {
            System.out.print(number+" ");
        }
    }

    /**
     *
     * 按照插入顺序正序放入元素：1，2，3  = 1，2，3
     * @param value
     */
    public void addNodeOrder(int value){
        Node newNode = new Node(value);
        Node curNode;

        if(head == null){
            head = newNode;
            return;
        }

        curNode = head;

        while(curNode.next!=null){
            curNode = curNode.next;
        }

        curNode.next = newNode;
    }


    /**
     * 按照插入逆序放入元素：1，2，3  = 3,2,1
     * 逆序插入节点
     * @param value
     */
    public void addNodeReverse(int value){
        Node newNode = new Node(value);

        if(head == null){
            head = newNode;
        }

        newNode.next = head;
        head = newNode;
    }



    public void printListNode(){
        Node curNode = head;
        while(curNode != null){
            System.out.print(curNode.val+" ");
            curNode = curNode.next;
        }
    }

}
