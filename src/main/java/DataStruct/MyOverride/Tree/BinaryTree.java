package DataStruct.MyOverride.Tree;

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
     * 生成一个二叉树，从上向下顺序
     * 0
     * 1   2
     * 3  4  5  6
     *
     * @return
     */
    public TreeNode[] CreateBinaryTree(int size)
    {
        TreeNode[] root = new TreeNode[size];
        for (int i = 0; i < size; i++)
        {
            root[i] = new TreeNode(i);
        }
        
        for (int i = 0; i < size; i++)
        {
            if (i * 2 + 1 < size)
            {
                root[i].left = root[i * 2 + 1];
            }
            
            if (i * 2 + 2 < size)
            {
                root[i].right = root[i * 2 + 2];
            }
        }
        return root;
    }
    
    
    /**
     * 根据目标数组中的数字，生成对应的二叉树
     * <p>
     * 012null3null567
     * <p>
     * 0
     * 1  2
     * n 3 n 5
     * 6 7
     *
     * @param array
     * @return
     */
    public TreeNode[] CreateBinaryTree(Integer[] array)
    {
        int size = array.length;
        TreeNode[] root = new TreeNode[size];
        for (int i = 0; i < array.length; i++)
        {
            if (array[i] == null)
            {
                root[i] = null;
            } else
            {
                root[i] = new TreeNode(array[i]);
            }
        }
        Queue<TreeNode> queue = new LinkedList<>();
        if (root.length == 0)
        {
            return null;
        }
        queue.add(root[0]);
        int i = 1;
        while (i < size || !queue.isEmpty())
        {
            TreeNode curNode = queue.poll();
            //判断当前节点为空则继续出栈
            while (curNode == null)
            {
                curNode = queue.poll();
                if (queue.isEmpty() && curNode == null)//最后一个元素出栈，栈是空，但是还有元素
                {
                    return root;
                }
            }
            
            if (i < size)
            {
                curNode.left = array[i] == null ? null : root[i];
                queue.offer(curNode.left);
                i++;
            }
            
            if (i < size)
            {
                curNode.right = array[i] == null ? null : root[i];
                queue.offer(curNode.right);
                i++;
            }
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
    public void preOrderTreeRec(TreeNode root)
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
    public void inOrderTreeRec(TreeNode root)
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
    public void postOrderTreeRec(TreeNode root)
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
    public List<Integer> preOrderTreeNonRec(TreeNode root)
    {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack();
        
        while (!stack.isEmpty() || root != null)
        {
            while (root != null)
            {
                //直接处理根节点，在遍历子树之前处理
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
    public List<Integer> inOrderTreeNonRec(TreeNode root)
    {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack();
        
        while (!stack.isEmpty() || root != null)
        {
            if (root != null)
            {
                stack.push(root);
                root = root.left;
            } else
            {
                //移动到左节点后在处理
                TreeNode tempNode = stack.pop();
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
    public LinkedList<Integer> postOrderTreeNonRec(TreeNode root)
    {
        LinkedList<Integer> linkedList = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        
        while (!stack.isEmpty())
        {
            TreeNode tempNode = stack.pop();
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
    public LinkedList<Integer> levelOrderTree(TreeNode root)
    {
        if (root == null) return null;
        LinkedList<Integer> linkedList = new LinkedList<>();
        ConcurrentLinkedQueue<TreeNode> queue = new ConcurrentLinkedQueue();
        queue.add(root);
        
        while (!queue.isEmpty())
        {
            TreeNode tempNode = queue.poll();
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
     * list！=null         首先判断是否有商店
     * ！list.isEmpty()     没有判断商店是否存在，而是判断商店是否有东西
     *
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
     * list！=null         首先判断是否有商店
     * ！list.isEmpty()     没有判断商店是否存在，而是判断商店是否有东西
     *
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
     * <p>
     * tempNode = queue.poll();  等于将 tempNode指向了root，并不是复制，是两个变量指向同一个地址，
     * 当tempNode改变的时候root也相应改变
     *
     * @param root
     * @param newNode
     */
    public TreeNode addTreeNode(TreeNode root, TreeNode newNode)
    {
        ConcurrentLinkedQueue<TreeNode> queue = new ConcurrentLinkedQueue();
        queue.add(root);
        TreeNode tempNode = null;
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
     * 删除整棵树，因为需要先删除子节点，再删除根节点
     * 所以可以采用后续遍历，左右根。
     * <p>
     * 该方法暂时不知道如何返回删除后的树
     * 因为返回的一定是空
     * 方法的意义就是了解后序遍历的用法
     *
     * @param root
     */
    public void deleteTree(TreeNode root)
    {
        if (root == null)
        {
            return;
        }
        deleteTree(root.left);
        deleteTree(root.right);
        root = null;
    }
    
    
    /**
     * 删除树节点
     * 思路：
     * (1) 删除节点没有子节点时
     * (2) 删除节点有一个子节点时
     * (3) 删除节点有左右子节点时
     */
    public TreeNode deleteTreeNode(TreeNode root, TreeNode delNode)
    {
        if (root == null) return null;
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode tempNode = null, childLeft = null, childRight = null, deepestNode;
        boolean left = false, right = false;
        queue.offer(root);
        
        while (!queue.isEmpty())
        {
            tempNode = queue.poll();
            
            if (tempNode.left != null)
            {
                //找到删除的节点
                if (tempNode.left.val == delNode.val)
                {
                    //判断被删除节点的左子节点和右子节点是否为null
                    if (tempNode.left.left != null)
                    {
                        childLeft = tempNode.left.left;
                        left = true;
                    }
                    if (tempNode.left.right != null)
                    {
                        childRight = tempNode.left.right;
                        right = true;
                    }
                    //被删除节点存在子节点
                    if (left || right)
                    {
                        deepestNode = getDeepestTreeNode(root);
                        if (left && right)
                        {
                            tempNode.left = deepestNode;
                            deepestNode.left = childLeft;
                            deepestNode.right = childRight;
                        } else if (left)
                        {
                            tempNode.left = deepestNode;
                            deepestNode.left = childLeft;
                        } else if (right)
                        {
                            tempNode.left = deepestNode;
                            deepestNode.right = childRight;
                        }
                    } else
                    {
                        tempNode = null;
                    }
                    return tempNode;
                } else
                {
                    queue.add(tempNode.left);
                }
            }
            if (tempNode.right != null)
            {
                //找到删除的节点
                if (tempNode.right.val == delNode.val)
                {
                    //判断被删除节点的左子节点和右子节点是否为null
                    if (tempNode.right.left != null)
                    {
                        childLeft = tempNode.right.left;
                        left = true;
                    }
                    if (tempNode.right.right != null)
                    {
                        childRight = tempNode.right.right;
                        right = true;
                    }
                    //被删除节点存在子节点
                    if (left || right)
                    {
                        deepestNode = getDeepestTreeNode(root);
                        if (left && right)
                        {
                            tempNode.right = deepestNode;
                            deepestNode.left = childLeft;
                            deepestNode.right = childRight;
                        } else if (left)
                        {
                            tempNode.right = deepestNode;
                            deepestNode.left = childLeft;
                        } else if (right)
                        {
                            tempNode.right = deepestNode;
                            deepestNode.right = childRight;
                        }
                    } else
                    {
                        tempNode = null;
                    }
                    return tempNode;
                } else
                {
                    queue.add(tempNode.right);
                }
            }
        }
        return tempNode;
    }
    
    
    /**
     * 求二叉树的高度
     * <p>
     * 递归法求高度，左右两侧分开递归，递归至最下层节点，在逐层合并。
     */
    public int HighOfTree(TreeNode root)
    {
        int leftHeight, rightHeight;
        if (root == null)
        {
            return 0;
        } else
        {
            leftHeight = HighOfTree(root.left);
            rightHeight = HighOfTree(root.right);
            
            if (leftHeight > rightHeight)
            {
                return leftHeight + 1;
            } else
            {
                return rightHeight + 1;
            }
        }
    }
    
    
    /**
     * 获取二叉树最深的节点
     * <p>
     * 层序遍历，获取最后一个节点，
     * 获取后需要将最后一个节点和之前节点的联系切断（重点）
     *
     *
     * @return
     */
    public TreeNode getDeepestTreeNode(TreeNode root)
    {
        if (root == null) return null;
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode tempNode = null, preLeft = null, preRight = null;
        queue.offer(root);
        
        while (!queue.isEmpty())
        {
            tempNode = queue.poll();
            
            if (tempNode.left != null)
            {
                preLeft = tempNode;
                queue.add(tempNode.left);
            } else
            {
                if(!queue.isEmpty()){
                    preLeft = null;
                }
            }
            
            if (tempNode.right != null)
            {
                preRight = tempNode;
                queue.add(tempNode.right);
            } else
            {
                if(!queue.isEmpty()){
                    preRight = null;
                }
            }
        }
        
        //切断最深节点和其上级节点之间的联系
        if (preLeft != null)
        {//Tree引用的逻辑是怎样的？为什么改变任意一个赋值变量的值最后都会改变root的值？
            preLeft.left = null;
        } else if (preRight != null)
        {
            preLeft.right = null;
        }else if(preLeft != null && preRight!=null){
            preLeft.right = null;
        }
        
        return tempNode;
    }
    
    
}
