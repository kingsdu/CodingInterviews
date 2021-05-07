package JavaSE.BLS.NIO;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class TCPClient {

    public static void main(String[] args) {
        try {
            //1 建立socket服务。指定要连接的主机端口
            Socket s = new Socket("192.168.0.116",10001);
            //2 获取socket流中的输出流。将数据写到该流中。通过网络发给服务端
            OutputStream out = s.getOutputStream();
            out.write("hello server".getBytes());
            //3 获取socket中的输入流，将服务端反馈的数据获取到，并打印
            InputStream in = s.getInputStream();
            byte[] buf = new byte[1024];
            //阻塞式方法，接受服务端返回数据
            int len = in.read(buf);
            System.out.println(new String(buf,0,len));
            s.close();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
