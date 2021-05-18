package DoExercise.HSP.A003_LinkedList;

/**
 * 链表：单链表
 * <p>
 * 实现基本操作：增删改查
 *
 * index下标从0开始
 */
public class SingleLinkedListHSP
{
    
    public static void main(String[] args)
    {
        SingleLinkedListHSP ls = new SingleLinkedListHSP();
        ls.addFirst(1);
        ls.addNode(2);
        ls.addNodeIndex(3, 2);
        ls.addNodeIndex(4, 3);
        ls.addNodeReverse(5);
        ls.addNodeReverse(6);
        ls.removeLastNode();
        ls.removeNodeIndex(4);
        ls.editNodeIndex(1, 1);
        ls.pollNodeElement(new SingleNode(1));
        ls.pollNodeElement(new SingleNode(6));
        ls.printLinkedList();
        System.out.println(ls.containsElement(5) ? "有" : "没有");
        System.out.println(ls.getNodeIndex(1));
    }
    
    //单链表结构 包含 一个头部 和 链表的大小
    public SingleNode head;//头部
    public int size;//大小
    
    public SingleLinkedListHSP()
    {
        this.head = null;
        this.size = 0;
    }
    
    public boolean isEmpty()
    {
        return this.head == null;
    }
    
    
    public int getSize()
    {
        return this.size;
    }
    
    /**
     * 按照顺序新增链表
     */
    public void addNode(int value)
    {
        SingleNode newNode = new SingleNode(value);
        
        if (isEmpty())
        {
            head = new SingleNode(value);
            size++;
            return;
        }
        SingleNode curNode = head;//头部不能变
        while (curNode.next != null)
        {
            curNode = curNode.next;
        }
        
        curNode.next = newNode;
        size++;
    }
    
    
    /**
     * 增加头节点
     *
     * @param value
     */
    public void addFirst(int value)
    {
        if (!isEmpty())
        {
            return;
        }
        
        head = new SingleNode(value);
        size++;
    }
    
    
    /**
     * 逆序增加链表节点
     */
    public void addNodeReverse(int value)
    {
        SingleNode newNode = new SingleNode(value);
        if (isEmpty())
        {
            head = new SingleNode(value);
            size++;
            return;
        }
        
        newNode.next = head;
        head = newNode;
        size++;
    }
    
    
    /**
     * 要保证
     * 1、
     *
     * @param value
     * @param index 从0开始
     */
    public void addNodeIndex(int value, int index)
    {
        if (index < 0 || index > getSize())
        {
            throw new IllegalArgumentException("index is error");
        }
        SingleNode newNode = new SingleNode(value);
        SingleNode curNode = this.head;
        SingleNode preNode = curNode;
        
        if (index == getSize())
        {
            while (curNode.next != null)
            {
                curNode = curNode.next;
            }
            curNode.next = newNode;
            newNode.next = null;
            size++;
            return;
        } else if (index == 0)
        {
            newNode.next = curNode;
            head = newNode;
            size++;
            return;
        }
        
        //链表从1开始计数
        while (index > 0 && curNode.next != null)
        {
            index--;
            preNode = curNode;
            curNode = curNode.next;
        }
        preNode.next = newNode;
        newNode.next = curNode;
        this.size++;
    }
    
    
    /**
     * 返回链表的最后一个值
     *
     * @return
     */
    public SingleNode getLastNode()
    {
        if (isEmpty())
        {
            throw new IllegalArgumentException("链表为空");
        }
        SingleNode curNode = head;
        while (curNode.next != null)
        {
            curNode = curNode.next;
        }
        return curNode;
    }
    
    
    /**
     * 获取链表中指定位置的元素
     *
     * @param index 从0开始
     * @return
     */
    public SingleNode getNodeIndex(int index)
    {
        if (index < 0 || index > getSize() - 1)
        {
            throw new IllegalArgumentException("无效下标");
        }
        if (isEmpty())
        {
            throw new IllegalArgumentException("链表为空");
        }
        
        SingleNode curNode = head;
        
        if (index == getSize() - 1)
        {
            return getLastNode();
        } else if (index == 0)
        {
            return head;
        }
        
        while (index > 0 && curNode.next != null)
        {
            curNode = curNode.next;
            index--;
        }
        return curNode;
    }
    
    
    /**
     * 删除链表尾部元素
     * <p>
     * 需要验证改变curNode的值，是否会影响到链表中的值。
     */
    public void removeLastNode()
    {
        if (isEmpty())
        {
            throw new IllegalArgumentException("链表为空");
        }
        
        SingleNode curNode = head;
        while (curNode.next.next != null)
        {
            curNode = curNode.next;
        }
        
        curNode.next = null;
        size--;
    }
    
