package JavaSE.BLS.Net.FileUpload3;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class PicThread implements Runnable
{
    private Socket s;
    
    PicThread(Socket s)
    {
        this.s = s;
    }
    
    public void run()
    {
        
        int count = 1;
        String ip = s.getInetAddress().getHostAddress();
        try
        {
            System.out.println(ip + "....connected");
            
            InputStream in = s.getInputStream();
            
            File dir = new File("D:\\Files\\Pictures\\upload");
            
            File file = new File(dir, ip + "(" + (count) + ")" + ".jpg");
            
            while (file.exists())
                file = new File(dir, ip + "(" + (count++) + ")" + ".jpg");
            
            FileOutputStream fos = new FileOutputStream(file);
            
            byte[] buf = new byte[1024];
            
            int len = 0;
            while ((len = in.read(buf)) != -1)
            {
                fos.write(buf, 0, len);
            }
            
            OutputStream out = s.getOutputStream();
            
            out.write("上传成功".getBytes());
            
            fos.close();
            
            s.close();
        } catch (Exception e)
        {
            throw new RuntimeException(ip + "上传失败");
        }
    }
}
