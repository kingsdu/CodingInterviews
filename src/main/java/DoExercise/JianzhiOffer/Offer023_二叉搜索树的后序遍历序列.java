package DoExercise.JianzhiOffer;


import java.util.Stack;

/**
 *
 *  https://leetcode-cn.com/problems/er-cha-sou-suo-shu-de-hou-xu-bian-li-xu-lie-lcof/submissions/
 *
 * 方法1可以用递归来做
 * 方法2可以用辅助栈来做
 */
public class Offer023_二叉搜索树的后序遍历序列
{
    
    public static void main(String[] args)
    {
        int[] sequence = {1, 5, 3, 9, 10, 12, 7};
        boolean b = VerifySquenceOfBST_01(sequence);
        
        System.out.println(b ? "true" : "false");
    }
    
    public static boolean VerifySquenceOfBST_01(int[] sequence)
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
     * @param postorder
     * @param i
     * @param j
     * @return
     */
    private static boolean recur(int[] postorder, int i, int j)
    {
        if (i >= j) return true;
        
        int p = i;
        while (postorder[p] < postorder[j]) p++;
        int m = p;
        while (postorder[p] > postorder[j]) p++;
        return p == j && recur(postorder, i, m - 1) && recur(postorder, m, j - 1);//m == right保证了左节点都小于根节点，右节点都大于根节点
    }
    
    
    /**
     * 性质
     * 1、当ri < ri+1 时，ri一定是ri+1的右子节点。
     * 2、当ri > ri+1 时,ri一定是某节点root的左子节点，且root为ri+1、ri+2、ri+3中大于且距ri最近的节点。
     * <p>
     * 故
     * 思路：
     * 1、借助一个单调栈 stackstack 存储值递增的节点；
     * 2、每当遇到值递减的节点，则通过出栈来更新节点的父节点
     * 3、每轮判断i和root之间的关系：（1）i>root 不符合搜索二叉树规则，跳出；（2）i<root，继续遍历
     *
     * @param sequence
     * @return
     */
    public static boolean VerifySquenceOfBST_02(int[] sequence)
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
