package Jianzhi_Offer;

import java.math.BigDecimal;
import java.util.ArrayList;

/**
 * 所有方法主类
 */
public class MainMethods {

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();

//        Solution sl = new Solution();

        //生成随机数组
//        int rows = 31500,cols = 31400;
//        int[][] arrayListGet = sl.ArrayList_get(rows, cols);
        //遍历法
//        int target = 111;
////        int [][] arrayTar = {{1,2,8,9},{2,4,9,12},{4,7,10,13},{6,8,11,15}};
//        System.out.println(sl.Find_1(target,arrayListGet));
        //位置法
//        int target = 111;
////        int [][] arrayTar = {{1,2,8,9},{2,4,9,12},{4,7,10,13},{6,8,11,15}};
//        System.out.println(sl.Find_2(target,arrayListGet));

        //字符串替换
//        String str = "We Are Happy";
//        ReplaceSpace rse = new ReplaceSpace();
//        System.out.println(rse.replace_2(str));

        /** 反向打印链表*/
        ListNode node = new ListNode();
        ListNode.Node curNode;
        PrintList printList = new PrintList();

        node.addNodeOrder(1);
        node.addNodeOrder(2);
        node.addNodeOrder(3);
        curNode = node.head;

        node.printListNode();

        System.out.println();

        ArrayList<Integer> resList = printList.printListFromTailToHead_1(curNode);

        for (Integer number :
                resList) {
            System.out.print(number+" ");
        }

        long endTime = System.currentTimeMillis();
        System.out.println("运行时间："+new BigDecimal(endTime-startTime).divide(new BigDecimal(1000)).doubleValue());
    }



}
