package JavaSE.BLS.Net.FileUpload3;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class PicClient
{
    public static void main(String[] args)throws Exception
    {
        if(args.length!=1)
        {
            System.out.println("请选择一个jpg格式的图片");
            return ;
        }
        
        File file = new File(args[0]);
        if(!(file.exists() && file.isFile()))
        {
            System.out.println("该文件有问题，要么补存在，要么不是文件");
            return ;
            
        }
        
        if(!file.getName().endsWith(".jpg"))
        {
            System.out.println("图片格式错误,请重新选择");
            return ;
        }
        
        if(file.length()>1024*1024*5)
        {
            System.out.println("文件过大，没安好心");
            return ;
        }
        
        Socket s = new Socket("127.0.0.1",10007);
        
        FileInputStream fis = new FileInputStream(file);
        
        OutputStream out = s.getOutputStream();
        
        byte[] buf = new byte[1024];
        
        int len = 0;
        
        while((len=fis.read(buf))!=-1)
        {
            out.write(buf,0,len);
        }
        
        //告诉服务端数据已写完
        s.shutdownOutput();
        
        InputStream in = s.getInputStream();
        
        byte[] bufIn = new byte[1024];
        
        int num = in.read(bufIn);
        System.out.println(new String(bufIn,0,num));
        
        fis.close();
        s.close();
    }
}
