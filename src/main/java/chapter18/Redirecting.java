package chapter18;

import java.io.*;

/**
 * @Description 重定向,System.setIn(in):System.In变成in
 * @Author yuki
 * @Date 2019/5/30 16:33
 * @Version 1.0
 **/
public class Redirecting {
    public static void main(String[] args) throws IOException {
        PrintStream console=System.out;//暂存system.out
        BufferedInputStream in=new BufferedInputStream(new FileInputStream("D:\\test\\testXwj.txt"));
        PrintStream out=new PrintStream(new BufferedOutputStream(new FileOutputStream("D:\\test\\out.txt")));
        System.setIn(in);//system.in替换为in
        System.setOut(out);//如上
        System.setErr(out);//如上
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));//此时的system.in是in
        String s;
        while ((s=br.readLine())!=null){
            System.out.println(s);//此时的system.out是printWriter，所以不会打印到控制台
        }
        out.close();
        System.setOut(console);//还原system.out，程序中断自动还原
    }
}
