package DoExercise.JianzhiOffer;

import java.util.ArrayList;

/**
 * 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
 */
public class TestDay
{
    public static ListNode head;
    
    public static void main(String[] args)
    {
        addNodeOrder(1);
        addNodeOrder(2);
        addNodeOrder(3);
        addNodeOrder(4);
        addNodeOrder(5);
        addNodeOrder(6);
    
        reversePrint(head);
    }
    
    public static int[] reversePrint(ListNode head)
    {
        ArrayList<Integer> tmp = new ArrayList<Integer>();
        ListNode pre = null;
        ListNode next = null;
        while (head != null)
        {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        
        while (pre != null)
        {
            tmp.add(pre.val);
            pre = pre.next;
        }
        
        return  null;
    }
    
    
    public static void addNodeOrder(int value)
    {
        ListNode newNode = new ListNode(value);
        ListNode curNode;
        
        if (head == null)
        {
            head = newNode;
            return;
        }
        
        curNode = head;
        
        while (curNode.next != null)
        {
            curNode = curNode.next;
        }
        
        curNode.next = newNode;
    }
    
    
    public static class ListNode
    {
        int val;
        ListNode next;
        
        ListNode(int x)
        {
            val = x;
        }
    }
    
}
