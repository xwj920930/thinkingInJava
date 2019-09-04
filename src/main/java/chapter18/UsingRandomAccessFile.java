package chapter18;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * @Description 随机访问文件，使用RandomAccessFile
 * 输出的为乱码，与普通的writer不一样且不能被buffered装饰
 * @Author yuki
 * @Date 2019/5/30 11:13
 * @Version 1.0
 **/
public class UsingRandomAccessFile {
    static final String FILE_PATH="D:\\test\\access.txt";
    static void display() throws IOException {
        RandomAccessFile file=new RandomAccessFile(FILE_PATH,"r");
        for (int i = 0; i < 7; i++) {
            System.out.println("value " + i + " :" + file.readDouble());
        }
        System.out.println(file.readUTF());
        file.close();
    }
    public static void main(String[] args) throws IOException {
        RandomAccessFile file=new RandomAccessFile(FILE_PATH,"rw");
        for (int i = 0; i < 7; i++) {
            file.writeDouble(i*1.414);
        }
        file.writeUTF("END");
        file.close();
        display();
        file=new RandomAccessFile(FILE_PATH,"rw");
        file.seek(8*5);//double为8字节，此处从第6个字节开始修改
        file.writeDouble(47.0001);
        file.close();
        display();
    }
}
