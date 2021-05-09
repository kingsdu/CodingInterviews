package JavaSE.BLS.Net.BSTCP;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * Web文件夹下的地址找不到，所以访问不成功，但是思路我我已经理解了
 *
 */
public class TCPServer3
{
    public static void main(String[] args) throws IOException
    {
        ServerSocket server = new ServerSocket(8080);
        Socket socket = server.accept();
        InputStream is = socket.getInputStream();
        
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        //把客户端请求信息的第一行读取出来 GET /11_Net/web/index.html HTTP/1.1，这个就是服务器文件的地址，客户端可以访问
        String line = br.readLine();
        //把读取的信息进行切割,只要中间部分 /11_Net/web/index.html
        String[] arr = line.split(" ");
        //把路径前边的/去掉,进行截取 11_Net/web/index.html
        String htmlpath = arr[1].substring(1);
        
        FileInputStream fis = new FileInputStream(htmlpath);
        OutputStream os = socket.getOutputStream();
        
        // 写入HTTP协议响应头,固定写法
        os.write("HTTP/1.1 200 OK\r\n".getBytes());
        os.write("Content-Type:text/html\r\n".getBytes());
        // 必须要写入空行,否则浏览器不解析
        os.write("\r\n".getBytes());
        
        //一读一写复制文件,把服务读取的html文件回写到客户端
        int len = 0;
        byte[] bytes = new byte[1024];
        while ((len = fis.read(bytes)) != -1)
        {
            os.write(bytes, 0, len);
        }
        
        //释放资源
        fis.close();
        socket.close();
        server.close();
    }
}
