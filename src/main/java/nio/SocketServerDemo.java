package nio;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Description java原生socket服务器
 * @Author yuki
 * @Date 2019/6/11 15:30
 * @Version 1.0
 **/
public class SocketServerDemo {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket=new ServerSocket(10086);//创建服务器
        Socket socket = serverSocket.accept();//监听，等待
        BufferedReader reader=new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String info;
        while ((info=reader.readLine())!=null){
            System.out.println("我是服务器，客户端说："+info);
        }
        socket.shutdownInput();//关闭输入流，千万不能忘记关闭输入输出流!!否则不会出结果!!
        PrintWriter writer=new PrintWriter(socket.getOutputStream());//输出流
        writer.println("欢迎您！");
        writer.flush();
        reader.close();
        writer.close();
        socket.close();
        serverSocket.close();
    }
}
