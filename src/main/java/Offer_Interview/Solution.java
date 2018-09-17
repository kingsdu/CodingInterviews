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


    /**
     * 算法思路：
     * 以前序遍历序列为递归顺序，以中序遍历序列为左右子树的值，提供下标的控制，
     * 巧妙的将其分为左 和 右 子树，提供new新建节点。
     *
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
     *
     * 前序遍历{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}
     */
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



    /**
     * 第5题：
     * 用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。
     * */
    static Stack<Integer> stack1 = new Stack<Integer>();
    static Stack<Integer> stack2 = new Stack<Integer>();


    /**
     * stack1用来存值
     * @param node
     */
    public static void push(int node) {
        stack1.push(node);
    }

    /**
     * stack2用来出值
     * 若stack2为空，则直接将Stack1中的值入到Stack2中，若不为空，则出栈。
     *
     * 另外这里要注意peek（）、pop之间的不同
     * @return
     */
    public static int pop() {
        if(stack1.isEmpty() && stack2.isEmpty()){
            throw new RuntimeException("Queue is Empty");
        }

        if(stack2.isEmpty()){
            while(!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
        }

        return stack2.pop();
    }


    /**
     * 第6题：
     * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
     * 输入一个非减排序的数组的一个旋转，输出旋转数组的最小元素。
     * 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
     * NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
     * */


    /**
     *
     * 题目的要求是确定最小元素的位置
     * 所以可以用二分法来思考
     * 1 情况一：最小数字在mid的右边，类似[3,4,5,6,0,1,2]数组，low = mid + 1
     * 2 情况二：最小数字在mid的左边，或者就是array[mid]。因为右边必然都是递增的。类似[2,2,3,4,5,6,6]数组，high = high - 1
     * 3 情况三：最小数字不好判断在mid左边还是右边,这时只好一个一个试。类似 [1,0,1,1,1] 或者[1,1,1,0,1]数组，high = mid
     *
     * 如果待查询的范围最后只剩两个数，那么mid 一定会指向下标靠前的数字
     * 比如 array = [4,6]
     * array[low] = 4 ;array[mid] = 4 ; array[high] = 6 ;
     * 如果high = mid - 1，就会产生错误， 因此high = mid
     * 但情形(1)中low = mid + 1就不会错误
     *
     * @param array
     * @return
     */
    public static int minNumberInRotateArray_2(int [] array){
        int low = 0;
        int high = array.length-1;
        while (low < high){
            int middle = low + (high - low)/2;
            if(array[middle] > array[high]){
                low = middle + 1;
            }else if(array[middle] == array[high]){
                high = high-1;
            }else {
                high = middle;
            }
        }
        return array[low];
    }


    /**
     * 查找二分法
     */
    public static int binarySearch(int[] array,int key,int low,int high){
        if(low>high || key<array[low] || key>array[high]){
            return -1;
        }
        int middle = (low + high)/2;
        if(array[middle] > key){
            return binarySearch(array,key,low,middle);
        }else if(array[middle] < key){
            return binarySearch(array,key,middle+1,high);
        }else {
            return middle;
        }
    }

    /**
     * 遍历，比大小，但这个应该不是题目要求的意思
     * @param array
     * @return
     */
    public int minNumberInRotateArray_1(int [] array) {
        if(array.length == 0){
            return 0;
        }

        int min = array[0];
        for (int i = 0; i < array.length; i++) {
            if(array[i]<=0){
                return 0;
            }else{
                if(min>array[i]){
                    min = array[i];
                }
            }
        }
        return min;
    }


    /**
     * 现在要求输入一个整数n，请你输出斐波那契数列的第n项（从0开始，第0项为0）。
     * n<=39
     * @param n
     * @return
     */
    public static int Fibonacci(int n) {
        if(n < 0){
            return -1;
        }else if(n==0 || n==1){
            return n;
        }
        return Fibonacci(n-1)+Fibonacci(n-2);
    }


    /**
     * 一只青蛙一次可以跳上1级台阶，也可以跳上2级。
     * 求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）
     *
     * 求解思路：本题,前提只有一次 1阶或者2阶的跳法。
     * a.如果两种跳法，1阶或者2阶，那么假定第一次跳的是一阶，那么剩下的是n-1个台阶，跳法是f(n-1);
     * b.假定第一次跳的是2阶，那么剩下的是n-2个台阶，跳法是f(n-2);
     * c.由a\b假设可以得出总跳法为: f(n) = f(n-1) + f(n-2);
     * d.然后通过实际的情况可以得出：只有一阶的时候 f(1) = 1 ,只有两阶的时候可以有 f(2) = 2;
     * e.可以发现最终得出的是一个斐波那契数列
     */
    public static int JumpFloor(int target) {
        if(target<=0){
            return -1;
        }else if(target == 1){
            return 1;
        }else if(target == 2){
            return 2;
        }else{
            return  JumpFloor(target-1)+JumpFloor(target-2);
        }
    }


    /**
     * 一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。
     * 求该青蛙跳上一个n级的台阶总共有多少种跳法。
     * @param target
     * @return
     *
     * n = 1时，只有1种跳法，f(1) = 1;
     * n = 2时，会有两个跳得方式，一次1阶或者2阶，这回归到了问题（1） ，f(2) = f(2-1) + f(2-2) ;
     * n = 3时，会有三种跳得方式，1阶、2阶、3阶，
     * n = n时， f(n) = f(n-1)+f(n-2)+...+f(n-(n-1)) + f(n-n) => f(0) + f(1) + f(2) + f(3) + ... + f(n-1)
     * f(n-1) = f(0) + f(1)+f(2)+f(3) + ... + f((n-1)-1) = f(0) + f(1) + f(2) + f(3) + ... + f(n-2)
     * f(n) = f(0) + f(1) + f(2) + f(3) + ... + f(n-2) + f(n-1) = f(n-1) + f(n-1)
     * 可以得出：f(n) = 2*f(n-1)
     */
    public static int JumpFloorII(int target){
        if(target <= 0){
            return -1;
        }else if(target == 1){
            return 1;
        }else {
            return 2 * JumpFloorII(target - 1);
        }
    }


    /**
     * 我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。
     * 请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，
     * 总共有多少种方法？
     * @param target
     * @return
     * 依旧是斐波那契数列
     * 2*n的大矩形，和n个2*1的小矩形
     * 其中target*2为大矩阵的大小
     * 1 target <= 0 大矩形为<= 2*0,直接return 1；
     * 2 target = 1大矩形为2*1，只有一种摆放方法，return1；
     * 3 target = 2 大矩形为2*2，有两种摆放方法，return2；
     * 4 target = n 分为两步考虑：第一次摆放一块 2*1 的小矩阵，则摆放方法总共为f(target - 1)
     *
     * 第一次摆放一块1*2的小矩阵，则摆放方法总共为f(target-2)
     * 因为，摆放了一块1*2的小矩阵（用√√表示），对应下方的1*2（用××表示）摆放方法就确定了，所以为f(targte-2)
     */
    public static int RectCover(int target) {
        if (target < 1) {
            return 0;
        } else if (target == 1 || target == 2) {
            return target;
        } else {
            return RectCover(target-1) + RectCover(target-2);
        }
    }


    /**
     * 输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
     * @param n
     * @return
     */
    public static int NumberOf1(int n){

        return 0;
    }
}
