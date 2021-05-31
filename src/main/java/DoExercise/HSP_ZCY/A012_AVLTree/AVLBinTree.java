package DoExercise.HSP_ZCY.A012_AVLTree;

public class AVLBinTree
{
    public static void main(String[] args)
    {
        int[] arr = {10, 11, 7, 6, 8, 9};
        AVLBinTree avlTree = new AVLBinTree();
        for (int i = 0; i < arr.length; i++)
        {
            avlTree.add(new AVLBinTreeNode(arr[i]));
        }
        
        avlTree.infixOrder();
        
        System.out.println("树的高度=" + avlTree.getRoot().height()); //3
        System.out.println("树的左子树高度=" + avlTree.getRoot().leftHeight()); // 2
        System.out.println("树的右子树高度=" + avlTree.getRoot().rightHeight()); // 2
        System.out.println("当前的根结点=" + avlTree.getRoot());//8
    }
    
    
    private AVLBinTreeNode root;
    
    public AVLBinTreeNode getRoot()
    {
        return root;
    }
    
    public AVLBinTreeNode search(int value)
    {
        if (root == null)
        {
            return null;
        } else
        {
            return root.search(value);
        }
    }
    
    public AVLBinTreeNode searchParent(int value)
    {
        if (root == null)
        {
            return null;
        } else
        {
            return root.searchParent(value);
        }
    }
    
    public int delRightTreeMin(AVLBinTreeNode node)
    {
        AVLBinTreeNode target = node;
        while (target.left != null)
        {
            target = target.left;
        }
        delNode(target.value);
        return target.value;
    }
    
    public void delNode(int value)
    {
        if (root == null)
        {
            return;
        } else
        {
            AVLBinTreeNode targetNode = search(value);
            if (targetNode == null)
            {
                return;
            }
            if (root.left == null && root.right == null)
            {
                root = null;
                return;
            }
            
            AVLBinTreeNode parent = searchParent(value);
            if (targetNode.left == null && targetNode.right == null)
            {
                if (parent.left != null && parent.left.value == value)
                {
                    parent.left = null;
                } else if (parent.right != null && parent.right.value == value)
                {
                    parent.right = null;
                }
            } else if (targetNode.left != null && targetNode.right != null)
            {
                int minVal = delRightTreeMin(targetNode.right);
                targetNode.value = minVal;
                
            } else
            {
                if (targetNode.left != null)
                {
                    if (parent != null)
                    {
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
    
    public void add(AVLBinTreeNode node)
    {
        if (root == null)
        {
            root = node;
        } else
        {
            root.add(node);
        }
    }
    
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
