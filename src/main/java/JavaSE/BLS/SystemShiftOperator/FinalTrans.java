package JavaSE.BLS.SystemShiftOperator;


/**
 * 将十进制 转化为 二、八、十六 进制
 *
 * 关键点 ：
 * 1、一个int 有 4个字节byte 每个字节有8位bit  ==  1byte = 8bit。所以ToHex_1中最多循环8次
 * 2、ToHex_2中，当传入的数为0后，就不需要在继续循环了。
 * 3、&15 ， 15 = 1111 ；任何数和1111 & 都是原数字。
 *
 */
public class FinalTrans
{
    //查表法
    public final char[] dic = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    
    
    public static void main(String[] args)
    {
        FinalTrans fi = new FinalTrans();
        System.out.println(fi.TransNumber(60, 1, 1));
        System.out.println(fi.TransNumber(60, 7, 3));
        System.out.println(fi.TransNumber(60, 15, 4));
        
        int num = 60;
        System.out.println(Integer.toBinaryString(num));
        System.out.println(Integer.toOctalString(num));
        System.out.println(Integer.toHexString(num));
    }
    
    /**
     * @param number 传入数
     * @param base   奇数
     * @param offset 移位数
     * @return
     */
    public String TransNumber(int number, int base, int offset)
    {
        char[] arr = new char[32];
        int index = arr.length;
        while (number != 0)
        {
            int tmp = number & base;
            arr[--index] = dic[tmp];
            number = number >>> offset;
        }
        return toString(arr,index);
    }
    
    
    public String toString(char[] arr, int index)
    {
        String tmp = "";
        for (int i = index; i < arr.length; i++)
        {
            tmp += arr[i];
        }
        return tmp;
    }
}
