package chapter18;

import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * @Description RandomAccessFile使用
 * @Author yuki
 * @Date 2019/5/29 14:52
 * @Version 1.0
 **/
public class RandomAccessFileTest {
    public static void write() throws IOException {
        RandomAccessFile file=new RandomAccessFile("D:\\test\\access.txt","rw");//覆盖写
        file.write("张三".getBytes());//内容变成张三
//        file.writeInt(1);
        file.write("李四".getBytes());//内容变成张三李四
//        file.writeInt(2);
        System.out.println("file.getFilePointer() = " + file.getFilePointer());
        //随机写，从固定指针开始写，一个中文字符占3个字节
        file.seek(3);
        file.write("王五".getBytes());//内容变成张李四五
        System.out.println("file.getFilePointer() = " + file.getFilePointer());
        file.close();
    }
    public static void read() throws IOException {
        RandomAccessFile file=new RandomAccessFile("D:\\test\\access.txt","r");//读
        String line = file.readLine();
        System.out.println("line = " + line);
        //随机读取，只要通过设置指针的位置即可。
        file.seek(3);
        byte[] buf = new byte[3];
        file.read(buf);//读入缓冲区
        String name = new String(buf);
        System.out.println(name);
        file.close();
    }
    public static void main(String[] args) throws IOException {
//        write();
        read();
    }
}
