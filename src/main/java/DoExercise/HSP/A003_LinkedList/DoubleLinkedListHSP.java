package DoExercise.HSP.A003_LinkedList;

/**
 * 双端链表：可以在队头、队尾插入、删除
 * <p>
 * 最大的优势是删除时可以直接那 node.pre.next = node.next;
 */
public class DoubleLinkedListHSP
{
    
    public static void main(String[] args)
    {
        DoubleLinkedListHSP dq = new DoubleLinkedListHSP(3);
        dq.insertHead(new DoubleNode(null, 1, null));
        dq.insertHead(new DoubleNode(null, 2, null));
        dq.insertHead(new DoubleNode(null, 3, null));
        dq.printListNode();
    }
    
    
    public DoubleNode head;
    public int size;
    
    public DoubleLinkedListHSP()
    {
        this.size = 0;
        this.head = null;
    }
    
    public DoubleLinkedListHSP(int size)
    {
        this.size = size;
        this.head = null;
    }
    
    public int getSize()
    {
        return this.size;
    }
    
    public boolean isEmpty()
    {
        return getSize() == 0;
    }
    
    
    public void insertHead(DoubleNode node)
    {
        if (isEmpty())
        {
            head = node;
            this.size++;
            return;
        }
        
        final DoubleNode tmp = head;
        node.next = tmp;
        node.pre = null;
        tmp.pre = node;
        head = node;
        this.size++;
    }
    
    public void insertLast(DoubleNode node)
    {
        if (isEmpty())
        {
            head = node;
            this.size++;
            return;
        }
        
        DoubleNode tmp = head;
        while (tmp.next != null)
        {
            tmp = tmp.next;
        }
        tmp.next = node;
        node.pre = tmp;
        this.size++;
    }
    
    
    public void removeHead()
    {
        if (isEmpty())
        {
            return;
        }
        // help GC
        final DoubleNode tmpHead = this.head;
        final DoubleNode next = tmpHead.next;
        tmpHead.val = null;
        tmpHead.next = null;
        head = next;
        next.pre = null;
        this.size--;
    }
    
    public void removeLast()
    {
        if (isEmpty())
        {
            return;
        }
        DoubleNode tmp = head;
        while (tmp.next != null)
        {
            tmp = tmp.next;
        }
        // help GC
        final DoubleNode lastTmp = tmp;
        lastTmp.val = null;
        lastTmp.pre.next = null;
        if (lastTmp.next != null)
        {
            lastTmp.next.pre = lastTmp.pre;
        } else
        {
            lastTmp.pre = null;
        }
        this.size--;
    }
    
    
    public void printListNode()
    {
        if (isEmpty())
        {
            return;
        }
        DoubleNode headTmp = this.head;
        while (headTmp != null)
        {
            System.out.print(headTmp.val + " ");
            headTmp = headTmp.next;
        }
    }
    
    
    public static class DoubleNode
    {
        
        public Integer val;
        public DoubleNode pre;
        public DoubleNode next;
        
        public DoubleNode()
        {
            this.val = null;
            this.pre = null;
            this.next = null;
        }
        
        public DoubleNode(DoubleNode pre, int val, DoubleNode next)
        {
            this.pre = pre;
            this.val = val;
            this.next = next;
        }
    }
}


