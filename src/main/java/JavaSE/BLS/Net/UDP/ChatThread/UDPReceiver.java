package JavaSE.BLS.Net.UDP.ChatThread;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class UDPReceiver implements Runnable
{
    //UDP专用Socket
    private DatagramSocket ds;
    
    public UDPReceiver(DatagramSocket ds)
    {
        this.ds = ds;
    }
    
    
    @Override
    public void run()
    {
        while (true)
        {
            try
            {
                //2 确定数据，并将其封装为数据包
                byte[] buf = new byte[1024];
                DatagramPacket dp = new DatagramPacket(buf, buf.length);
                //3 接受数据
                ds.receive(dp);
                System.out.println("addressName:  " + dp.getAddress().getHostAddress());
                String data = new String(dp.getData(), 0, dp.getLength());
                System.out.println("data:  " + data);
                //注意最后不能关闭。如果一端的Socket被关闭（或主动关闭或者因为异常退出而引起的关闭），另一端仍发送数据，会导致异常
            } catch (SocketException e)
            {
                e.printStackTrace();
            } catch (IOException e)
            {
                e.printStackTrace();
            }
        }
    }
}
