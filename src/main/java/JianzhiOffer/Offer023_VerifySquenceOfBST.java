package JianzhiOffer;


import java.util.Stack;

/**
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。如果是则返回true,否则返回false。
 * 假设输入的数组的任意两个数字都互不相同。（ps：我们约定空树不是二叉搜素树）
 * <p>
 * <p>
 * 输入: [1,6,3,2,5]
 * 输出: false
 * <p>
 * 输入: [1,3,2,6,5]
 * 输出: true
 * <p>
 * 思路：
 * 我的问题：1、没理解二叉搜索树 和 后序遍历之间的关系
 * <p>
 * 后序遍历：左右根
 * 二叉搜索树：左子树中所有节点的值 < 根节点的值；右子树中所有节点的值 > 根节点的值；其左、右子树也分别为二叉搜索树。
 * <p>
 * 方法1可以用递归来做
 * 方法2可以用辅助栈来做
 */
public class Offer023_VerifySquenceOfBST
{
    
    public static void main(String[] args)
    {
//        int[] sequence = {1, 3, 2, 7, 9, 10, 5};
        int[] sequence = {1, 5, 3, 9, 10, 12, 7};
        Offer023_VerifySquenceOfBST ve = new Offer023_VerifySquenceOfBST();
        boolean b = ve.VerifySquenceOfBST_02(sequence);
    
        System.out.println(b ? "true" : "false");
    }
    
    public boolean VerifySquenceOfBST_01(int[] sequence)
    {
        if (sequence.length == 0)
        {
            return false;
        }
        return recur(sequence, 0, sequence.length - 1);
    }
    
    /**
     * 根据这个性质，方法1可以用递归来做
     * 1、先找到大于根节点的节点（该节点要离根节点最近），以该节点为根节点的右子树的最大节点。
     * 2、从左向右，节点与根节点比较，如果小于根节点，就一直向右移动，确定左子树节点的范围。同时也确定了右子树节点的范围。循环迭代。
     * 3、当只剩下一个节点时，返回递归
     *
     * @param sequence
     * @param left
     * @param right
     * @return
     */
    private boolean recur(int[] sequence, int left, int right)
    {
        if (left >= right)
        {
            return true;
        }
        
        int indexLeft = left;
        //从最左的节点 和 根节点比较
        while (sequence[indexLeft] < sequence[right])
        {
            indexLeft++;
        }
        int indexRight = indexLeft;
        while (sequence[indexRight] > sequence[right])
        {
            indexRight++;
        }
        //indexRight == right保证了左节点都小于根节点，右节点都大于根节点
        return indexRight == right && recur(sequence, left, indexLeft - 1) && recur(sequence, indexLeft, right - 1);
    }
    
    
    /**
     * 性质
     * 1、当ri < ri+1 时，ri一定是ri+1的右子节点。
     * 2、当ri > ri+1 时,ri一定是某节点root的左子节点，且root为ri+1、ri+2、ri+3中大于且距ri最近的节点。
     *
     * 故
     * 思路：
     * 1、借助一个单调栈 stackstack 存储值递增的节点；
     * 2、每当遇到值递减的节点，则通过出栈来更新节点的父节点
     * 3、每轮判断i和root之间的关系：（1）i>root 不符合搜索二叉树规则，跳出；（2）i<root，继续遍历
     *
     *
     * @param sequence
     * @return
     */
    public boolean VerifySquenceOfBST_02(int[] sequence)
    {
        Stack<Integer> stack = new Stack<>();
        int root = Integer.MAX_VALUE;
        for (int i = sequence.length - 1; i >= 0; i--)
        {   //直到不满足性质1，则不是
            if (sequence[i] > root) return false;
            //满足性质2
            while (!stack.isEmpty() && stack.peek() > sequence[i])
                root = stack.pop();
            
            stack.push(sequence[i]);
        }
        return true;
    }
    
    
}
