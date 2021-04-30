package JavaSE.BLS.IO;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

public class NIOFileCopy {

    public static void fileCopyByNIO(String resource,String destination) throws Exception{
        FileInputStream fileInputStream = new FileInputStream(resource);
        FileOutputStream fileOutputStream = new FileOutputStream(destination);

        FileChannel fileReadChannel = fileInputStream.getChannel();
        FileChannel fileWriteChannel = 	fileOutputStream.getChannel();

        ByteBuffer buffer = ByteBuffer.allocate(1024);
        buffer.clear();
        int len = 0;
        while((len=fileReadChannel.read(buffer))!=-1){
            buffer.flip();
            fileWriteChannel.write(buffer);
            buffer.clear();
        }

        fileReadChannel.close();
        fileWriteChannel.close();
    }


    public static void operFileMapped(String file) throws Exception{
        RandomAccessFile raf = new RandomAccessFile(file, "rw");
        FileChannel fc = raf.getChannel();
        MappedByteBuffer mbb = fc.map(FileChannel.MapMode.READ_WRITE, 0, raf.length());

        byte index0 =  mbb.get(0);
        System.out.println(index0);

        mbb.put(0,(byte)-119);
        raf.close();
    }



}
