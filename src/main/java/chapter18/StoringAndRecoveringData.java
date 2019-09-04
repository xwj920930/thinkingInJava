package chapter18;

import java.io.*;

/**
 * @Description 存储和恢复数据，使用dataInputStream和dataOutputStream
 * 适用范围不如序列化对象
 * @Author yuki
 * @Date 2019/5/30 10:48
 * @Version 1.0
 **/
public class StoringAndRecoveringData {
    public static void main(String[] args) throws IOException {
        DataOutputStream out=new DataOutputStream(new BufferedOutputStream(new FileOutputStream("D:\\test\\data.txt")));
        out.writeDouble(3.14159);
        out.writeUTF("这是pi");
        out.close();
        DataInputStream in=new DataInputStream(new BufferedInputStream(new FileInputStream("D:\\test\\data.txt")));
        System.out.println(in.readDouble());
        System.out.println(in.readUTF());
    }
}
