package DoExercise.HSP_ZCY.A028_比较器;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @Author: Du
 * @Date: 2021/6/15 13:18
 * <p>
 * <p>
 * 测试链接：https://leetcode.com/problems/merge-k-sorted-lists/
 *
 * 这个程序思路好
 */
public class C03_MergeKSortedLists
{
    public static class ListNode
    {
        public int val;
        public ListNode next;
        
        public ListNode(int v)
        {
            this.val = v;
        }
    }
    
    public static class ListNodeComparator implements Comparator<ListNode>
    {
        @Override
        public int compare(ListNode o1, ListNode o2)
        {
            return o1.val - o2.val;
        }
    }
    
    /**
     * @param lists n个链表的头，lists[0]中有一个链表、lists[1]中有一个链表.......
     * @return
     */
    public static ListNode mergeKLists(ListNode[] lists)
    {
        if (lists == null)
        {
            return null;
        }
        PriorityQueue<ListNode> priorityQueue = new PriorityQueue<>(new ListNodeComparator());//小根堆
        for (int i = 0; i < lists.length; i++)
        {
            if (lists[i] != null)
            {
                priorityQueue.add(lists[i]);//头节点进入小根堆
            }
        }
        if (priorityQueue.isEmpty())
        {
            return null;
        }
        ListNode head = priorityQueue.poll();//整体的头部，返回的结果
        ListNode pre = head;//1 - 3 - 4
        if (pre.next != null)//第一个链表的头已经处理完毕
        {
            priorityQueue.add(pre.next);//将剩下的3 - 4放入小根堆继续
        }
        while (!priorityQueue.isEmpty())
        {
            ListNode cur = priorityQueue.poll();//取出小根堆中最小元素
            pre.next = cur;
            pre = cur;
            if (cur.next != null)
            {
                priorityQueue.add(cur.next);//再次将下一个节点放入小根堆
            }
        }
        return head;
    }
    
    
    public static void main(String[] args)
    {
        ListNode a1 = new ListNode(2);
        ListNode a2 = new ListNode(4);
        ListNode a3 = new ListNode(5);
        a1.next = a2;
        a2.next = a3;
        
        ListNode b1 = new ListNode(1);
        ListNode b2 = new ListNode(3);
        ListNode b3 = new ListNode(4);
        b1.next = b2;
        b2.next = b3;
    
        ListNode c1 = new ListNode(4);
        ListNode c2 = new ListNode(6);
        c1.next = c2;
    
        ListNode[] lists = new ListNode[]{a1,b1,c1};
        mergeKLists(lists);
    }
}
