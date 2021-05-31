package DoExercise.HSP_ZCY.A012_AVLTree;


/**
 *
 * AVL树节点
 *
 */
public class AVLBinTreeNode
{
    int value;
    AVLBinTreeNode left;
    AVLBinTreeNode right;
    
    public AVLBinTreeNode(int value)
    {
        this.value = value;
    }
    
    public int leftHeight()
    {
        if (left == null)
        {
            return 0;
        }
        return left.height();
    }
    
    public int rightHeight()
    {
        if (right == null)
        {
            return 0;
        }
        return right.height();
    }
    
    /**
     *
     * 遍历求树的高度
     *
     * @return
     */
    public int height()
    {
        return Math.max(left == null ? 0 : left.height(), right == null ? 0 : right.height()) + 1;
    }
    
    private void leftRotate()
    {
        AVLBinTreeNode newNode = new AVLBinTreeNode(value);
        newNode.left = left;
        newNode.right = right.left;
        value = right.value;
        right = right.right;
        left = newNode;
    }
    
    private void rightRotate()
    {
        AVLBinTreeNode newNode = new AVLBinTreeNode(value);
        newNode.right = right;
        newNode.left = left.right;
        value = left.value;
        left = left.left;
        right = newNode;
    }
    
    
    public AVLBinTreeNode search(int value)
    {
        if (value == this.value)
        {
            return this;
        } else if (value < this.value)
        {
            if (this.left == null)
            {
                return null;
            }
            return this.left.search(value);
        } else
        {
            if (this.right == null)
            {
                return null;
            }
            return this.right.search(value);
        }
    }
    
    
    public AVLBinTreeNode searchParent(int value)
    {
        if ((this.left != null && this.left.value == value) || (this.right != null && this.right.value == value))
        {
            return this;
        } else
        {
            if (value < this.value && this.left != null)
            {
                return this.left.searchParent(value);
            } else if (value >= this.value && this.right != null)
            {
                return this.right.searchParent(value);
            } else
            {
                return null;
            }
        }
    }
    
    public void add(AVLBinTreeNode node)
    {
        if (node == null)
        {
            return;
        }
        
        if (node.value < this.value)
        {
            if (this.left == null)
            {
                this.left = node;
            } else
            {
                this.left.add(node);
            }
        } else
        {
            if (this.right == null)
            {
                this.right = node;
            } else
            {
                this.right.add(node);
            }
        }
        
        //确定是左旋还是右旋
        if (rightHeight() - leftHeight() > 1)
        {   //如果它的右子树的左子树的高度大于它的右子树的右子树的高度
            if (right != null && right.leftHeight() > right.rightHeight())
            {
                right.rightRotate();//先对右子结点进行右旋转
            }
            leftRotate();//在对当前结点进行左旋转
            return;
        }
        
        if (leftHeight() - rightHeight() > 1)
        {
            if (left != null && left.rightHeight() > left.leftHeight())
            {
                left.leftRotate();
            }
            rightRotate();
        }
    }
    
    public void infixOrder()
    {
        if (this.left != null)
        {
            this.left.infixOrder();
        }
        System.out.println(this);
        if (this.right != null)
        {
            this.right.infixOrder();
        }
    }
    
}
