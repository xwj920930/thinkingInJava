package nio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * @Description java原生socket客户端
 * @Author yuki
 * @Date 2019/6/11 15:30
 * @Version 1.0
 **/
public class SocketClientDemo {
    public static void main(String[] args) throws IOException {
        Socket socket=new Socket("localhost",10086);//创建客户端，连接服务器
        PrintWriter writer=new PrintWriter(socket.getOutputStream());//输出流
        writer.println("用户admin");
        writer.flush();
        socket.shutdownOutput();//关闭输出流，千万不能忘记关闭输入输出流!!否则不会出结果!!
        BufferedReader reader=new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String info;
        while((info=reader.readLine())!=null){
            System.out.println("我是客户端，服务器说："+info);
        }
        writer.close();
        reader.close();
        socket.close();
    }
}
