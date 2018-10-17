package DataStruct;

import DataStructBook.Link;

/**
 * 双端链表和单链表的区别是:多了last引用的操作，first和last都位于头结点，
 * first指向头结点，last指向尾节点
 */
public class DoubleListNode {
    public ListNode first;
    public ListNode last;
    public int data;

    public DoubleListNode(){
        first = null;
        last = null;
    }

    public boolean isEmpty(){
        return first == null;
    }

    public void deleteFirst(){
        first = first.next;
        if(first.next == null){
            last = null;
        }
    }

    /**
     * 开始不懂的操作是：
     * 1 if(first == null) last = newLink; 原因：双端链表first和last都处于一个位置，当插入first时，first一定会有新值(newLink)，所以需要让last也等于(newLink)。插入last也是同理。
     * 2 newLink.next = first;在第一次插入时，first == null，该语句如何生效？ 当first == null，first = newLink即可实现头结点插入，这种情况也是为了后面当first不为空时做的准备。
     * 3 通过头和尾插入的节点的顺序，头部逆序，尾部顺序（如果从头开始计算）
     *
     */

    /**
     * @param val
     */
    public void insertFirst(int val){
        ListNode newLink = new ListNode(val);
        if(first == null){
            last = newLink;
        }
        newLink.next = first;
        first = newLink;
    }


    /**
     *
     * @param val
     */
    public void insertLast(int val){
        ListNode newLink = new ListNode(val);
        if(isEmpty()){
            first = newLink;
        }else {
            last.next = newLink;
        }
        last = newLink;
    }


    public void displayList() {
        ListNode current = first;
        while(current != null){
            current.displayLink();
            current = current.next;
        }
        System.out.println();
    }


    public static void main(String[] args) {
        DoubleListNode doubleListNode = new DoubleListNode();
        doubleListNode.insertFirst(1);
        doubleListNode.insertFirst(2);
        doubleListNode.insertFirst(3);

        doubleListNode.insertLast(8);
        doubleListNode.insertLast(9);
        doubleListNode.insertLast(10);
        doubleListNode.displayList();
    }

}
