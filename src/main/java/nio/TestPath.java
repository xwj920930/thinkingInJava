package nio;

import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * path处理路径
 */
public class TestPath {
    public static void main(String[] args){
        Path path = Paths.get("D:\\test\\A\\test.txt");
        System.out.println(path.toAbsolutePath());
        Path path1=Paths.get("D:\\test\\A","test.txt");//拼接
        System.out.println(path1.toAbsolutePath());
        Path path2=Paths.get(".");//同级目录
        System.out.println(path2.toAbsolutePath());
        Path path3=Paths.get("D:\\test\\A","..\\test.txt");//父目录
        System.out.println(path3.toAbsolutePath().normalize());//规范化路径
    }
}