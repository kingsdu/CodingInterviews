package Offer_Interview;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

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

}