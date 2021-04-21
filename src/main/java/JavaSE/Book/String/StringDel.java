package JavaSE.Book.String;

/**
 *
 *
 *
 */
public class StringDel {

    protected void delStrEqual_1(){
        String str1 = "Hello World";
        String str2 = "Hello"+" World";
        System.out.println(str1 == str2);
    }

    protected void delStrEqual_2(){
        String str1 = "Hello World";
        String str2 = "Hello";
        String str3 = str2 + " World";
        System.out.println(str1 == str3);
    }

}
