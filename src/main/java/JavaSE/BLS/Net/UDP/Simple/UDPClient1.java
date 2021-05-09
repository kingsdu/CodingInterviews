package JavaSE.BLS.Net.UDP.Simple;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class UDPClient1
{
    
    public static void main(String[] args)
    {
        UDPPartern_send();
    }
    
    
    public static void UDPPartern_send(){
        try {
            //1 创建UDP服务.通过DatagramSocket对象
            DatagramSocket ds = new DatagramSocket();
            //2 确定数据，并将其封装为数据包
            byte[] buf = "udp ge men lai le".getBytes();
            //将数据发送到本机地址上1234端口
            DatagramPacket dp = new DatagramPacket(buf,buf.length,InetAddress.getByName(InetAddress.getLocalHost().getHostAddress()),1234);
            //3 发送数据
            ds.send(dp);
            //4 关闭资源
            ds.close();
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
