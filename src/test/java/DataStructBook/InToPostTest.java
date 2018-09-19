package DataStructBook;

import org.junit.Test;

import static org.junit.Assert.*;

public class InToPostTest {

    @Test
    public void calMidToPost() {
        String input = "1+2*3+(4+5)*6";//123*+45+6*+
        String str = InToPost.calMidToPost(input);
        System.out.println("Postfix is" + str + '\n');
    }

    @Test
    public void calPostValue() {
        String input = "123*+45+6*+";
        int result = InToPost.calPostValue(input);
        System.out.println(result);
    }


    /**
     * java中int和char的转化方法
     * https://blog.csdn.net/GreyBearChao/article/details/78121448
     */
    @Test
    public void CharAndIntChange(){
        char ch_1 = '1';
        char ch_2 = '2';
        int num = (ch_1 - '0')*(ch_2 - '0');
        System.out.println((char)(num+'0'));
    }
}