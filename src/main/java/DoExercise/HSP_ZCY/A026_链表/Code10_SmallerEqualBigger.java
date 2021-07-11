package DoExercise.HSP_ZCY.A026_链表;


/**
 * 将单向链表按某值划分成左边小、中间相等、右边大的形式
 * 快速排序的partition
 */
public class Code10_SmallerEqualBigger
{
    public static class Node
    {
        public int value;
        public Node next;
        
        public Node(int data)
        {
            this.value = data;
        }
    }
    
    /**
     * 将链表的数据转化为数组，在数组中进行partition，将排好序的数据赋值根链表
     *
     * @param head
     * @param pivot
     * @return
     */
    public static Node listPartition1(Node head, int pivot)
    {
        if (head == null) return null;
        Node cur = head;
        int i = 0;
        while (cur != null)
        {
            i++;
            cur = cur.next;
        }
        Node[] nodeArr = new Node[i];
        i = 0;
        cur = head;
        for (i = 0; i != nodeArr.length; i++)
        {
            nodeArr[i] = cur;
            cur = cur.next;
        }
        arrPartition(nodeArr, pivot);
        for (i = 1; i != nodeArr.length; i++)
        {
            nodeArr[i - 1].next = nodeArr[i];
        }
        nodeArr[i - 1].next = null;
        return nodeArr[0];
    }
    
    public static void arrPartition(Node[] nodeArr, int pivot)
    {
        int small = -1;
        int big = nodeArr.length;
        int index = 0;
        while (index != big)
        {
            if (nodeArr[index].value < pivot)
            {
                swap(nodeArr, ++small, index++);
            } else if (nodeArr[index].value == pivot)
            {
                index++;
            } else
            {
                swap(nodeArr, --big, index);
            }
        }
    }
    
    public static void swap(Node[] nodeArr, int a, int b)
    {
        Node tmp = nodeArr[a];
        nodeArr[a] = nodeArr[b];
        nodeArr[b] = tmp;
    }
    
    /**
     *
     * 分为小于区、等于区、大于区
     *
     * 比较数字后，将链表中的值分别放入到 小于区 等于区 大于区
     *
     * 链表所有结点装载完毕后
     *
     * 小于区 -> 等于区 -> 大于区
     *
     * @param head
     * @param pivot
     * @return
     */
    public static Node listPartition2(Node head, int pivot)
    {
        Node sH = null;
        Node sT = null;
        Node eH = null;
        Node eT = null;
        Node mH = null;
        Node mT = null;
        Node next = null;
        while (head != null)
        {
            next = head.next;
            head.next = null;
            if (head.value < pivot)
            {
                if (sH == null)
                {
                    sH = head;
                } else
                {
                    sT.next = head;
                }
                sT = head;
            } else if (head.value == pivot)
            {
                if (eH == null)
                {
                    eH = head;
                } else
                {
                    eT.next = head;
                }
                eT = head;
            } else
            {
                if (mH == null)
                {
                    mH = head;
                } else
                {
                    mT.next = head;
                }
                mT = head;
            }
            head = next;
        }
        if (sT != null)
        {
            sT.next = eH;
            eT = eT == null ? sT : eT;
        }
        if (eT != null)
        {
            eT.next = mH;
        }
        return sH != null ? sH : (eH != null ? eH : mH);
    }
    
    public static void printLinkedList(Node node)
    {
        System.out.print("Linked List: ");
        while (node != null)
        {
            System.out.print(node.value + " ");
            node = node.next;
        }
        System.out.println();
    }
    
    public static void main(String[] args)
    {
        Node head1 = new Node(7);
        head1.next = new Node(9);
        head1.next.next = new Node(1);
        head1.next.next.next = new Node(8);
        head1.next.next.next.next = new Node(5);
        head1.next.next.next.next.next = new Node(2);
        head1.next.next.next.next.next.next = new Node(5);
        printLinkedList(head1);
        
        head1 = listPartition2(head1, 5);
        printLinkedList(head1);
        
    }
    
}
