package nio;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousFileChannel;
import java.nio.channels.CompletionHandler;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * @Description 测试异步AsynchronousFileChannel
 * 使用CompletionHandler
 * @Author yuki
 * @Date 2019/6/14 10:57
 * @Version 1.0
 **/
public class TestAsynchronousFileChannel2 {
    public static void main(String[] args) throws IOException, InterruptedException {
        //读
        Path pathIn = Paths.get("D:\\test\\access.txt");
        //创建channel，第二个参数设置读
        AsynchronousFileChannel fileChannelIn=AsynchronousFileChannel.open(pathIn, StandardOpenOption.READ);
        ByteBuffer bufferIn = ByteBuffer.allocate(1024);//空间小了不行，要求内容全放下，因为只操作一次==
        //异步，不知道何时完成操作
        fileChannelIn.read(bufferIn, 0, bufferIn, new CompletionHandler<Integer, ByteBuffer>() {
            @Override
            public void completed(Integer result, ByteBuffer attachment) {
                System.out.println("result = " + result);//文件的字符数
                attachment.flip();
                System.out.println(new String(attachment.array()));//此处attachment和buffer一样
                attachment.clear();
            }
            @Override
            public void failed(Throwable exc, ByteBuffer attachment) {
            }
        });
        TimeUnit.SECONDS.sleep(1);//此处不等待不会看到结果
        bufferIn.flip();
        System.out.println(new String(bufferIn.array()));
        bufferIn.clear();
        //写
        Path pathOut = Paths.get("D:\\test\\accessOut.txt");
        AsynchronousFileChannel fileChannelOut=AsynchronousFileChannel.open(pathOut, StandardOpenOption.WRITE);
        ByteBuffer bufferOut =ByteBuffer.wrap("test".getBytes());
        fileChannelOut.write(bufferOut, 0, null, new CompletionHandler<Integer, ByteBuffer>() {
            @Override
            public void completed(Integer result, ByteBuffer attachment) {
                System.out.println("result = " + result);
            }
            @Override
            public void failed(Throwable exc, ByteBuffer attachment) {
            }
        });
        TimeUnit.SECONDS.sleep(1);
        System.out.println("bufferOut = " + new String(bufferOut.array()));
        bufferOut.clear();
    }
}
