package JavaSE.BLS.Net.UDP.ChatThread;

import java.net.DatagramSocket;
import java.net.SocketException;

public class UPDUserMain
{
    public static void main(String[] args) throws SocketException
    {
        DatagramSocket send = new DatagramSocket();
        DatagramSocket rece = new DatagramSocket(12002);
        
        new Thread(new UDPSender(send)).start();
        new Thread(new UDPReceiver(rece)).start();
    }
}
