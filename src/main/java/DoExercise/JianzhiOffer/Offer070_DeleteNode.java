package DoExercise.JianzhiOffer;

/**
 * 给定单向链表的头指针和一个要删除的节点的值，定义一个函数删除该节点。返回删除后的链表的头节点。
 * <p>
 * 输入: head = [4,5,1,9], val = 5
 * 输出: [4,1,9]
 * 解释: 给定你链表中值为的第二个节点，那么在调用了你的函数之后，该链表应变为 4 -> 1 -> 9.
 *
 * @Author: Du
 * @Date: 2021/6/8 10:35
 */
public class Offer070_DeleteNode
{
    
    public static void main(String[] args)
    {
        ListNode l1 = new ListNode(4);
        ListNode l2 = new ListNode(5);
        ListNode l3 = new ListNode(1);
        ListNode l4 = new ListNode(8);
        ListNode l5 = new ListNode(11);
        ListNode l6 = new ListNode(3);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        l5.next = l6;
        l6.next = null;
        
        deleteNode2(l1, 8);
    }
    
    public static ListNode deleteNode(ListNode head, int val)
    {
        if (head.val == val) return head.next;
        ListNode tmp = head.next;
        ListNode pre = head;
        while (tmp != null && tmp.val != val)
        {
            pre = tmp;
            tmp = tmp.next;
        }
        if (tmp != null) pre.next = tmp.next;
        return head;
    }
    
    
    /**
     *
     * 双百
     *
     * @param head
     * @param val
     * @return
     */
    public static ListNode deleteNode2(ListNode head, int val)
    {
        if (head.val == val) return head.next;
        ListNode tmp = head.next;
        ListNode pre = head;
        while (tmp != null)
        {
            if (tmp.val == val)
            {
                pre.next = tmp.next;//改节点一定是next，而不是本节点
                break;
            } else
            {
                pre = tmp;
            }
            tmp = tmp.next;
        }
        return head;
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
