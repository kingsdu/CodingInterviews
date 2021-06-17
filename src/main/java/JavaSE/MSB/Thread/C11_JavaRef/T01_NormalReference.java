package JavaSE.MSB.Thread.C11_JavaRef;

import java.io.IOException;


//强引用
public class T01_NormalReference
{
    public static void main(String[] args) throws IOException
    {
        M m = new M();
        m = null;//只有被引用的部分指向null，GC才会回收,否则不会调用回收程序输出finalize
        System.gc(); //DisableExplicitGC
        
        System.in.read();//帮助程序阻塞
    }
}
