package JavaSE.BLS.IO.Stream.InputStream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class InputStreamTest
{
    
    public static void main(String[] args)
    {
        InputStreamTest_1();
    }
    
    public static void InputStreamTest_1()
    {
        FileInputStream fis = null;
        File f = new File("D:\\Files\\Txt\\1.txt");
        try
        {
            int i = 0;
            fis = new FileInputStream(f);
            byte[] buf = new byte[1024];
            int length = 0;
            
            while ((length = fis.read(buf)) != -1)
            {
                System.out.println(new String(buf, 0, length));
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
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    
}
