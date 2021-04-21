package Jianzhi_Offer;


import java.util.HashMap;
import java.util.Map;

/**
 * 输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，另一个特殊指针random指向一个随机节点），
 * 请对此链表进行深拷贝，并返回拷贝后的头结点。（注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）
 */
public class Offer025_CopyRandomList
{
    
    
    public static void main(String[] args)
    {
        RandomListNode root1 = new RandomListNode(7);
        RandomListNode root2 = new RandomListNode(13);
        RandomListNode root3 = new RandomListNode(11);
        RandomListNode root4 = new RandomListNode(10);
        RandomListNode root5 = new RandomListNode(1);
        RandomListNode root6 = null;
        
        root1.next = root2;
        root1.random = root6;
        root2.next = root3;
        root2.random = root1;
        root3.next = root4;
        root3.random = root5;
        root4.next = root5;
        root4.random = root3;
        root5.next = root6;
        root5.random = root1;
        
        Offer025_CopyRandomList oc = new Offer025_CopyRandomList();
        oc.Clone_3(root1);
    }
    
    
    /**
     * 不太理解什么是深复制
     * <p>
     * 看了大神的解析后：原节点不能动，将原节点复制到新节点中
     *
     * @param pHead
     * @return
     */
    public RandomListNode Clone_1(RandomListNode pHead)
    {
        RandomListNode newNode = null;
        if (pHead == null)
        {
            return null;
        }
        
        while (pHead != null)
        {
            newNode = pHead;
            pHead = pHead.next;
            newNode = newNode.next;
        }
        return newNode;
    }
    
    
    /**
     * 大神方法1：通过哈希表映射关系，通过某个键对应到某个值
     *
     * @param pHead
     * @return
     */
    public RandomListNode Clone_2(RandomListNode pHead)
    {
        if (pHead == null) return null;
        RandomListNode curNode = pHead;
        Map<RandomListNode, RandomListNode> map = new HashMap<>();
        
        while (curNode != null)
        {
            map.put(curNode, new RandomListNode(curNode.label));
            curNode = curNode.next;
        }
        
        curNode = pHead;
        /**
         *
         * map.get(curNode)得到的是当前节点的值，但是节点的next 和 random都是null
         * map.get(curNode.next)也能得到当前节点的值，但是点的next 和 random也都是null
         * 通过
         *             map.get(curNode).next = map.get(curNode.next);
         *             map.get(curNode).random = map.get(curNode.random);
         * 实现节点正确的连接
         */
        while (curNode != null)
        {
            map.get(curNode).next = map.get(curNode.next);
            map.get(curNode).random = map.get(curNode.random);
            curNode = curNode.next;
        }
        return map.get(pHead);
    }
    
    
    /**
     *
     * 拼接 + 拆分
     * 1、复制各节点，构建拼接链表:
     * 2、构建新链表各节点的 next 和 random 指向：
     * 3、拆分原 / 新链表
     *
     * @param pHead
     * @return
     */
    public RandomListNode Clone_3(RandomListNode pHead){
        if(pHead == null){
            return null;
        }
        RandomListNode curNode = pHead;
        //1. 复制各节点，并构建拼接链表：将当前节点复制一份，到后面
        while (curNode!=null){
            RandomListNode tmp = new RandomListNode(curNode.label);
            tmp.next = curNode.next;
            curNode.next = tmp;
            curNode = tmp.next;
        }
        curNode = pHead;
        //2. 构建各新节点的 random 指向：因为存在2个节点，所以赋值的 和 被赋值的都要向后一个
        while (curNode != null){
            if(curNode.random != null){
                curNode.next.random = curNode.random.next;
            }
            curNode = curNode.next.next;
        }
        
        curNode = pHead.next;
        RandomListNode pre = pHead,res = pHead.next;
        //3. 拆分两链表
        while (pre.next!=null){
            pre.next = pre.next.next;
            curNode.next = curNode.next.next;
            pre = pre.next;
            curNode = curNode.next;
        }
        return res;
    }
    
    
    public static class RandomListNode
    {
        public int label;
        RandomListNode next = null;
        RandomListNode random = null;
        
        RandomListNode(int label)
        {
            this.label = label;
        }
    }
}
