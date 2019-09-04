package jdk7;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

/**
 * @Description 使用files读写文件,使用path处理路径,都属于nio
 * @Author yuki
 * @Date 2019/3/22 14:25
 * @Version 1.0
 **/
public class NewFiles {
    public static void main(String[] args) throws IOException {
        Path path= Paths.get("D:"+File.separator+"test"+ File.separator+"test1.txt");
        Path path2= Paths.get("D:"+File.separator+"test"+ File.separator+"testXwj.txt");
        Path path3= Paths.get("D:"+File.separator+"test"+ File.separator+"testXwj2.txt");
        List<String> strings=Files.readAllLines(path);
        for (String string : strings) {
            System.out.println(string);
        }
        BufferedReader reader=Files.newBufferedReader(path);
        BufferedWriter writer=Files.newBufferedWriter(path2);
        String line=null;
        while ((line=reader.readLine())!=null){
            writer.write(line);
            writer.newLine();
        }
        writer.flush();
        reader.close();
        writer.close();
        InputStream inputStream=Files.newInputStream(path);
        OutputStream outputStream=Files.newOutputStream(path3);
        byte[] bytes=new byte[1024];
        int len = 0;
        while ((len=inputStream.read(bytes))!=-1){
            outputStream.write(bytes,0,len);
        }
        outputStream.flush();
        inputStream.close();
        outputStream.close();
    }
}
