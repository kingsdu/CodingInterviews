package JavaSE.BLS.SystemShiftOperator;

public class CharTest
{
    /**
     * char类型的强制转换
     * <p>
     * 只有 char类型 和 ASCII码表有对应关系
     *
     * @param args
     */
    public static void main(String[] args)
    {
        char i = 'a';
        System.out.println(i);//对应输出char类型
        
        System.out.println((i + 1));//一旦有运算后，意味着发生了强制转换，就会变为数字
        
        //同理，将字符付给int类型，输出的int类型时也会自动转换
        int num = 'b';
        System.out.println(num);
        //也可以将char类型直接赋值给int类型
        num = i;
        //char 赋值给int类型，则需要强制转换，因为范围不同，会造成精度丢失
        i = (char) num;
    }
    
}
