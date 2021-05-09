package JavaSE.BLS.Net.FileUpload2;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * 文件上传案例的客户端:读取本地文件,上传到服务器,读取服务器回写的数
 * 明确:
 * 数据源:c:\\1.jpg
 * 目的地:服务
 * 实现步骤:
 * 1.创建一个本地字节输入流FileInputStream对象,构造方法中绑定要读取的数据源
 * 2.创建一个客户端Socket对象,构造方法中绑定服务器的IP地址和端口号
 * 3.使用Socket中的方法getOutputStream,获取网络字节输出流OutputStream对象
 * 4.使用本地字节输入流FileInputStream对象中的方法read,读取本地文件
 * 5.使用网络字节输出流OutputStream对象中的方法write,把读取到的文件上传到服务器
 * 6.使用Socket中的方法getInputStream,获取网络字节输入流InputStream对象
 * 7.使用网络字节输入流InputStream对象中的方法read读取服务回写的数据
 * 8.释放资源(FileInputStream,Socket)
 */
public class TCPClient2
{
    public static void main(String[] args) throws IOException
    {
        
        FileInputStream fis = new FileInputStream("D:\\Files\\Pictures\\1.jpg");
        
        Socket socket = new Socket("127.0.0.1", 9912);
        
        OutputStream os = socket.getOutputStream();
        
        int len = 0;
        byte[] bytes = new byte[1024];
        while ((len = fis.read(bytes)) != -1)
        {
            os.write(bytes, 0, len);
        }

        /*
            解决:上传完文件,给服务器写一个结束标记
            void shutdownOutput() 禁用此套接字的输出流。
            对于 TCP 套接字，任何以前写入的数据都将被发送，并且后跟 TCP 的正常连接终止序列。
         */
        socket.shutdownOutput();
        
        InputStream is = socket.getInputStream();
        
        while ((len = is.read(bytes)) != -1)
        {
            System.out.println(new String(bytes, 0, len));
        }
        
        fis.close();
        socket.close();
    }
}
