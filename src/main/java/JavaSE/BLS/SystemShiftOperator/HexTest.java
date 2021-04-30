package JavaSE.BLS.SystemShiftOperator;

/**
 * 关键点 ：
 * 1、一个int 有 4个字节byte 每个字节有8位bit  ==  1byte = 8bit。所以ToHex_1中最多循环8次
 * 2、ToHex_2中，当传入的数为0后，就不需要在继续循环了。
 * 3、&15 ， 15 = 1111 ；任何数和1111 & 都是原数字。
 */
public class HexTest
{
    
    
    public static void main(String[] args)
    {
        int num = 26;
        HexTest hexTest = new HexTest();
        String s = hexTest.ToHex_4(num);
        System.out.println(s);
    }
    
    /**
     * 输入任意一个十进制的数，将其传为十六进制
     * <p>
     * 相关题目：Offer011_NumberOf1：输入一个整数，输出该数32位二进制表示中1的个数。其中负数用补码表示。
     *
     * @param number
     * @return
     */
    public String ToHex_1(int number)
    {
        char[] res = new char[8];
        int index = res.length - 1;
        for (int i = 0; number != 0 && i < 8; i++)
        {
            int temp = number & 15;
            
            if (temp > 9)
            {   // 0-9 a  b  c  d  e  f
                // 0-9 10 11 12 13 14 15
                res[index] = (char) (temp - 10 + 'a');
            } else
            {   //int 转 char == int + '0';
                // char 转 int == int - '0'
                res[index] = (char) (temp + '0');
            }
            index--;
            number = number >>> 4;//无符号右移
        }
        return "0x" + toString(res);
    }
    
    
    /**
     * 1、for 变为 while
     *
     * @param number
     * @return
     */
    public String ToHex_2(int number)
    {
        char[] res = new char[8];
        int index = res.length - 1;
        while (number != 0)
        {
            int temp = number & 15;
            
            if (temp > 9)
            {   // 0-9 a  b  c  d  e  f
                // 0-9 10 11 12 13 14 15
                res[index] = (char) (temp - 10 + 'a');
            } else
            {   //int 转 char == int + '0';
                // char 转 int == int - '0'
                res[index] = (char) (temp + '0');
            }
            index--;
            number = number >>> 4;//无符号右移
        }
        return "0x" + toString(res);
    }
    
    
    /**
     * 去掉空格
     *
     * @param number
     * @return
     */
    public String ToHex_3(int number)
    {
        char[] res = new char[8];
        int index = res.length;
        while (number != 0)
        {
            int temp = number & 15;
            
            if (temp > 9)
            {   // 0-9 a  b  c  d  e  f
                // 0-9 10 11 12 13 14 15
                res[--index] = (char) (temp - 10 + 'A');
            } else
            {   //int 转 char == int + '0';
                // char 转 int == int - '0'
                res[--index] = (char) (temp + '0');
            }
            number = number >>> 4;//无符号右移
        }
        return "0x" + toString(res, index);
    }
    
    
    /**
     *
     * 查表法
     *
     * @param number
     * @return
     */
    public String ToHex_4(int number)
    {
        char[] dic = {'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
        char[] arr = new char[8];
        int index = arr.length;
        while (number != 0){
            int tmp = number & 15;
            arr[--index] = dic[tmp];
            number = number >>> 4;
        }
        return "0x"+toString(arr,index);
    }
    
    
    public String toString(char[] arr, int index)
    {
        String temp = "";
        
        for (int i = index; i < arr.length; i++)
        {
            temp += arr[i];
        }
        
        return temp;
    }
    
    
    public String toString(char[] arr)
    {
        String temp = "";
        
        for (int i = 0; i < arr.length; i++)
        {
            temp += arr[i];
        }
        
        return temp;
    }
    
}
