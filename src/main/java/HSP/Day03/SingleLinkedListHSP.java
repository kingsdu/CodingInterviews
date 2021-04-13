package HSP.Day03;

/**
 * 链表：单链表
 *
 * 实现基本操作：增删改查
 */
public class SingleLinkedListHSP
{
    public SingleNode head;
    public int size;
    
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
            addFirst(value);
            return;
        }
        SingleNode curNode = head;
        while (curNode.next != null)
        {
            curNode = curNode.next;
        }
        
        curNode.next = newNode;
        size++;
    }
    
    
    /**
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
     * 逆序新增链表
     */
    public void addNodeReverse(int value)
    {
        SingleNode newNode = new SingleNode(value);
        if (isEmpty())
        {
            addFirst(value);
        }
        
        newNode.next = head;
        head = newNode;
        size++;
    }
    
    /**
     * @param index
     */
    public void addNodeIndex(int value, int index)
    {
        if (index < 0)
        {
            throw new IllegalArgumentException("index is error");
        }
        
        if (index == 0)
        {
            addNode(value);
        }
        
        if (index > getSize())
        {
            addNode(value);
            return;
        }
        
        SingleNode curNode = this.head;
        //链表从1开始计数
        while ((index > 1) && (curNode.next.next != null))
        {
            index--;
            curNode = curNode.next;
        }
        SingleNode newNode = new SingleNode(value);
        newNode.next = curNode.next;
        curNode.next = newNode;
        this.size++;
    }
    
    
    /**
     * 返回链表的最后一个值
     *
     * @return
     */
    public int getLastNode()
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
        return curNode.val;
    }
    
    
    /**
     * 获取链表中指定位置的元素
     *
     * @param index
     * @return
     */
    public int getNodeIndex(int index)
    {
        if (index < 1)
        {
            throw new IllegalArgumentException("无效下标");
        }
        if (isEmpty())
        {
            throw new IllegalArgumentException("链表为空");
        }
        
        if(getSize() < index){
            return getLastNode();
        }
        
        SingleNode curNode = head;
        while ((index > 1) && (curNode.next != null))
        {
            curNode = curNode.next;
            index--;
        }
        return curNode.val;
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
     * 删除指定下标的链表的元素
     * <p>
     *
     *
     * @param index
     */
    public void removeNodeIndex(int index)
    {
        if (isEmpty())
        {
            throw new IllegalArgumentException("链表为空");
        }
        if (index < 1)
        {
            throw new IllegalArgumentException("无效下标");
        }
        //删除尾部元素
        if (index == getSize())
        {
            removeLastNode();
            return;
        }
        
        SingleNode curNode = head;
        index--;//保证curNode的前置位
        while ((index > 1) && (curNode.next.next != null))
        {
            index--;
            curNode = curNode.next;
        }
        curNode.next = curNode.next.next;
        size--;
    }
    
    
    /**
     * 删除链表中nodeElement元素
     *
     * @param nodeElement
     */
    public void removeNodeElement(int nodeElement)
    {
        if (isEmpty())
        {
            throw new IllegalArgumentException("链表为空");
        }
        
        SingleNode curNode = head;
        //第一个元素特殊处理
        if (curNode.val == nodeElement)
        {
            head = curNode.next;
            size--;
            return;
        }
        
        while (curNode.next != null)
        {
            if (curNode.next.val == nodeElement)
            {
                curNode.next = curNode.next.next;
                size--;
                return;//移除一个，去掉后移除所有
            } else
            {
                curNode = curNode.next;
            }
        }
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
        if (index < 1)
        {
            throw new IllegalArgumentException("无效下标");
        }
        
        if (getSize() < index)
        {
            editLastNode(nodeValue);
        }
        
        SingleNode curNode = head;
        while ((index > 1) && (curNode.next != null))
        {
            index--;
            curNode = curNode.next;
        }
        curNode.val = nodeValue;
    }
    
    
    /**
     * 编辑链表尾部的节点值
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
        
        if(curNode.val == value){
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
}

