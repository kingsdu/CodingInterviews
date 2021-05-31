package DoExercise.HSP_ZCY.A003_LinkedList;

import java.util.ArrayList;
import java.util.List;

/**
 * Josephu 问题：
 * <p>
 * 确定最后出队的人
 * 据说著名犹太历史学家 Josephus 有过以下的故事：
 * 在罗马人占领乔塔帕特后，39 个犹太人与Josephus及他的朋友躲到一个洞中，
 * 39个犹太人决定宁愿死也不要被敌人抓到，于是决定了一个自杀方式，41个人排成一个圆圈，
 * 由第1个人开始报数，每报数到3的人，该人就必须自杀，然后再由下一个重新报数，直到所有人都自杀身亡为止。
 * 然而 Josephus 和他的朋友并不想遵从。
 * 首先从一个人开始，越过k-2个人（因为第一个人已经被越过），并杀掉第k个人。
 * 接着，再越过k-1个人，并杀掉第k个人。这个过程沿着圆圈一直进行，
 * 直到最终只剩下一个人留下，这个人就可以继续活着。
 * 问题是，给定了和，一开始要站在什么地方才能避免被处决呢？
 * Josephus 要他的朋友先假装遵从，他将朋友与自己安排在第16个与第31个位置，于是逃过了这场死亡游戏。
 * <p>
 * <p>
 * 循环链表
 * 思路：
 * 1、设置 head 和 tail 节点。
 * 2、插入时，将 tail 指向新节点。
 * 3、将 tail 的 next = head。
 */
public class JosephuHSP
{
    
    public static ListNode head;
    public static ListNode tail;
    public static int size = 1;
    
    
    public static void main(String[] args)
    {
        for (int i = 1; i <= 5; i++)
        {
            addNodeOrder(i);
        }
//        printListNode(head);
        ListNode listNode = JosephuProblem_1(0, 2);
        printListNode(listNode);
        ListNode listNode1 = JosephuProblem_2(5, 2);
        printListNode(listNode1);
    }
    
    
    /**
     * 确定最后出队的人
     *
     * @param child  从第几个孩子开始数
     * @param number 数几下
     */
    public static ListNode JosephuProblem_1(int child, int number)
    {
        boolean isFirst = true;
        ListNode preNode = tail;
        ListNode curNode = head;
        //链表为空，或者只有一个节点，或者链表中的小朋友人数不足
        if (head == null || size < child)
        {
            return null;
        }
        if (tail == head)
        {
            return head;
        }
        
        while (size > 2 || preNode != curNode)
        {
            //移动到第几个孩子，只是第一个孩子有效
            if (isFirst)
            {
                //找到第一个孩子
                for (int i = 0; i < child - 1; i++)
                {
                    preNode = preNode.next;
                    curNode = curNode.next;
                }
                isFirst = false;
                //数几下
                for (int i = 0; i < number; i++)
                {
                    preNode = preNode.next;
                    curNode = curNode.next;
                }
            } else
            {
                //数几下
                for (int i = 0; i < number; i++)
                {
                    preNode = preNode.next;
                    curNode = curNode.next;
                }
            }
            curNode = curNode.next;
            preNode.next = curNode;
            size--;
        }
        
        curNode.next = null;
        return curNode;
    }
    
    
    /**
     * 用Arraylist来解决移除问题
     *
     * 思路：
     * 假设当前删除的位置是 index（从第一个开始），下一个删除的数字的位置是 index+number。
     * 但是，由于把当前位置的数字删除了，后面的数字会前移一位，所以实际的下一个位置是 index+number−1。
     * 由于数到末尾会从头继续数，所以最后取模一下，就是 (index+number - 1)%child（剩下的孩子数量）。
     *
     * @param child  总孩子的个数
     * @param number 向后数的个数
     * @return
     */
    public static ListNode JosephuProblem_2(int child, int number)
    {
        List<ListNode> list = new ArrayList<>();
        for (int i = 1; i <= child; i++)
        {
            list.add(new ListNode(i));
        }
        
        int index = 0;//从第一个开始，往后数
        while (child > 1)
        {
            index = (index + number) % child;
            list.remove(index);
            child--;
        }
        return list.get(0);
    }
    

    
    
    /**
     * 循环链表，表尾指向表头
     *
     * @param value
     */
    public static void addNodeOrder(int value)
    {
        ListNode newNode = new ListNode(value);
        if (head == null)
        {
            head = newNode;
            tail = head;
            tail.next = head;
            return;
        }
        tail.next = null;
        ListNode tmp = head;
        while (tmp.next != null)
        {
            tmp = tmp.next;
        }
        
        tmp.next = newNode;
        tail = tmp.next;
        tail.next = head;
        size++;
    }
    
    
    /**
     * while (curNode != null)  和  while (curNode.next != null) 的区别
     * <p>
     * 如果你要在循环里面处理node，则需要写  while (curNode != null)
     * 如果你只是为了找到最后一个node，在循环外面处理node，则需要写 while (curNode.next != null)
     *
     * @param node
     */
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
        public int val;
        public ListNode next = null;
        
        public ListNode(int val)
        {
            this.val = val;
        }
    }
    
}
