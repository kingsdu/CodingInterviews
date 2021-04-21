package JavaSE.Book.InnerClass;

public class A02Inner
{
    private String inStr= "Inner中的字符串";
    private A02Outer out;
    //构造注入
    public A02Inner(A02Outer out)  //3
    {
        this.out=out;       //4.为Inner中的out变量初始化
    }
    public void print(){    //6
        System.out.println(out.getOutStr()); //7
    }
}
