package DataStruct.Tree;

import java.util.*;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * 二叉树的操作
 * <p>
 * 1、遍历
 * 2、增删改查
 */
public class BinaryTree
{
    
    List<Integer> resultList = new ArrayList<>();
    
    public List<Integer> getResultList()
    {
        return resultList;
    }
    
    public void setResultList(List<Integer> resultList)
    {
        this.resultList = resultList;
    }
    
    /**
     * 随机生成一个二叉树
     *
     * @return
     */
    public BinaryTreeNode[] getBinaryNode(int size)
    {
        BinaryTreeNode[] root = new BinaryTreeNode[size];
        for (int i = 1; i < size; i++)
        {
            root[i] = new BinaryTreeNode(i);
        }
        
        for (int i = 1; i < size / 2; i++)
        {
            root[i].left = root[i * 2];
            root[i].right = root[i * 2 + 1];
        }
        return root;
    }
    
    
    /**
     *  * 前序：0137849256：左右根
     *  * 中序：7381904526：左根右
     *  * 后序：7839415620：左右根
     */
    
    /**
     * 遍历方式实现前序遍历
     *
     * @param root
     * @return
     */
    public void preOrderTreeRec(BinaryTreeNode root)
    {
        if (root != null)
        {
            resultList.add(root.val);
            preOrderTreeRec(root.left);
            preOrderTreeRec(root.right);
        }
    }
    
    
    /**
     * @param root
     */
    public void inOrderTreeRec(BinaryTreeNode root)
    {
        if (root != null)
        {
            inOrderTreeRec(root.left);
            resultList.add(root.val);
            inOrderTreeRec(root.right);
        }
    }
    
    /**
     * @param root
     */
    public void postOrderTreeRec(BinaryTreeNode root)
    {
        if (root != null)
        {
            postOrderTreeRec(root.left);
            postOrderTreeRec(root.right);
            resultList.add(root.val);
        }
    }
    
    
    /**
     * 非递归方式实现二叉树前序遍历
     *
     * @param root
     * @return
     */
    public List<Integer> preOrderTreeNonRec(BinaryTreeNode root)
    {
        List<Integer> list = new ArrayList<>();
        Stack<BinaryTreeNode> stack = new Stack();
        
        while (!stack.isEmpty() || root != null)
        {
            while (root != null)
            {
                list.add(root.val);
                stack.push(root);
                root = root.left;
            }
            root = stack.pop().right;
        }
        return list;
    }
    
    
    /**
     * 非递归方式实现二叉树中序遍历
     *
     * @param root
     * @return
     */
    public List<Integer> inOrderTreeNonRec(BinaryTreeNode root)
    {
        List<Integer> list = new ArrayList<>();
        Stack<BinaryTreeNode> stack = new Stack();
        
        while (!stack.isEmpty() || root != null)
        {
            if (root != null)
            {
                stack.push(root);
                root = root.left;
            } else
            {
                BinaryTreeNode tempNode = stack.pop();
                list.add(tempNode.val);
                root = tempNode.right;
            }
        }
        return list;
    }
    
    /**
     * 非递归方式实现二叉树后序遍历
     * <p>
     * 反向顺序实现：左右根 ——> 根右左
     *
     * @param root
     * @return
     */
    public LinkedList<Integer> postOrderTreeNonRec(BinaryTreeNode root)
    {
        LinkedList<Integer> linkedList = new LinkedList<>();
        Stack<BinaryTreeNode> stack = new Stack<>();
        stack.push(root);
        
        while (!stack.isEmpty())
        {
            BinaryTreeNode tempNode = stack.pop();
            linkedList.addFirst(tempNode.val);
            
            if (tempNode.left != null)
            {
                stack.push(tempNode.left);
            }
            if (tempNode.right != null)
            {
                stack.push(tempNode.right);
            }
        }
        return linkedList;
    }
    
    
    /**
     * 层序遍历：逐层遍历
     *
     * @param root
     * @return
     */
    public LinkedList<Integer> levelOrderTree(BinaryTreeNode root)
    {
        if(root == null) return null;
        LinkedList<Integer> linkedList = new LinkedList<>();
        ConcurrentLinkedQueue<BinaryTreeNode> queue = new ConcurrentLinkedQueue();
        queue.add(root);
        
        while (!queue.isEmpty())
        {
            BinaryTreeNode tempNode = queue.poll();
            linkedList.add(tempNode.val);
            
            if (tempNode.left != null)
            {
                queue.add(tempNode.left);
            }
            if (tempNode.right != null)
            {
                queue.add(tempNode.right);
            }
            
        }
        return linkedList;
    }
    
    /**
     *  list！=null         首先判断是否有商店
     * ！list.isEmpty()     没有判断商店是否存在，而是判断商店是否有东西
     * @param arrayList
     */
    public void printResList(List<Integer> arrayList)
    {
        if (arrayList == null || arrayList.isEmpty()) return;
        for (int num :
                arrayList)
        {
            System.out.print(num + " ");
        }
    }
    
    /**
     *  list！=null         首先判断是否有商店
     * ！list.isEmpty()     没有判断商店是否存在，而是判断商店是否有东西
     * @param linkList
     */
    public void printResList(LinkedList<Integer> linkList)
    {
        if (linkList == null || linkList.isEmpty()) return;
        
        for (int num :
                linkList)
        {
            System.out.print(num + " ");
        }
    }
    
    
    
    /**
     *
     * 增删改查
     *
     *
     */
    
    
    /**
     * 顺序增加一个节点至二叉树尾部
     *
     * tempNode = queue.poll();  等于将 tempNode指向了root，并不是复制，是两个变量指向同一个地址，
     * 当tempNode改变的时候root也相应改变
     *
     * @param root
     * @param newNode
     */
    public BinaryTreeNode addTreeNode(BinaryTreeNode root,BinaryTreeNode newNode)
    {
        ConcurrentLinkedQueue<BinaryTreeNode> queue = new ConcurrentLinkedQueue();
        queue.add(root);
        BinaryTreeNode tempNode = null;
        while (!queue.isEmpty())
        {
            tempNode = queue.poll();
            if (tempNode.left != null)
            {
                queue.add(tempNode.left);
            } else
            {
                tempNode.left = newNode;
                return root;
            }
            
            if (tempNode.right != null)
            {
                queue.add(tempNode.right);
            } else
            {
                tempNode.right = newNode;
                return root;
            }
        }
        return root == null ? newNode : root;
    }
    
    
    /**
     *
     * 删除整棵树，因为需要先删除子节点，再删除根节点
     * 所以可以采用后续遍历，左右根。
     *
     * 该方法暂时不知道如何返回删除后的树
     * 因为返回的一定是空
     * 方法的意义就是了解后序遍历的用法
     *
     *
     * @param root
     */
    public void deleteTree(BinaryTreeNode root){
        if(root == null){
            return;
        }
        deleteTree(root.left);
        deleteTree(root.right);
        root = null;
    }
    
    
    /**
     *
     * 删除树节点
     * 思路：
     * (1) 删除节点没有子节点时
     * (2) 删除节点有一个子节点时
     * (3) 删除节点有左右子节点时
     */
    public void deleteTreeNode(BinaryTreeNode delNode){
    
    }
    
}
