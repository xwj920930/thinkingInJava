package chapter18;

import java.io.*;

/**
 * @Description 自定义工具，读取二进制文件
 * @Author yuki
 * @Date 2019/5/30 15:38
 * @Version 1.0
 **/
public class BinaryFile {
    private static void read(File file) throws IOException {
        BufferedInputStream in=new BufferedInputStream(new FileInputStream(file));
        byte[] bytes=new byte[in.available()];//1024亦可
        int len;
        while ((len=in.read(bytes))!=-1){
            System.out.println(new String(bytes));
        }
        in.close();
    }
    private static void read(String file) throws IOException{
        read(new File(file).getAbsoluteFile());
    }
    public static void main(String[] args) throws IOException {
        read("D:\\test\\testXwj.txt");
    }
}
