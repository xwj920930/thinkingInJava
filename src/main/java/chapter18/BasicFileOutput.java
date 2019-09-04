package chapter18;

import java.io.*;

/**
 * @Description 基本文件输出，使用printWriter格式输出
 * printWriter比bufferedWriter多了文件输出的format方法
 * @Author yuki
 * @Date 2019/5/30 9:53
 * @Version 1.0
 **/
public class BasicFileOutput {
    public static void main(String[] args) throws IOException {
        BufferedReader in=new BufferedReader(new FileReader("D:\\test\\testXwj.txt"));
        PrintWriter out=new PrintWriter(new BufferedWriter(new FileWriter("D:\\test\\testXwj3.txt")));
        int lineCount=1;
        String s ;
        while ((s= in.readLine())!=null){
            System.out.println(lineCount++ +":" + s);
            out.println(s);//相当于bufferedWriter.write()+newLine()
        }
        in.close();
        out.close();
    }
}
