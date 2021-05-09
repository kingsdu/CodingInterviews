package JavaSE.BLS.Net.FileUpload2;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.util.Random;

public class TCPServerThread2 implements Runnable
{
    
    private Socket socket;
    
    public TCPServerThread2(Socket s){
        this.socket = s;
    }
    
    @Override
    public void run()
    {
        FileOutputStream fos = null;
        try
        {
            InputStream is = socket.getInputStream();
            File file = new File("D:\\Files\\Pictures\\upload");
            if (!file.exists())
            {
                file.mkdirs();
            }
    
            //自定义一个文件的命名规则:防止同名的文件被覆盖,规则:域名+毫秒值+随机数
            String fileName = "wd" + System.currentTimeMillis() + new Random().nextInt(999999) + ".jpg";
    
            fos = new FileOutputStream(file + "\\" + fileName);
    
            int len = 0;
            byte[] bytes = new byte[1024];
            while ((len = is.read(bytes)) != -1)
            {
                fos.write(bytes, 0, len);
            }
    
            socket.getOutputStream().write("上传成功".getBytes());
        } catch (IOException e)
        {
            e.printStackTrace();
        } finally
        {
            try
            {
                fos.close();
                socket.close();
            } catch (IOException e)
            {
                e.printStackTrace();
            }
        }
    }
}
