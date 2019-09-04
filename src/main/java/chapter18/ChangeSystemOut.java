package chapter18;

import java.io.PrintWriter;

/**
 * @Description system.out封装成printWriter
 * @Author yuki
 * @Date 2019/5/30 16:28
 * @Version 1.0
 **/
public class ChangeSystemOut {
    public static void main(String[] args) {
        PrintWriter writer=new PrintWriter(System.out,true);//是否flush
        writer.println("hello");
    }
}
