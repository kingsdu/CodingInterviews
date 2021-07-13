package DoExercise.HSP_ZCY.A026_链表;

/**
 * 给定两个可能有环也可能无环的单链表，头节点head1和head2。
 * 请实现一个函数，如果两个链表相交，请返回相交的第一个节点。如果不相交，返回null。
 * <p>
 * 【要求】
 * 如果两个链表长度之和为N，时间复杂度请达到O(N)，额外空间复杂度请达到O(1)。
 *
 *
 * 两个无环链表的第一个相交节点
 *
 */
public class Code12_FindFirstIntersectNode
{
    
    public static void main(String[] args)
    {
        // 1->2->3->4->5->6->7->null
        Node head1 = new Node(1);
        head1.next = new Node(2);
        head1.next.next = new Node(3);
        head1.next.next.next = new Node(4);
        head1.next.next.next.next = new Node(5);
        head1.next.next.next.next.next = new Node(6);
        head1.next.next.next.next.next.next = new Node(7);
        
        // 0->9->8->6->7->null
        Node head2 = new Node(0);
        head2.next = new Node(9);
        head2.next.next = new Node(8);
        head2.next.next.next = head1.next.next.next.next.next; // 8->6
        System.out.println(getIntersectNode(head1, head2).value);
        
        // 1->2->3->4->5->6->7->4...
        head1 = new Node(1);
        head1.next = new Node(2);
        head1.next.next = new Node(3);
        head1.next.next.next = new Node(4);
        head1.next.next.next.next = new Node(5);
        head1.next.next.next.next.next = new Node(6);
        head1.next.next.next.next.next.next = new Node(7);
        head1.next.next.next.next.next.next = head1.next.next.next; // 7->4
        
        // 0->9->8->2...
        head2 = new Node(0);
        head2.next = new Node(9);
        head2.next.next = new Node(8);
        head2.next.next.next = head1.next; // 8->2
        System.out.println(getIntersectNode(head1, head2).value);
        
        // 0->9->8->6->4->5->6..
        head2 = new Node(0);
        head2.next = new Node(9);
        head2.next.next = new Node(8);
        head2.next.next.next = head1.next.next.next.next.next; // 8->6
        System.out.println(getIntersectNode(head1, head2).value);
    }
    
    
    public static class Node
    {
        public int value;
        public Node next;
        
        public Node(int data)
        {
            this.value = data;
        }
    }
    
    
    public static Node getIntersectNode(Node head1, Node head2)
    {
        if (head1 == null || head2 == null)
        {
            return null;
        }
        Node loop1 = getLoopNode(head1);
        Node loop2 = getLoopNode(head2);
        if (loop1 == null && loop2 == null)//两个无环链表的相交问题
        {
            return noLoop(head1, head2);
        }
        if (loop1 != null && loop2 != null)//两个有环链表的相交问题
        {
            return bothLoop(head1, loop1, head2, loop2);
        }
        return null;//其他问题不可相交
    }
    
    
    /**
     * 找到链表第一个入环节点，如果无环，返回null
     * 小学奥赛的证明问题
     *
     * @param head
     * @return
     */
    public static Node getLoopNode(Node head)
    {
        if (head == null || head.next == null || head.next.next == null)
        {
            return null;
        }
        Node n1 = head.next;
        Node n2 = head.next.next;
        while (n1 != n2)
        {
            if (n2.next == null || n2.next.next == null)
            {
                return null;
            }
            n2 = n2.next.next;
            n1 = n1.next;
        }
        n2 = head;
        while (n1 != n2)
        {
            n1 = n1.next;
            n2 = n2.next;
        }
        return n1;
    }
    
    // 如果两个链表都无环，返回第一个相交节点，如果不想交，返回null
    public static Node noLoop(Node head1, Node head2)
    {
        if (head1 == null || head2 == null)
        {
            return null;
        }
        Node cur1 = head1;
        Node cur2 = head2;
        int n = 0; // n  :  链表1长度减去链表2长度的值
        while (cur1.next != null)
        {
            n++;
            cur1 = cur1.next;
        }
        while (cur2.next != null)
        {
            n--;
            cur2 = cur2.next;
        }
        //相交则最后一个节点必定相等
        if (cur1 != cur2)
        {
            return null;
        }
        cur1 = n > 0 ? head1 : head2; // 谁长，谁的头变成cur1
        cur2 = cur1 == head1 ? head2 : head1; // 谁短，谁的头变成cur2
        n = Math.abs(n);
        //长链表先走n步，短链表再开始走，则一定会相遇
        while (n != 0)
        {
            n--;
            cur1 = cur1.next;
        }
        while (cur1 != cur2)
        {
            cur1 = cur1.next;
            cur2 = cur2.next;
        }
        return cur1;
    }
    
    // 两个有环链表，返回第一个相交节点，如果不想交返回null
    public static Node bothLoop(Node head1, Node loop1, Node head2, Node loop2)
    {
        Node cur1 = null;
        Node cur2 = null;
        if (loop1 == loop2)//入环节点是一个，相交的节点相等，则返回相交的节点
        {
            cur1 = head1;
            cur2 = head2;
            int n = 0;
            while (cur1 != loop1)
            {
                n++;
                cur1 = cur1.next;
            }
            while (cur2 != loop2)
            {
                n--;
                cur2 = cur2.next;
            }
            cur1 = n > 0 ? head1 : head2;
            cur2 = cur1 == head1 ? head2 : head1;
            n = Math.abs(n);
            while (n != 0)
            {
                n--;
                cur1 = cur1.next;
            }
            while (cur1 != cur2)
            {
                cur1 = cur1.next;
                cur2 = cur2.next;
            }
            return cur1;
        } else//入环节点不是同一个
        {
            cur1 = loop1.next;
            while (cur1 != loop1)
            {
                if (cur1 == loop2)
                {
                    return loop1;
                }
                cur1 = cur1.next;
            }
            return null;
        }
    }
}
