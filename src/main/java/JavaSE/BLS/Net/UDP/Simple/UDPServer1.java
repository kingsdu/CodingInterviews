package JavaSE.BLS.Net.UDP.Simple;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class UDPServer1
{
    
    public static void main(String[] args)
    {
        UDPPartern_receive();
    }
    
    public static void UDPPartern_receive(){
        try {
            //1 创建UDP服务.通过DatagramSocket对象
            DatagramSocket ds = new DatagramSocket(1234);
            //2 确定数据，并将其封装为数据包
            byte[] buf = new byte[1024];
            DatagramPacket dp = new DatagramPacket(buf,buf.length);
            //3 接受数据，阻塞方法
            ds.receive(dp);
            System.out.println("addressName "+dp.getAddress().getHostAddress());
            String data = new String(dp.getData(),0,dp.getLength());
            System.out.println("data "+data);
            //4 关闭资源
            ds.close();
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
