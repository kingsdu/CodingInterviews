package Jianzhi_Offer;


import java.util.ArrayList;

/**
 * 每日一练，自己写算法
 */
public class Test_Day
{
    
    public static void main(String[] args)
    {
        
        int[] a = {1,2,3};
        int[] b;
        b = a;
    
        for (int x :
                b)
        {
            System.out.print(x+" ");
        }
    }
    
    public ArrayList<Integer> printListFromTailToHead(ListNode.Node listNode)
    {
        ListNode.Node head = null;
        ListNode.Node next = null;
        ArrayList<Integer> resList = new ArrayList<>();
        
        
        /**
         *
         * 这段循环有技巧
         *
         */
        while (listNode != null)
        {
            next = listNode.next;
            listNode.next = head;
            head = listNode;
            listNode = next;
        }
        
        
        while (head != null)
        {
            resList.add(head.val);
            head = head.next;
        }
        
        return resList;
    }
    
}
