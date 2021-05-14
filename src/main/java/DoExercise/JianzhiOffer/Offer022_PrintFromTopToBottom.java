package DoExercise.JianzhiOffer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 *
 *
 * 从上往下打印出二叉树的每个节点，同层节点从左至右打印。
 *
 *
 */
public class Offer022_PrintFromTopToBottom
{
    
    
    public static void main(String[] args)
    {
        TreeNode root = new TreeNode(3);//大树根节点
        TreeNode r1 = new TreeNode(9);
        TreeNode r2 = new TreeNode(20);
        root.right = r2;
        root.left = r1;
        TreeNode r3 = new TreeNode(15);
        TreeNode r4 = new TreeNode(7);
        r2.right = r4;
        r2.left = r3;

        Offer022_PrintFromTopToBottom of = new Offer022_PrintFromTopToBottom();
        ArrayList<Integer> arrayList = of.PrintFromTopToBottom(root);
    
        for (int x :
                arrayList)
        {
            System.out.print(x+" ");
        }
    }
    
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        ArrayList<Integer> aList = new ArrayList<>();
        
        if(null == root || root.equals("")){
            return aList;
        }
        queue.offer(root);
        
        while (!queue.isEmpty()){
            TreeNode poll = queue.poll();
            aList.add(poll.val);
            if(null != poll.left){
                queue.offer(poll.left);
            }
            
            if(null != poll.right){
                queue.offer(poll.right);
            }
        }
        return aList;
    }
  
    
    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;
        
        public TreeNode(int val) {
            this.val = val;
        }
    }
    
}
