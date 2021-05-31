package DoExercise.HSP_ZCY.A011_BinarySortTree;

public class BinarySortTreeNode
{
    int value;
    BinarySortTreeNode left;
    BinarySortTreeNode right;
    
    public BinarySortTreeNode(int value)
    {
        this.value = value;
    }
    
    public BinarySortTreeNode search(int value)
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
    
    
    public BinarySortTreeNode searchParent(int value)
    {
        if ((this.left != null && this.left.value == value) ||
                (this.right != null && this.right.value == value))
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
    
    /**
     * 生成排序二叉树
     *
     * @param node
     */
    public void add(BinarySortTreeNode node)
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
    }
    
    
    public void infixOrder()
    {
        if (this.left != null)
        {
            this.left.infixOrder();
        }
        System.out.print(this.value+" ");
        if (this.right != null)
        {
            this.right.infixOrder();
        }
    }
}
