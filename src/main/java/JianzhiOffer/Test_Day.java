package JianzhiOffer;

import java.util.ArrayList;
import java.util.Stack;

/**
 * 输入一个链表，按链表从尾到头的顺序返回一个ArrayList。
 * {67,0,24,58}
 * [58,24,0,67]
 */
public class Test_Day
{
    public static ArrayList<ListNode> list = new ArrayList();
    static Stack<ListNode> stack = new Stack<>();
    
    public static void main(String[] args)
    {
        Test_Day t = new Test_Day();
        
        ListNode r1 = new ListNode(67);
        ListNode r2 = new ListNode(0);
        ListNode r3 = new ListNode(24);
        ListNode r4 = new ListNode(58);
        
        r1.next = r2;
        r2.next = r3;
        r3.next = r4;
        r4.next = null;
    
        ListNode listNode = t.printList3(r1);
    
        while (listNode!=null){
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }
    
    
    public void printList1(ListNode node)
    {
        if (node != null)
        {
            printList1(node.next);
            list.add(node);
        }
    }
    
    public void printList2(ListNode node)
    {
        while (node != null)
        {
            stack.push(node);
            node = node.next;
        }
    }
    
    public ListNode printList3(ListNode node)
    {
        ListNode pre = null, next = null;
        while (node != null)
        {
            next = node.next;
            node.next = pre;
            pre = node;
            node = next;
        }
        return pre;
    }
    
    public static class ListNode
    {
        public int val;
        public ListNode next;
        
        public ListNode(int x)
        {
            val = x;
            next = null;
        }
    }
    
}
