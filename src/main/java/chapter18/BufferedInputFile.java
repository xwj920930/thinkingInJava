package chapter18;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * @Description 缓冲输入文件，使用bufferedReader
 * @Author yuki
 * @Date 2019/5/29 16:51
 * @Version 1.0
 **/
public class BufferedInputFile {
    public static String read(String file) throws IOException {
        BufferedReader reader=new BufferedReader(new FileReader(file));
        StringBuilder builder=new StringBuilder();
        String s;
        while ((s=reader.readLine())!=null){
            builder.append(s).append("\n");
        }
        reader.close();
        return builder.toString();
    }
    public static void main(String[] args) throws IOException {
        System.out.println(read("D:\\test\\testXwj.txt"));
    }
}
