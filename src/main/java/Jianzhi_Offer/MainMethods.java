package Jianzhi_Offer;

import java.math.BigDecimal;

/**
 * 所有方法主类
 */
public class MainMethods {

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();


        int target = 111;
        int [][] arrayTar = {{1,2,8,9},{2,4,9,12},{4,7,10,13},{6,8,11,15}};
        Solution sl = new Solution();
        System.out.println(sl.Find(target,arrayTar));


        long endTime = System.currentTimeMillis();
        System.out.println("运行时间："+new BigDecimal(endTime-startTime).divide(new BigDecimal(1000)).doubleValue());
    }

}
