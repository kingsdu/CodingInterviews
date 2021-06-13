package DoExercise.HSP_ZCY.A026_链表;

/**
 * @Author: Du
 * @Date: 2021/6/13 11:48
 *
 * 单链表反转
 * 双端链表反转
 *
 */
public class Code01_ReverseList
{
    
    /**
     *
     * 单链表反转
     *
     * @param head
     * @return
     */
    public static Node reverseLinkedList(Node head)
    {
        Node pre = null;
        Node next = null;
        
        while (head != null)
        {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }
    
    
    /**
     *
     * 双端链表反转
     *
     * @param head
     * @return
     */
    public static DoubleNode reverseDoubleList(DoubleNode head)
    {
        DoubleNode pre = null;
        DoubleNode next = null;
        while (head != null)
        {
            next = head.next;
            head.next = pre;
            head.last = next;
            pre = head;
            head = next;
        }
        return pre;
    }
    
    
    public static class DoubleNode
    {
        public int value;
        public DoubleNode last;
        public DoubleNode next;
        
        public DoubleNode(int data)
        {
            value = data;
        }
    }
    
    public static class Node
    {
        public int value;
        public Node next;
        
        public Node(int data)
        {
            value = data;
        }
    }
}
