package nio;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.Scanner;

/**
 * @Description 使用实例：write
 * @Author yuki
 * @Date 2019/6/5 9:28
 * @Version 1.0
 **/
public class ExampleWrite {
    public static void main(String[] args) throws IOException {
        Scanner scanner=new Scanner(System.in);
        RandomAccessFile fileOut=new RandomAccessFile("D:\\test\\access1.txt","rw");
        FileChannel channelOut = fileOut.getChannel();//通道
        ByteBuffer buffer=ByteBuffer.allocate(48);//缓冲区
        String str;
        while (!(str=scanner.next()).equals("end")){
            buffer.put((str+"\r\n").getBytes());//写入缓冲
            buffer.flip();//反转缓冲区,将Buffer从写入模式切换到读取模式
            channelOut.write(buffer);
            buffer.clear();//清空，将Buffer从读取模式切换到写入模式
        }
        fileOut.close();
    }
}
