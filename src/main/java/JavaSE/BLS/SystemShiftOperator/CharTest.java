package JavaSE.BLS.SystemShiftOperator;

public class CharTest
{
    /**
     *
     * char类型的强制转换
     *
     * 只有 char类型 和 ASCII码表有对应关系
     *
     *
     * @param args
     */
    public static void main(String[] args)
    {
        char i = 'a' + 1;
        System.out.println(i);//为什么没有运算符就是字符？有运算就会强制转换为数字，否则就是char类型
        System.out.println((i + 1));//为什么一旦有运算后，就会变为数字？
    }
    
}
