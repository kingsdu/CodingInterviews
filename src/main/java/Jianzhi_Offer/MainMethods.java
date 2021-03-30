package Jianzhi_Offer;

import java.math.BigDecimal;

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
        String str = "We Are Happy";
        ReplaceSpace rse = new ReplaceSpace();
        System.out.println(rse.replace_2(str));

        long endTime = System.currentTimeMillis();
        System.out.println("运行时间："+new BigDecimal(endTime-startTime).divide(new BigDecimal(1000)).doubleValue());
    }



}
