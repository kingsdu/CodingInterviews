package Jianzhi_Offer;


import java.util.Stack;

/**
 *
 * 输入一个链表，反转链表后，输出新链表的表头。
 *
 * {1,2,3}
 * {3,2,1}
 */
public class Offer015_ReverseList
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
        printListNode(head);
        ListNode listNode = ReverseList_2(head);
        printListNode(listNode);
    }
    
    
    /**
     *
     *
     * 思路：可以先用一个stack将单链表的指针都存起来，然后再构造链表。
     * 时间复杂度：O(n)
     * 空间复杂度：O(n), 用了一个stack来存单链表
     *
     * 这种方法比较容易理解，但面试官一定不是要这种答案
     * @param head
     * @return
     */
    public static ListNode ReverseList_1(ListNode head) {
        if(head == null){
            return null;
        }
        
        Stack<ListNode> stack = new Stack<>();
        while (head != null){
            stack.push(head);
            head = head.next;
        }

        ListNode newNode = stack.pop();
        ListNode resHead = newNode;
        while (!stack.isEmpty()){
            newNode.next = stack.pop();
            newNode = newNode.next;
        }
        newNode.next = null;
        return resHead;
    }
    
    
    /**
     * 方法2：题目对于某一个节点来说，就是要交换该节点和节点的next的关系
     *
     * 不太好理解，还需要加深理解
     *
     * @param head
     * @return
     */
    public static ListNode ReverseList_2(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
    
        ListNode pre = null;
        ListNode next = null;
        
        while (head!=null){
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
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
    
    
    /**
     *
     * while (curNode != null)  和  while (curNode.next != null) 的区别
     *
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
        
//        System.out.println(curNode.val);
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
