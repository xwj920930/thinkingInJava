package jdk7;

import java.io.*;

/**
 * @Description try-with-resource
 * jdk中实现了AutoCloseable接口的类，在该类对象销毁时自动关闭资源(例如inputStream)
 * 自己写的类要实现AutoCloseable接口，重写close
 * @Author yuki
 * @Date 2019/3/22 9:34
 * @Version 1.0
 **/
public class TryWithResource implements AutoCloseable {
    public static void main(String[] args) throws IOException {
        InputStream inputStream = null;
        try {
            inputStream=new FileInputStream(new File(""));
        } catch (FileNotFoundException e) {
        }finally {
            //不用显示关闭
//            inputStream.close();
        }

    }
    @Override
    public void close() throws Exception {
//        synchronized (lock) {
//            if (in == null)
//                return;
//            try {
//                in.close();
//            } finally {
//                in = null;
//                cb = null;
//            }
//        }
    }
}
