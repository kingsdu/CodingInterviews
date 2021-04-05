package Jianzhi_Offer;


import java.util.ArrayList;

/**
 *
 * 每日一练，自己写算法
 *
 *
 */
public class Test_Day
{


    public static void main(String[] args)
    {
        Test_Day test_day = new Test_Day();
        ListNode listNode = new ListNode();
        listNode.addNodeOrder(1);
        listNode.addNodeOrder(2);
//        listNode.addNodeOrder(3);
        listNode.printListNode();
        test_day.printListFromTailToHead(listNode.head);
    }

    public ArrayList<Integer> printListFromTailToHead(ListNode.Node listNode) {
        ListNode.Node head = null;
        ListNode.Node next = null;
        ArrayList<Integer> resList = new ArrayList<>();


        /**
         *
         * 这段循环有技巧
         *
         */
        while (listNode !=null){
            next = listNode.next;
            listNode.next = head;
            head = listNode;
            listNode = next;
        }


        while (head != null){
            resList.add(head.val);
            head = head.next;
        }

        return resList;
    }

}
