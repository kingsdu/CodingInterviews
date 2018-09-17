package DataStruct;

import Offer_Interview.TreeNode;

public class ReconstructTree {

    public static void main(String[] args){
        int[]pre = {1,2,4,7,3,5,6,8};
        int[]in = {4,7,2,1,5,3,8,6};
        int[]post = {7,4,2,5,8,6,3,1};
        TreeNode treeNode = ReconstructTree.reContructTree(in,post);
        ReconstructTree.postOrderTraversal(treeNode);
    }


    public static TreeNode reContructTree(int []in,int []post){
        TreeNode node = reConsructPostTree(in,0,in.length-1,post,0,post.length-1);
        return node;
    }



    public static TreeNode reConsructTree(int []pre,int startPre,int startEnd,int []in,int endPre,int endIn){
        if(startPre > startEnd || endPre > endIn){
            return null;
        }

        TreeNode root = new TreeNode(pre[startPre]);

        for (int i = endPre; i <= endIn; i++) {
            if(in[i] == pre[startPre]){
                root.left = reConsructTree(pre,startPre + 1,i-endPre+startPre,in,endPre,i-1);
                root.right = reConsructTree(pre,i - endIn + startPre + 1,startEnd,in,i+1,endIn);
                break;
            }
        }
        return root;
    }


    public static TreeNode reConsructPostTree(int []In,int startIn,int endIn,int []post,int startPost,int endPost){
        if(startPost > endPost || startIn > endIn){
            return null;
        }

        TreeNode treeNode = new TreeNode(post[endPost]);

        for (int i = startIn; i <=endIn ; i++) {
            if(post[endPost] == In[i]){
                treeNode.left = reConsructPostTree(In,startIn,i-1,post,startPost,startPost+(i-startIn-1));
                treeNode.right = reConsructPostTree(In,i+1,endIn,post,startPost+(i-startIn),endPost-1);
                break;
            }
        }
        return treeNode;
    }


    /**
     * 先序遍历：
     * 1 根节点
     * 2 左子树
     * 3 右子树
     * @param treeNode
     */
    public static void preOrderTraversal(TreeNode treeNode) {
        if (treeNode == null) return;
        checkCurrentNode(treeNode);
        preOrderTraversal(treeNode.left);
        preOrderTraversal(treeNode.right);
    }

    public static void postOrderTraversal(TreeNode treeNode) {
        if (treeNode == null) return;
        postOrderTraversal(treeNode.left);
        postOrderTraversal(treeNode.right);
        checkCurrentNode(treeNode);
    }

    public static void midOrderTraversal(TreeNode treeNode) {
        if (treeNode == null) return;
        midOrderTraversal(treeNode.left);
        checkCurrentNode(treeNode);
        midOrderTraversal(treeNode.right);
    }

    public static void checkCurrentNode(TreeNode treeNode) {
        System.out.println(treeNode.val);
    }
}
