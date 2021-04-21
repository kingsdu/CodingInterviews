package JavaSE.BLS.Array;


/**
 * 十进制转二进制
 */
public class BinTest
{
    
    
    public static void main(String[] args)
    {
        BinTest bi = new BinTest();
        String s = bi.ToBinary(60);
        System.out.println(s);
    }
    
    public String ToBinary(int num)
    {
        char[] dic = {'0', '1'};
        char[] arr = new char[32];
        int index = arr.length;
        
        while (num != 0)
        {
            int temp = num & 1;
            arr[--index] = dic[temp];
            num = num >>> 1;
        }
        
        return toString(arr, index);
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
    
}
