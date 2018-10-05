package Jianzhi_Offer;

/**
 * 输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
 */
public class NumberOf1 {


    /**
     * 思路：
     * 用1和n的每一位进行位与运算，判断1的个数
     *
     * 但是这个方法会遍历所有的位
     * @param num
     */
    public int numberOf_1(int num){
        int count = 0;
        int flag = 1;

        while (flag!=0){
            if((num & flag)!=0){
                count++;
            }
            flag = flag << 1;
        }
        return count;
    }


    /**
     * 二进制
     * @param num
     * @return
     */
    public String getBinaryNum(int num){
        StringBuilder sb = new StringBuilder();
        while (num!=0){
            int i = num % 2;
            sb.append(i);
            num/=2;
        }
        return sb.toString();
    }




}
