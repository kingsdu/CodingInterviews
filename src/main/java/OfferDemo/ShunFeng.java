package OfferDemo;


/**
 * 顺丰笔试题目
 */
public class ShunFeng {

    public static void main(String[] args) {

    }

    /**
     * 将32位的有符号整数进行反转
     * <p>
     * 例如 123 -> 321
     * -321 -> -123
     * <p>
     * 不用记录数字本身的正负
     * 可以提供数字的正负返回相应的值
     * 使用自带的Stringbuilder来返回
     */
    public static int reverseNum(int num) {
        int temp = Math.abs(num);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(temp);
        stringBuilder = stringBuilder.reverse();

        if (Long.parseLong(stringBuilder.toString()) > Integer.MAX_VALUE) {
            return 0;
        }
        return num > 0 ? Integer.parseInt(stringBuilder.toString()) : -Integer.parseInt(stringBuilder.toString());
    }


    /**
     * 根据后序遍历和中序遍历求先序遍历的值
     * <p>
     * 后序遍历：CDBFEA
     * 中序遍历：CBDAEF
     */
    public static TreeNodes reConsructTree(String[] in, String[] post) {
        TreeNodes treeNodes = reConstructTrees(in, 0, in.length - 1, post, 0, post.length - 1);
        return treeNodes;
    }


    public static TreeNodes reConstructTrees(String[] in, int inStart, int inend, String[] post, int postStart, int postEnd) {
        if (inStart > inend || postStart > postEnd) {
            return null;
        }

        TreeNodes treeNodes = new TreeNodes(post[postEnd]);

        for (int i = inStart; i <= inend; i++) {
            if (post[postEnd] == in[i]) {
                treeNodes.left = reConstructTrees(in, inStart, i - 1, post, postStart, i - inStart + postStart - 1);
                treeNodes.right = reConstructTrees(in, i + 1, inend, post, i - inStart + postStart, postEnd - 1);
                break;
            }
        }
        return treeNodes;
    }


    public static void postOrderTraversal(TreeNodes treeNodes) {
        if (treeNodes == null) {
            return;
        }
        postOrderTraversal(treeNodes.left);
        postOrderTraversal(treeNodes.right);
        System.out.println(treeNodes.value);
    }


    /**
     * 1 将给定数字序列重新排列成字典序列中下一个更大的排列
     * 2 若不存在下一个更大的排列，则将数字重复排列成原最小的排列
     * <p>
     * 1,2,3 -> 1,3,2
     * 3,2,1 -> 1,2,3
     * 1,1,5 -> 1,5,1
     * <p>
     * 思路：后一位和前一位比，若后一位 > 前一位，则交换位置。
     * 若都不大于，则将该数字重新排列，从小到大，按位数依次排列。
     *
     * 问题：1 不熟练，插入排序依旧在写错
     *      2 对下标不敏感，i老在用错
     *      3 对与while和if的选择使用的不好
     */
    public static int[] changeArrayList(int[] num) {
        int i = 0;
        while (i < num.length-1) {
            if (num[i] < num[i + 1]) {
                int temp = num[i];
                num[i] = num[i + 1];
                num[i + 1] = temp;
                return num;
            } else {
                ++i;
            }
        }
        if (i >= num.length - 1) {
            for (int j = 1; j < num.length; j++) {
                int leftIndex = j - 1;
                int temp = num[j];
                while (leftIndex >= 0 && num[leftIndex] > temp) {
                    num[leftIndex + 1] = num[leftIndex];
                    leftIndex--;
                }
                num[leftIndex + 1] = temp;
            }
            return num;
        }
        return null;
    }
}
