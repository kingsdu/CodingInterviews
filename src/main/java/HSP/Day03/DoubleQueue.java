package HSP.Day03;

/**
 * 双端队列：可以在队头、队尾插入、删除
 *
 * 最大的优势是删除时可以直接那 node.pre.next = node.next;
 */
public class DoubleQueue
{
    public DoubleNode head;
    public int size;
    
    public DoubleQueue(){
        this.size = 0;
        this.head = null;
    }
    
    public DoubleQueue(int size)
    {
        this.size = size;
        this.head = null;
    }
    
    
    public static void main(String[] args)
    {
        DoubleQueue dq = new DoubleQueue();
        dq.insertHead(new DoubleNode(null,1,null));
        dq.insertHead(new DoubleNode(null,2,null));
        dq.insertHead(new DoubleNode(null,3,null));
        dq.printListNode();
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
        lastTmp.val= null;
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
    
    
    public void printListNode(){
        if(isEmpty()){
            return;
        }
        DoubleNode headTmp = this.head;
        while (headTmp!=null){
            System.out.print(headTmp.val+" ");
            headTmp = headTmp.next;
        }
    }
    
}
