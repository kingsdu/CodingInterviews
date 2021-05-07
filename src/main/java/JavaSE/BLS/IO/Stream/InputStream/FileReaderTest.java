package JavaSE.BLS.IO.Stream.InputStream;

import java.io.*;

public class FileReaderTest
{
    public static void main(String[] args)
    {
        FileReaderTest_1();
    }
    
    public static void FileReaderTest_1(){
        FileReader fa = null;
        File f = new File("D:\\Files\\Txt\\1.txt");
        try
        {
            int i = 0;
            char[] buf = new char[1024];
            int length = -1;
            fa = new FileReader(f);
            while ((length = fa.read(buf)) != -1){
                System.out.println(new String(buf,0,length));
                i++;
            }
            System.out.println(i);
        } catch (FileNotFoundException e)
        {
            e.printStackTrace();
        } catch (IOException e)
        {
            e.printStackTrace();
        } finally
        {
            try {
                fa.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    
}
