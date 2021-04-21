package DataStruct.MyOverride.Stack;


/**
 * 链表实现栈结构
 * 栈：先入后出，后入先出
 * <p>
 * <p>
 * 思路：主要是在写入节点时，每写入一次，head指向新加入的节点
 * 优点：
 * 1、栈规模的增加和减小都很简洁
 * 2、每个操作都是常数时间开销
 * 3、每个操作都需要使用额外的空间和时间来处理指针
 */
public class StackLinked
{
    public static LinkNode head;
    
    public static void main(String[] args)
    {
        StackLinked sl = new StackLinked();
        sl.push(1);
        sl.push(2);
        System.out.println(sl.peek().val);
        while (!sl.isEmpty())
        {
            System.out.println(sl.pop().val);
        }
    }
    
    public boolean isEmpty()
    {
        return head == null;
    }
    
    public void push(int val)
    {
        if (head == null)
        {
            head = new LinkNode(val);
        } else
        {
            LinkNode newNode = new LinkNode(val);
            newNode.next = head;
            head = newNode;
        }
    }
    
    
    public LinkNode pop()
    {
        if (head == null)
        {
            return null;
        } else
        {
            LinkNode node = StackLinked.head;
            head = head.next;
            return node;
        }
    }
    
    
    public LinkNode peek()
    {
        if (head == null)
        {
            return null;
        } else
        {
            return head;
        }
    }
    
    
    public static class LinkNode
    {
        public int val;
        public LinkNode next;
        
        public LinkNode(int val)
        {
            this.val = val;
            this.next = null;
        }
    }
    
}
