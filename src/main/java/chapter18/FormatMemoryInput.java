package chapter18;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;

/**
 * @Description 格式化内存输入，使用DataInputStream处理字节
 * @Author yuki
 * @Date 2019/5/29 17:29
 * @Version 1.0
 **/
public class FormatMemoryInput {
    public static void main(String[] args) throws IOException {
        DataInputStream input=new DataInputStream(new ByteArrayInputStream(BufferedInputFile.read("D:\\test\\testXwj.txt").getBytes()));
        while (input.available()!=0){
            System.out.print((char) input.readByte());
        }
    }
}
