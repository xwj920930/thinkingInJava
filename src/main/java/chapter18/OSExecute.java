package chapter18;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @Description 流程控制
 * processBuilder和runtime类似，只是传参不同，ProcessBuilder为进程提供了更多的控制，
 * runtime内部使用processBuilder，推荐使用processBuilder
 * 使用：ProcessBuilder.start() 和 Runtime.exec()
 * @Author yuki
 * @Date 2019/5/30 17:12
 * @Version 1.0
 **/
public class OSExecute {
    public static void command() throws IOException {
//        Process runtime = Runtime.getRuntime().exec("ipconfig");
        Process runtime = new ProcessBuilder("ipconfig").start();
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(runtime.getInputStream()));
            BufferedReader errors = new BufferedReader(new InputStreamReader(runtime.getErrorStream()));
            String s;
            while ((s=br.readLine())!=null) {
                System.out.println(s);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) throws IOException {
        command();
    }
}
