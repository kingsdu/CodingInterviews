package Jianzhi_Offer;

/**
 *
 * 单链表数据结构
 *
 */
public class ListNode {

    private Node head;

    public class Node{
        int val;
        Node next = null;

        public Node(int val){
            this.val = val;
            this.next = null;
        }
    }


    public void addHeadNode(int value){
        Node newNode = new Node(value);

        if(head == null){
            head = newNode;
            return;
        }

        newNode.next = head;
        head = newNode;
    }


    public void printListNode(){
        Node curNode = head;
        while(curNode != null){
            System.out.println(curNode.val);
            curNode = curNode.next;
        }
    }

}
