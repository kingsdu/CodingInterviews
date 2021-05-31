package DoExercise.HSP_ZCY.A011_BinarySortTree;

public class BinarySortTree
{
    
    public static void main(String[] args)
    {
        int[] arr = {7, 3, 10, 12, 5, 1, 9};
        BinarySortTree binarySortTree = new BinarySortTree();
        for (int i = 0; i < arr.length; i++)
        {
            binarySortTree.add(new BinarySortTreeNode(arr[i]));
        }
        
        binarySortTree.infixOrder(); // 1, 3, 5, 7, 9, 10, 12
        binarySortTree.delNode(10);
        binarySortTree.delNode(5);
        
        System.out.println("root=" + binarySortTree.getRoot());
        
        System.out.println("删除结点后");
        binarySortTree.infixOrder();
    }
    
    private BinarySortTreeNode root;
    
    public BinarySortTreeNode getRoot()
    {
        return root;
    }
    
    /**
     * 查找结点
     *
     * @param value
     * @return
     */
    public BinarySortTreeNode search(int value)
    {
        if (root == null)
        {
            return null;
        } else
        {
            return root.search(value);
        }
    }
    
    
    /**
     *
     * 获取节点的父节点
     *
     * @param value
     * @return
     */
    public BinarySortTreeNode searchParent(int value)
    {
        if (root == null)
        {
            return null;
        } else
        {
            return root.searchParent(value);
        }
    }
    
    
    /**
     *
     * 返回的以node为根结点的二叉排序树的最小结点的值
     *
     * @param node
     * @return
     */
    public int delRightTreeMin(BinarySortTreeNode node)
    {
        BinarySortTreeNode target = node;
        while (target.left != null)
        {
            target = target.left;
        }
        delNode(target.value);
        return target.value;
    }
    
    
    /**
     * 删除结点
     *
     * 逻辑分析
     * 1、删除节点是叶子节点
     * 2、删除节点是非叶子节点
     *    1、该节点有左右子树
     *    2、该节点只有左子树
     *    3、该节点只有右子树
     *
     * @param value
     */
    public void delNode(int value)
    {
        if (root == null)
        {
            return;
        } else
        {
            if (root.left == null && root.right == null)
            {
                root = null;
                return;
            }
            
            BinarySortTreeNode targetNode = search(value);
            if (targetNode == null)
            {
                return;
            }
            
            BinarySortTreeNode parent = searchParent(value);
            if (targetNode.left == null && targetNode.right == null)
            {
                if (parent.left != null && parent.left.value == value)
                {
                    parent.left = null;
                } else if (parent.right != null && parent.right.value == value)
                {
                    parent.right = null;
                }
            } else if (targetNode.left != null && targetNode.right != null)//删除有两颗子树的节点，需要找到删除节点的替换节点
            {   //1、删除该节点右子树的最左子节点，但是返回该节点的值，然后将最左子节点的值覆盖该节点，完成对该节点的删除
                int minVal = delRightTreeMin(targetNode.right);
                targetNode.value = minVal;
            } else
            {
                if (targetNode.left != null)
                {
                    if (parent != null)
                    {   //判断删除节点是父节点的左子树还是右子树
                        if (parent.left.value == value)
                        {
                            parent.left = targetNode.left;
                        } else
                        {
                            parent.right = targetNode.left;
                        }
                    } else
                    {
                        root = targetNode.left;
                    }
                } else
                {
                    if (parent != null)
                    {
                        if (parent.left.value == value)
                        {
                            parent.left = targetNode.right;
                        } else
                        {
                            parent.right = targetNode.right;
                        }
                    } else
                    {
                        root = targetNode.right;
                    }
                }
            }
        }
    }
    
    /**
     * 添加结点
     *
     * @param node
     */
    public void add(BinarySortTreeNode node)
    {
        if (root == null)
        {
            root = node;
        } else
        {
            root.add(node);
        }
    }
    
    //中序遍历
    public void infixOrder()
    {
        if (root != null)
        {
            root.infixOrder();
        } else
        {
            System.out.println("二叉排序树为空，不能遍历");
        }
    }
}
