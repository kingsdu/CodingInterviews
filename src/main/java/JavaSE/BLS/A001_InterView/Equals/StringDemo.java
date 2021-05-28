package JavaSE.BLS.A001_InterView.Equals;

public class StringDemo
{
    public static void main(String[] args)
    {
        String a = new String("myString");
        String b = "myString";
        String c = "my" + "String";
        String d = c;
        System.out.println(a == b);
        System.out.println(a == c);
        System.out.println(b == c);//true
        System.out.println(b == d);//true
    }
}
