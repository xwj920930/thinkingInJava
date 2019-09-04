package nio;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @Description 使用实例：read
 * @Author yuki
 * @Date 2019/6/5 9:28
 * @Version 1.0
 **/
public class ExampleRead {
    public static void main(String[] args) throws IOException {
        RandomAccessFile fileIn=new RandomAccessFile("D:\\test\\access.txt","r");
        FileChannel channelIn = fileIn.getChannel();//通道
        ByteBuffer buffer=ByteBuffer.allocate(48);//缓冲区
        int read = channelIn.read(buffer);//数据从通道读入缓冲
        while (read != -1){//通道是否读完
            buffer.flip();//反转缓冲区,将Buffer从写入模式切换到读取模式
            while (buffer.hasRemaining()){//缓冲区是否读完
                System.out.print((char) buffer.get());//读取一个字节
            }
            buffer.clear();//清空，准备下次读入，将Buffer从读取模式切换到写入模式
            read=channelIn.read(buffer);//下一次数据从通道读入缓冲
        }
        fileIn.close();
    }
}
