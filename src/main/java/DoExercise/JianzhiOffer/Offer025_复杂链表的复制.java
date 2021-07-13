package DoExercise.JianzhiOffer;


import java.util.HashMap;
import java.util.Map;

/**
 * 输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，另一个特殊指针random指向一个随机节点），
 * 请对此链表进行深拷贝，并返回拷贝后的头结点。（注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）
 * <p>
 * 经典
 * <p>
 * 克隆节点就是用新的节点地址 存储 旧的节点地址
 * 考点：
 * 1、拆分链表
 * 2、Hash表的应用
 *
 * https://leetcode-cn.com/problems/fu-za-lian-biao-de-fu-zhi-lcof/
 *
 */
public class Offer025_复杂链表的复制
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
        
        RandomListNode printNode = root1;
        while (printNode != null)
        {
            System.out.print(printNode.label + " ");
            printNode = printNode.next;
        }
        System.out.println();
        System.out.print("-----------复制后-----------------");
        System.out.println();
        
        RandomListNode randomListNode = Clone_3(root1);
        while (randomListNode != null)
        {
            System.out.print(randomListNode.label + " ");
            randomListNode = randomListNode.next;
        }
    }
    
    /**
     * 大神方法1：通过哈希表映射关系，通过某个键对应到某个值
     *
     * @param pHead
     * @return
     */
    public static RandomListNode Clone_2(RandomListNode pHead)
    {
        if (pHead == null) return null;
        RandomListNode curNode = pHead;//保持head的头部
        Map<RandomListNode, RandomListNode> map = new HashMap<>();
        //1 复制节点
        while (curNode != null)
        {
            map.put(curNode, new RandomListNode(curNode.label));
            curNode = curNode.next;
        }
        
        curNode = pHead;
        //2 建立节点间联系
        while (curNode != null)
        {
            map.get(curNode).next = map.get(curNode.next);
            map.get(curNode).random = map.get(curNode.random);
            curNode = curNode.next;
        }
        return map.get(pHead);
    }
    
    
    /**
     * 拼接 + 拆分
     * 1、复制各节点，构建拼接链表:
     * 2、构建新链表各节点的 next 和 random 指向：
     * 3、拆分原 / 新链表
     *
     * @param pHead
     * @return
     */
    public static RandomListNode Clone_3(RandomListNode pHead)
    {
        if (pHead == null)
        {
            return null;
        }
        RandomListNode curNode = pHead;
        //1. 复制各节点，并构建拼接链表（next是稳定的指向，可以这样做）：将当前节点复制一份，到后面
        while (curNode != null)
        {
            RandomListNode tmp = new RandomListNode(curNode.label);
            tmp.next = curNode.next;
            curNode.next = tmp;
            curNode = tmp.next;
        }
        curNode = pHead;
        //2. 构建各新节点的 random 指向（random是随机的，所以需要在处理一遍）：因为存在2个节点，所以赋值的 和 被赋值的都要向后一个
        while (curNode != null)
        {
            if (curNode.random != null)
            {
                curNode.next.random = curNode.random.next;
            }
            curNode = curNode.next.next;
        }
        
        curNode = pHead.next;
        RandomListNode old = pHead, copy = pHead.next;//res指向复制出的节点的头
        //3. 拆分两链表
        while (old.next.next != null)
        {
            old.next = old.next.next;
            copy.next = copy.next.next;
            old = old.next;
            copy = copy.next;
        }
        return curNode;
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
