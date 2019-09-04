package chapter18;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @Description system.in
 * @Author yuki
 * @Date 2019/5/30 16:23
 * @Version 1.0
 **/
public class Echo {
    public static void main(String[] args) throws IOException {
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        String s;
        while ((s=reader.readLine())!=null){
            System.out.println(s);
        }
    }
}
