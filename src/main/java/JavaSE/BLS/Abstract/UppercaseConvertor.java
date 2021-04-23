package JavaSE.BLS.Abstract;

import java.io.*;


/**
 *
 * FilterReader
 * 中没有一个抽象方法里面的每个方法都是调用构造函数传入的Reader对象的方法.
 * 这种抽象类你不能实例化它,因为实例化它没意义,它还没实现任何Filter的功能.
 * 只有在extends具体子类时实现Filter功能,实例化相应的子类才有实际意义.
 *
 *
 */
public class UppercaseConvertor extends FilterReader
{
    /**
     * Creates a new filtered reader.
     *
     * @param in a Reader object providing the underlying stream.
     * @throws NullPointerException if {@code in} is {@code null}
     */
    protected UppercaseConvertor(Reader in)
    {
        super(in);
    }
    
    public static void main(String[] args) throws IOException
    {
        UppercaseConvertor uc = new UppercaseConvertor(new FileReader(""));
        BufferedReader br = new BufferedReader(uc);
        String r;
        while(null!=(r=br.readLine())){
        System.out.println(r);
    }
    
    }
}
