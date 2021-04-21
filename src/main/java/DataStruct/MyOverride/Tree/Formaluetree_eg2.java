package DataStruct.MyOverride.Tree;


/**
 * 算术表达式使用递归算法生成二叉树
 * 按照算式的运算顺序，生成对应的二叉树
 * 思路：
 * 1、从左到右，依次遍历算式，找到除括号外的最右侧的符号（有加减，则加减，否则乘除）
 * 2、以找到的最右侧的符号为根节点，算式的左侧为该根节点的左子树，右侧为根节点的右子树
 * 3、递归遍历，直到字符串长度为1，则表示已经到根节点了。
 */
public class Formaluetree_eg2
{
    
    /**
     *
     */
    public FormNode CreateExpressByTree(String nodeStr, int start, int end)
    {
        if (end - start == 1)
        {
            FormNode root = new FormNode(Character.toString(nodeStr.charAt(start)));
            root.setLeft(null);
            root.setRight(null);
            return root;
        }
        
        int expressIndexF = 0, expressIndexS = 0, blackFlag = 0, boostIndex = 0;
        
        for (int i = start; i < end; i++)
        {
            if (nodeStr.charAt(i) == '(')
            {
                blackFlag++;
            } else if (nodeStr.charAt(i) == ')')
            {
                blackFlag--;
            }
            
            if (blackFlag == 0)
            {
                if (nodeStr.charAt(i) == '+' || nodeStr.charAt(i) == '-')
                {
                    expressIndexF = i;
                } else if (nodeStr.charAt(i) == '*' || nodeStr.charAt(i) == '/')
                {
                    expressIndexS = i;
                }
            }
        }
        //去除外层的括号
        if ((expressIndexF == 0) && (expressIndexS == 0))
        {
            FormNode root = CreateExpressByTree(nodeStr, start + 1, end - 1);
            return root;
        } else
        {
            if (expressIndexF > 0) boostIndex = expressIndexF;
            else if (expressIndexS > 0) boostIndex = expressIndexS;
            
            FormNode root = new FormNode(String.valueOf(nodeStr.charAt(boostIndex)));
            root.setLeft(CreateExpressByTree(nodeStr, start, boostIndex));
            root.setRight(CreateExpressByTree(nodeStr, boostIndex + 1, end));
            return root;
        }
    }
    
    
    /**
     *
     * 中序遍历输出结果
     *
     */
    public void InOrder(FormNode formNode){
        if(formNode == null){
            return;
        }
        InOrder(formNode.getLeft());
        System.out.println(formNode.getData());
        InOrder(formNode.getRight());
    }
    
    public static void main(String[] args)
    {
        String str = "4+(2*3+1)/2-5";
        Formaluetree_eg2 f2 = new Formaluetree_eg2();
        FormNode formNode = f2.CreateExpressByTree(str, 0, str.length());
        f2.InOrder(formNode);
    }
}
