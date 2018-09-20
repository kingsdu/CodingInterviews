package Jianzhi_Offer;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

public class SolutionTest {

    private long startTime = 0;
    /**
     *
     */
    @Before
    public void startTime(){
        startTime = System.currentTimeMillis();
    }

    @After
    public void endTime(){
        System.out.println("\r<br>执行耗时 : "+(System.currentTimeMillis()-startTime)+" ms ");
    }


    /**
     * 二维数组中的查找
     */
    @Test
    public void find() {
        Integer[][] array = {{1,2,3},{4,5,6},{7,8,9}};
        if(Solution.Find(array,-1)!=null){
            System.out.println("true");
        }else {
            System.out.println("flase");
        }
    }

    /**
     * 替换空格
     */
    @Test
    public void replaceSpace(){
        StringBuffer str = new StringBuffer("We Are Happy");
        System.out.println(Solution.replaceSpace(str));
    }



    static ListNode head;

    public static void addNode(ListNode node){
        if(head==null){
            head = node;
            return;
        }

        ListNode temp = head;
        while(temp.next != null){    //遍历单链表，直到遍历到最后一个则跳出循环。
            temp = temp.next;        //往后移一个结点，指向下一个结点。
        }
        temp.next = node; //temp为最后一个结点或者是头结点，将其next指向新结点
    }

    /**
     * 从尾到头打印链表
     */
    @Test
    public void printListFromTailToHead(){
        for (int i = 1; i < 20000; i+=2) {
            ListNode listNode = new ListNode(i);
            addNode(listNode);
        }

        ArrayList<Integer> integers = Solution.printListFromTailToHead_2(head);

        for (Integer i :
                integers) {
            System.out.println(i + " ");
        }
    }


    @Test
    public void reConstructBinaryTree(){
        int[]pre = {1,2,4,7,3,5,6,8};
        int[]in = {4,7,2,1,5,3,8,6};
        TreeNode treeNode = Solution.reConstructBinaryTree(pre,in);
        Solution.postOrderTraversal(treeNode);
    }


    @Test
    public void achieveQueue(){
        Solution.push(1);
        Solution.push(2);
        Solution.push(3);
        Solution.push(4);

        if(Solution.stack2.isEmpty()){
            System.out.println(Solution.pop());
            while(!Solution.stack2.isEmpty()){
                System.out.println(Solution.pop());
            }
        }else{
            while(!Solution.stack2.isEmpty()){
                System.out.println(Solution.pop());
            }
        }

    }


    /**
     * 旋转数组的最小数字
     */
    @Test
    public void minNumberInRotateArray_2Test(){
        int[] array = new int[]{3,4,5,1,2};
        int result = Solution.minNumberInRotateArray_2(array);
        System.out.println(result);
    }


    /**
     * 斐波拉契数列
     */
    @Test
    public void FibonacciTest(){
        int fibonacci = Solution.Fibonacci(11);
        System.out.println("fibonacci "+fibonacci);
    }


    /**
     * 读懂题目很重要
     */
    @Test
    public void JumpFloorTest(){
        System.out.println(Solution.JumpFloor(10));
    }

    /**
     * 读懂题目很重要,数学很重要
     */
    @Test
    public void JumpFloorII(){
        System.out.println(Solution.JumpFloorII(10));
    }


    @Test
    public void binarySearch(){
        int [] arr = new int[]{1,6,8,9,13};
        int i1 = Solution.binarySearch(arr, 6, 0, arr.length-1);
        System.out.println(arr[i1]);
    }


    @Test
    public void calChuAndYu(){
        System.out.println(1%2);
        System.out.println(0%2);
        System.out.println(1/2);
        System.out.println(0/2);
    }

    @Test
    public void calYuAndHuo(){
        System.out.println(1&0);
        System.out.println(1&1);
        System.out.println(0&0);
    }
}