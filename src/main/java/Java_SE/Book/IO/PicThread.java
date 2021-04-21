package Java_SE.Book.IO;

import java.io.*;
import java.net.Socket;

/**
 * 多线程上传图片
 */
public class PicThread implements Runnable{
    private Socket s;
    PicThread(Socket s){
        this.s = s;
    }

    @Override
    public void run() {
        int count = 1;
        String ip = s.getInetAddress().getHostAddress();
        String path = "G:\\mine\\pic\\";
        try {
            InputStream in = s.getInputStream();
            File file = new File(path+ip+"("+(count)+")"+".jpg");
            while(file.exists()){
                file = new File(path+ip+"("+(count++)+")"+".jpg");
            }
            FileOutputStream fos = new FileOutputStream(file);
            byte []buf = new byte[1024];
            int len = 0;
            while((len = in.read(buf))!=-1){
                fos.write(buf,0,len);
            }
            OutputStream out = s.getOutputStream();
            out.write("上传成功".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
