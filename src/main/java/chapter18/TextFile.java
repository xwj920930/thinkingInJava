package chapter18;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.TreeSet;

/**
 * @Description 自定义工具类，文件读写推荐写法
 * 文件为a b c de/nf/n
 * @Author yuki
 * @Date 2019/5/30 14:47
 * @Version 1.0
 **/
public class TextFile extends ArrayList<String>{
    public TextFile(String fileName,String splitter) throws IOException {
        //arrayList构造器，作用就是赋初值setElement
        super(Arrays.asList(read(fileName).split(splitter)));
        if (get(0).equals(""))
            remove(0);
    }
    //array构造器，存储为["a b c de","f"]
    public TextFile(String fileName) throws IOException {
        this(fileName,"\n");
    }
    public static String read(String fileName) throws IOException {
        StringBuilder builder=new StringBuilder();
        BufferedReader reader=new BufferedReader(new FileReader(new File(fileName).getAbsoluteFile()));
        String s;
        while ((s=reader.readLine())!=null){
            builder.append(s).append("\n");
        }
        reader.close();
        return builder.toString();
    }
    public static void write(String fileName,String text) throws FileNotFoundException {
        PrintWriter writer=new PrintWriter(new File(fileName).getAbsoluteFile());
        writer.print(text);
        writer.close();
    }
    public void write(String fileName) throws FileNotFoundException {
        PrintWriter writer=new PrintWriter(new File(fileName).getAbsoluteFile());
        //this代表构造后的对象，["a b c de","f"]
        for (String s : this) {
            writer.println(s);
        }
        writer.close();
    }
    public static void main(String[] args) throws IOException {
        String file=read("D:\\test\\testXwj.txt");//a b c de/nf/n
        write("D:\\test\\testXwj5.txt",file);
        TextFile textFile=new TextFile("D:\\test\\testXwj.txt");//textFile=["a b c de","f"]
        textFile.write("D:\\test\\testXwj6.txt");
        //因为继承了arrayList
        TreeSet<String> words=new TreeSet<>(new TextFile("D:\\test\\testXwj.txt"));
        System.out.println(words.headSet("b"));
    }
}
