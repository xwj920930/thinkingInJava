package nio;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @Description channel.transferFrom/transferTo使用实例
 * 通道间传输数据，不经过buffer
 * @Author yuki
 * @Date 2019/6/5 9:28
 * @Version 1.0
 **/
public class ExampleTransfer {
    public static void main(String[] args) throws IOException {
        RandomAccessFile fileIn=new RandomAccessFile("D:\\test\\access.txt","rw");
        RandomAccessFile fileOut=new RandomAccessFile("D:\\test\\access2.txt","rw");
        FileChannel channelIn = fileIn.getChannel();
        FileChannel channelOut = fileOut.getChannel();
        long position=0;
        long size=channelIn.size();
        channelIn.transferTo(position,size,channelOut);
//        channelOut.transferFrom(channelIn,position,size);
        fileIn.close();
        fileOut.close();
    }
}
