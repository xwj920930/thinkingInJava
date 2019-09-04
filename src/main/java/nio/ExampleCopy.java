package nio;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @Description buffer使用实例
 * @Author yuki
 * @Date 2019/6/5 9:28
 * @Version 1.0
 **/
public class ExampleCopy {
    public static void main(String[] args) throws IOException {
        RandomAccessFile fileIn=new RandomAccessFile("D:\\test\\access.txt","rw");
        RandomAccessFile fileOut=new RandomAccessFile("D:\\test\\access2.txt","rw");
        FileChannel channelIn = fileIn.getChannel();//通道
        FileChannel channelOut = fileOut.getChannel();//通道
        ByteBuffer buffer=ByteBuffer.allocate(48);//缓冲区
        int read = channelIn.read(buffer);//数据从通道读入缓冲
        while (read != -1){//通道是否读完
            buffer.flip();//反转缓冲区,将Buffer从写入模式切换到读取模式
            channelOut.write(buffer);
            buffer.clear();//清空，将Buffer从读取模式切换到写入模式
            read=channelIn.read(buffer);//下一次数据从通道读入缓冲
        }
        fileIn.close();
        fileOut.close();
    }
}
