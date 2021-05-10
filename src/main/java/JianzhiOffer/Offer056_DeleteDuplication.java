package JianzhiOffer;

/**
 * 在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。
 * 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
 * <p>
 * {1,2,3,3,4,4,5}
 * {1,2,5}
 *
 * 思路：
 * 1、递归
 * 2、人为设置头节点
 */
public class Offer056_DeleteDuplication
{
    
    public static void main(String[] args)
    {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(1);
        ListNode n3 = new ListNode(1);
        ListNode n4 = new ListNode(3);
        ListNode n5 = new ListNode(4);
        ListNode n6 = new ListNode(4);
        ListNode n7 = new ListNode(5);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        n6.next = n7;
        ListNode listNode = deleteDuplication2(n1);
        while (listNode != null)
        {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }
    
    
    //1,1,1,1,1,1,2,3,4
    public static ListNode deleteDuplication(ListNode pHead)
    {
        if (pHead == null || pHead.next == null)
        {
            return pHead;
        }
        ListNode pre = null;
        ListNode tmp = pHead;
        while (tmp.next != null)
        {
            if (tmp.val == tmp.next.val)
            {
                while (tmp.next != null && tmp.val == tmp.next.val)
                {
                    tmp = tmp.next;
                }
                if (pre == null)
                {
                    //没有考虑到出现多次的情况；也没有考虑到头部是多个重复的情况
                } else
                {
                    if (tmp.next != null)
                    {
                        ListNode next = tmp.next;
                        tmp = pre;
                        tmp.next = next;
                    } else
                    {
                        tmp = pre;
                        tmp.next = null;
                    }
                }
            } else
            {
                pre = tmp;
            }
            tmp = tmp.next;
        }
        return pHead;
    }
    
    /**
     * 设定了一个头部节点，保证无论怎样都能拿到前一个节点
     * 但这个方法会有个问题，如果题目规定任何数字都可能会重复就有问题，递归的方式更好
     * @param pHead
     * @return
     */
    public static ListNode deleteDuplication2(ListNode pHead)
    {
        if (pHead == null || pHead.next == null) return pHead;
        ListNode head = new ListNode(0);//始终有个头
        head.next = pHead;
        ListNode fast = head.next, slow = head;
        while (fast != null && fast.next != null)
        {
            if (fast.val == fast.next.val)
            {
                while (fast.next != null && fast.val == fast.next.val)
                {
                    fast = fast.next;
                }
                slow.next = fast.next;
                fast = fast.next;
            } else
            {
                slow = slow.next;
                fast = fast.next;
            }
        }
        return head.next;
    }
    
    /**
     * 递归的方法，也可以解决头部节点的问题
     *
     * @param pHead
     * @return
     */
    public static ListNode deleteDuplication3(ListNode pHead)
    {
        if (pHead == null || pHead.next == null)
        {
            return pHead;
        }
        ListNode next = pHead.next;
        if (pHead.val == next.val)
        {
            while (next != null && pHead.val == next.val)
            {
                next = next.next;
            }
            return deleteDuplication3(next);//将next作为新节点处理
        } else
        {
            pHead.next = deleteDuplication3(pHead.next);//否则则都有联系
            return pHead;
        }
        
    }
    
    
    static class ListNode
    {
        int val;
        ListNode next = null;
        
        ListNode(int val)
        {
            this.val = val;
        }
    }
}
