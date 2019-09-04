package chapter18;

import java.io.IOException;
import java.io.StringReader;

/**
 * @Description 内存输入，使用stringReader
 * ASCII中字符和数字有一一对应
 * 算法:字符9和int9互相转换
 * 1）int类型转char类型，将数字加一个‘0’，并强制类型转换为char即可。
 * 2）char类型装int类型，将字符减一个‘0’即可。
 * @Author yuki
 * @Date 2019/5/29 17:02
 * @Version 1.0
 **/
public class MemoryInput {
    public static void main(String[] args) throws IOException {
        StringReader reader=new StringReader(BufferedInputFile.read("D:\\test\\testXwj.txt"));
        int i ;
        while ((i= reader.read())!=-1){
            System.out.print((char) i);
        }
    }
}
