package HSP.Day03;

/**
 * 链表结构
 * <p>
 * 代码体验：
 * 1、单向链表获取数据较慢，需要逐个链表的遍历比对
 * 2、单向链表插入、删除数据较快，直接找到位置，修改链表的位置即可。
 * 3、单向链表操作的一些技巧
 * （1）插入时最好定位到链表插入位置的前一个节点:插入节点.next = 前一个节点.next ; 前一个节点.next = 插入节点 ;(注意先后顺序)
 */
public class LinkedListHSP
{
    public NodeHSP head;
    public int size;
    
    public LinkedListHSP()
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
        NodeHSP newNode = new NodeHSP(value);
        
        if (isEmpty())
        {
            addFirst(value);
            return;
        }
        NodeHSP curNode = head;
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
        
        head = new NodeHSP(value);
        size++;
    }
    
    
    /**
     * 逆序新增链表
     */
    public void addNodeReverse(int value)
    {
        NodeHSP newNode = new NodeHSP(value);
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
        
        NodeHSP curNode = this.head;
        //链表从1开始计数
        while ((index > 1) && (curNode.next.next != null))
        {
            index--;
            curNode = curNode.next;
        }
        NodeHSP newNode = new NodeHSP(value);
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
        NodeHSP curNode = head;
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
        
        NodeHSP curNode = head;
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
        
        NodeHSP curNode = head;
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
        
        NodeHSP curNode = head;
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
        
        NodeHSP curNode = head;
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
        
        NodeHSP curNode = head;
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
        
        NodeHSP curNode = this.head;
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
        
        NodeHSP curNode = head;
        
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
        NodeHSP curNode = head;
        while (curNode != null)
        {
            System.out.println(curNode.val + " ");
            curNode = curNode.next;
        }
        
    }
}

