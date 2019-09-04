package nio;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousFileChannel;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.concurrent.Future;

/**
 * @Description 测试异步AsynchronousFileChannel
 * 使用future
 * @Author yuki
 * @Date 2019/6/14 10:57
 * @Version 1.0
 **/
public class TestAsynchronousFileChannel1 {
    public static void main(String[] args) throws IOException {
        //读
        Path pathIn = Paths.get("D:\\test\\access.txt");
        //创建channel，第二个参数设置读
        AsynchronousFileChannel fileChannelIn=AsynchronousFileChannel.open(pathIn, StandardOpenOption.READ);
        ByteBuffer bufferIn = ByteBuffer.allocate(1024);//空间小了不行，要求内容全放下，因为只操作一次==
        Future<Integer> read = fileChannelIn.read(bufferIn, 0);
        while (!read.isDone());//效率低但是不得不做
        bufferIn.flip();
        System.out.println(new String(bufferIn.array()));
        bufferIn.clear();
        //写
        Path pathOut = Paths.get("D:\\test\\accessOut.txt");
        AsynchronousFileChannel fileChannelOut=AsynchronousFileChannel.open(pathOut, StandardOpenOption.WRITE);
//        ByteBuffer bufferOut = ByteBuffer.allocate(1024);//空间小了不行，要求内容全放下，因为只操作一次==
//        bufferOut.put("test".getBytes());
//        bufferOut.flip();
        ByteBuffer bufferOut =ByteBuffer.wrap("test".getBytes());
        Future<Integer> write = fileChannelOut.write(bufferOut,0);
        bufferOut.clear();
        while (!write.isDone());
        System.out.println("end write");
    }
}
