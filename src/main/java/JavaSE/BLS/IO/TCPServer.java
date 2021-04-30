package JavaSE.BLS.IO;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer {

    public static void main(String[] args) {
            try {
                ServerSocket ss = new ServerSocket(10001);
                //阻塞式方法，接受客户端输入数据
                Socket s = ss.accept();
                String ip = s.getInetAddress().getHostAddress();
                System.out.println(ip+"......conntected");
                //读取客户端发送数据
                InputStream in = s.getInputStream();
                byte[] buf = new byte[1024];
                int len = in.read(buf);
                System.out.println(new String(buf,0,len));
                //接收完毕之后，从服务端返回输出语句
                OutputStream out = s.getOutputStream();
                out.write("hello you too client".getBytes());
                s.close();
                ss.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
    }
}
