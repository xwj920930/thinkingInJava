package chapter18;

import java.io.File;
import java.io.FilenameFilter;
import java.nio.file.Files;
import java.util.Arrays;

/**
 * @Description file类使用filter可以过滤特定的文件后缀
 * @Author yuki
 * @Date 2019/5/27 17:03
 * @Version 1.0
 **/
public class DirList {
    public static void main(String[] args) {
        File file=new File("D:\\资料\\工作");
        //返回文件名称
        String[] list = file.list();
        assert list != null;
        Arrays.stream(list).forEach(System.out::println);
        String[] list1 = file.list(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return name.endsWith(".txt");
            }
        });
        Arrays.stream(list1).forEach(System.err::println);
    }
}
