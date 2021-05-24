package JavaSE.BLS.String;

/**
 * 1、一般来说，==比较的是引用，即地址，equal比较的是值；
 * 2、如果都是new，则比较的结果==一定是FALSE，equal则看值
 * 3、如果先一个new，一个直接赋值一个字符串 如String a=new String（“AA”）； String b=“AA”； 此时结果==和equal都是TRUE，因为第二个在创建时会去字符串常量池找，有直接拿来用，不会专门去new 一个。
 * 4、先直接赋值一个再new一个，则==是FALSE
 *
 *
 */
public class Equals_String
{
    public static void main(String[] args)
    {
        String s1 = new String("xyz");
        String s2 = new String("xyz");
        Boolean b1 = s1.equals(s2);
        Boolean b2 = (s1 == s2);
        System.out.print(b1 + "" + b2);
    }
}