    /**
     * 删除头节点
     */
    public void removeFirstNode()
    {
        if (isEmpty())
        {
            throw new IllegalArgumentException("链表为空");
        }
        
        SingleNode curNode = head;
        head = head.next;
        curNode.next = null;
        size--;
    }
    
    /**
     * 删除指定下标的链表的元素
     * <p>
     *
     * @param index
     */
    public void removeNodeIndex(int index)
    {
        if (isEmpty())
        {
            throw new IllegalArgumentException("链表为空");
        }
        if (index < 0 || index > getSize())
        {
            throw new IllegalArgumentException("无效下标");
        }
        //删除尾部元素
        if (index == getSize())
        {
            removeLastNode();
            return;
        } else if (index == 0)
        {
            removeFirstNode();
            return;
        }
        
        SingleNode curNode = head;
        SingleNode preNode = curNode;
        while (index > 0 && curNode.next != null)
        {
            preNode = curNode;
            curNode = curNode.next;
            index--;
        }
        preNode.next = curNode.next;
        size--;
    }
    
    
    /**
     * 删除链表中nodeElement元素，并返回
     *
     * @param node
     */
    public SingleNode pollNodeElement(SingleNode node)
    {
        if (isEmpty())
        {
            throw new IllegalArgumentException("链表为空");
        }
        
        SingleNode curNode = head;
        //第一个元素特殊处理
        if (head.val == node.val)
        {
            head = head.next;
            curNode.next = null;
            size--;
            return curNode;
        }
        
        SingleNode preNode = curNode;
        while (curNode.next != null)
        {
            preNode = curNode;
            if (curNode.val == node.val)
            {
                curNode = curNode.next;
                preNode.next = curNode.next;
                size--;
                return curNode;
            } else
            {
                curNode = curNode.next;
            }
        }
        return null;
    }
    
    
    /**
     * 修改链表节点
     *
     * @param index
     */
    public void editNodeIndex(int nodeValue, int index)
    {
        if (isEmpty())
        {
            throw new IllegalArgumentException("链表为空");
        }
        if (index < 0 || index > getSize())
        {
            throw new IllegalArgumentException("无效下标");
        }
        
        if (index == getSize())
        {
            editLastNode(nodeValue);
            return;
        } else if (index == 0)
        {
            editFirstNode(nodeValue);
            return;
        }
        
        SingleNode curNode = head;
        while (index > 0 && curNode.next != null)
        {
            index--;
            curNode = curNode.next;
        }
        curNode.val = nodeValue;
    }
    
    
    /**
     * 编辑链表头部的节点值
     *
     * @param nodeValue
     */
    public void editFirstNode(int nodeValue)
    {
        if (isEmpty())
        {
            throw new IllegalArgumentException("链表为空");
        }
        
        head.val = nodeValue;
    }
    
    
    /**
     * 编辑链表尾部的节点值
     *
     * @param nodeValue
     */
    public void editLastNode(int nodeValue)
    {
        if (isEmpty())
        {
            throw new IllegalArgumentException("链表为空");
        }
        
        SingleNode curNode = this.head;
        while (curNode.next != null)
        {
            curNode = curNode.next;
        }
        
        curNode.val = nodeValue;
    }
    
    /**
     * 链表中是否包含某个元素
     *
     * @return
     */
    public boolean containsElement(int value)
    {
        if (isEmpty())
        {
            throw new IllegalArgumentException("链表为空");
        }
        
        SingleNode curNode = head;
        
        if (curNode.val == value)
        {
            return true;
        }
        //从第二个元素起
        while (curNode.next != null)
        {
            curNode = curNode.next;
            if (curNode.val == value)
            {
                return true;
            }
        }
        return false;
    }
    
    
    public void printLinkedList()
    {
        if (isEmpty())
        {
            throw new IllegalArgumentException("链表为空");
        }
        SingleNode curNode = head;
        while (curNode != null)
        {
            System.out.println(curNode.val + " ");
            curNode = curNode.next;
        }
        
    }
    
    
    public static class SingleNode
    {
        public int val;
        public SingleNode next;
        
        public SingleNode(int val)
        {
            this.val = val;
            this.next = null;
        }
    }
}

