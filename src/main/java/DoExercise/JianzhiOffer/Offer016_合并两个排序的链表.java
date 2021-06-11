package DoExercise.JianzhiOffer;

/**
 * 输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
 * <p>
 * {1,3,5},{2,4,6}
 * {1,2,3,4,5,6}
 */
public class Offer016_合并两个排序的链表
{
    public static ListNode head;
    
    public static void main(String[] args)
    {
        ListNode list1 = addNodeOrder(null, 1);
        list1 = addNodeOrder(list1, 3);
        list1 = addNodeOrder(list1, 5);
        printListNode(list1);
        System.out.println();
        ListNode list2 = addNodeOrder(null, 2);
        list2 = addNodeOrder(list2, 4);
        list2 = addNodeOrder(list2, 6);
        printListNode(list2);
        System.out.println();
//        ListNode listNode = Merge_2(list1, list2);
//        printListNode(listNode);
//        System.out.println();
        ListNode listNode1 = mergeTwoLists1(list1, list2);
        printListNode(listNode1);
    }
    
    
    public ListNode mergeTwoLists(ListNode l1, ListNode l2)
    {
        ListNode res = new ListNode(0), cur = res;
        while (l1 != null && l2 != null)
        {
            if (l1.val < l2.val)
            {
                cur.next = l1;
                l1 = l1.next;
            } else
            {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        cur.next = l1 != null ? l1 : l2;
        return res.next;
    }
    
    
    /**
     * 递归算法
     * <p>
     * 该方法少创建了一个 ListNode res 去保存结果
     *
     * @param list1
     * @param list2
     * @return
     */
    public static ListNode mergeTwoLists1(ListNode list1, ListNode list2)
    {
        if (list1 == null)
        {
            return list2;
        } else if (list2 == null)
        {
            return list1;
        } else
        {
            if (list1.val < list2.val)
            {
                list1.next = mergeTwoLists1(list1.next, list2);
                return list1;
            } else
            {
                list2.next = mergeTwoLists1(list1, list2.next);
                return list2;
            }
        }
    }
    
    
    public static ListNode addNodeOrder(ListNode node, int value)
    {
        ListNode newNode = new ListNode(value);
        ListNode curNode;
        
        if (node == null)
        {
            node = newNode;
            return node;
        }
        
        curNode = node;
        while (curNode.next != null)
        {
            curNode = curNode.next;
        }
        curNode.next = newNode;
        return node;
    }
    
    public static void printListNode(ListNode node)
    {
        ListNode curNode = node;
        while (curNode != null)
        {
            System.out.print(curNode.val + " ");
            curNode = curNode.next;
        }
    }
    
    public static class ListNode
    {
        int val;
        ListNode next = null;
        
        public ListNode(int val)
        {
            this.val = val;
        }
    }
}
