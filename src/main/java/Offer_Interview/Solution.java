package Offer_Interview;


import java.util.ArrayList;
import java.util.Stack;

/**
 * 在一个二维数组中（每个一维数组的长度相同），
 * 每一行都按照从左到右递增的顺序排序，
 * 每一列都按照从上到下递增的顺序排序。
 * 请完成一个函数，输入这样的一个二维数组和一个整数，
 * 判断数组中是否含有该整数。
 */

public class Solution {

    /***
     * 1 发现可使用的规律  -- 左上 右下
     * 2 确定变化的是什么  -- Col Row
     * 3 循环的方式  -- 1 范围；2 怎么变化；3 如何实现
     */
    public static Integer Find(Integer[][] array, Integer target) {
        Integer col = array.length - 1;
        Integer row = 0;

        while (col >= 0 && row <= array[0].length - 1) {
            if (target == array[col][row]) {
                return target;
            } else if (target < array[col][row]) {
                col--;
            } else if (target > array[col][row]) {
                row++;
            }
        }

        return null;
    }


    /**
     * 请实现一个函数，将一个字符串中的每个空格替换成“%20”。
     * 例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
     *
     * @param str
     * @return
     */
    public static String replaceSpace(StringBuffer str) {
        StringBuffer resStr = new StringBuffer();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == 32) {
                resStr.append("%20");
            } else {
                resStr.append(str.charAt(i));
            }
        }
        return resStr.toString();
    }


    /**
     * 输入一个链表，按链表值从尾到头的顺序返回一个ArrayList。
     *
     * @param listNode
     * @return
     */
    //牛客上的递归方法
    public static ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> resArrayList = new ArrayList<Integer>();
        if (listNode != null) {
            printListFromTailToHead(listNode.next);
            resArrayList.add(listNode.val);
        }
        return resArrayList;
    }


    // 我的方法，这个实现没有看清题目：从后向前
    public static ArrayList<Integer> printListFromTailToHead_1(ListNode listNode) {
        ArrayList<Integer> resArrayList = new ArrayList<Integer>();
        while (listNode != null) {
            resArrayList.add(listNode.val);
            listNode = listNode.next;
        }
        return resArrayList;
    }


    //牛客上赞同最高的方法
    public static ArrayList<Integer> printListFromTailToHead_2(ListNode listNode) {
        Stack<Integer> stack = new Stack<Integer>();
        while (listNode != null) {
            stack.push(listNode.val);
            listNode = listNode.next;
        }

        ArrayList<Integer> list = new ArrayList<Integer>();

        while (!stack.isEmpty()) {
            list.add(stack.pop());
        }
        return list;
    }


    /**
     * 3 重建二叉树
     * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。
     * 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
     * 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
     *
     * @param pre
     * @param in
     * @return
     */
    public static TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        TreeNode root = reConstructBinaryTree(pre, 0, pre.length - 1, in, 0, in.length - 1);
        return root;
    }


    //前序遍历{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}
    private static TreeNode reConstructBinaryTree(int[] pre, int startPre, int endPre, int[] in, int startIn, int endIn) {

        if (startPre > endPre || startIn > endIn)
            return null;
        TreeNode root = new TreeNode(pre[startPre]);

        for (int i = startIn; i <= endIn; i++)
            if (in[i] == pre[startPre]) {
                root.left = reConstructBinaryTree(pre, startPre + 1, i - startIn + startPre, in, startIn, i - 1);
                root.right = reConstructBinaryTree(pre, i - startIn + startPre + 1, endPre, in, i + 1, endIn);
                break;
            }
        return root;
    }


    /**
     * 先序遍历：
     * 1 根节点
     * 2 左子树
     * 3 右子树
     *
     * 算法思路：
     *  1 确定树的左右子树：找到中序遍历和先序遍历相等的下标值；
     *  2 确定迭代的左右子树的范围，其中左子树的先序遍历，右子树是中序遍历：
     *      中序遍历中左子树的下标范围 + 先序遍历的起始点位置 = 迭代左子树范围（先序遍历）；
     *      中序遍历中左子树的下标范围 + 先序遍历的起始点位置 + 1 = 迭代右子树范围（先序遍历）；
     *  3 确定最终迭代的坐标范围，四个坐标分别为：
     *      左子树（先序遍历左子树范围，中序遍历左子树范围）
     *      右子树（先序遍历右子树范围，中序遍历右子树范围）
     *      先序遍历左子树范围 = （先序遍历左子树起始节点坐标 + 1 ，中序遍历左子树范围 + 先序遍历左子树起始节点坐标）
     *      中序遍历左子树范围 = （中序遍历左子树起始点坐标，中序遍历左子树的结束节点（就是i：分出左右子树）-1）
     *      先序遍历右子树范围 = （中序遍历左子树范围 + 先序遍历左子树起始节点坐标 + 1，先序遍历右子树结束节点）
     *      中序遍历右子树范围 = （中序遍历左子树的结束节点（就是i：分出左右子树）+ 1，中序遍历右子树结束节点）
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
        preOrderTraversal(treeNode.left);
        preOrderTraversal(treeNode.right);
        checkCurrentNode(treeNode);
    }


    public static void checkCurrentNode(TreeNode treeNode) {
        System.out.println(treeNode.val);
    }

}
