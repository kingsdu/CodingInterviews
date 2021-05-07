package JavaSE.BLS.IO.Stream.InputStream;

import java.io.*;


/**
 * 字节读取流
 */
public class ByteArrayInputStreamTest
{
    
    
    public static void main(String[] args)
    {
//        ByteArrayInputStreamTest_1();
        readStreamToFile();
    }
    
    /**
     * 读取字节流的数据
     */
    public static void ByteArrayInputStreamTest_1()
    {
        ByteArrayInputStream bis = null;
        String mes = "hello,world";
        try
        {
            byte[] buf = mes.getBytes();
            bis = new ByteArrayInputStream(buf);
            int result = -1;
            while ((result = bis.read()) != -1)
            {
                System.out.print((char) result);
            }
        } finally
        {
            try
            {
                bis.close();
            } catch (IOException e)
            {
                e.printStackTrace();
            }
        }
    }
    
    
    /**
     * 将字节流写入到文件中
     */
    public static void readStreamToFile()
    {
        String mes = "你好,world";
        byte[] b = mes.getBytes();
        
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try
        {
            byteArrayOutputStream.write(b);
            
            FileOutputStream fileOutputStream = new FileOutputStream(new File("D:\\Files\\Txt\\2.txt"));
            
            byteArrayOutputStream.writeTo(fileOutputStream);
            
            fileOutputStream.flush();
        } catch (FileNotFoundException e)
        {
            e.printStackTrace();
        } catch (IOException e)
        {
            e.printStackTrace();
        } finally
        {
            try
            {
                byteArrayOutputStream.close();
            } catch (IOException e)
            {
                e.printStackTrace();
            }
        }
    }
}
