package Java_SE.String;


/**
 *
 * StringBuilder 方法测试类
 *
 */
public class StringBuilderTest
{


    public static void main(String[] args)
    {
        StringBuilder sbr = new StringBuilder("abcd");
        System.out.println(sbr);

        sbr = sbr.reverse();

        System.out.println(sbr);

    }

}
