package chapter18;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * @Description 除了用策略模式外没啥意义
 * @Author yuki
 * @Date 2019/5/28 16:13
 * @Version 1.0
 **/
public class ProcessFiles {
    //策略模式接口
    public interface Strategy{void process(File file);}
    private Strategy strategy;
    private String ext;
    public ProcessFiles(Strategy strategy, String ext) throws FileNotFoundException {
        this.strategy = strategy;
        this.ext = ext;
    }
    public void start(String[] args) throws IOException {
        if (args.length==0){
            //条件为空时操作
            processDirectoryTree(new File("."));
        }else {
            for (String arg : args) {
                File file = new File(arg);
                //是否为文件夹
                if (file.isDirectory()){
                    processDirectoryTree(file);
                }else {
                    if (!arg.endsWith("."+ext)){
                        arg+="."+ext;
                    }
                    strategy.process(new File(arg).getCanonicalFile());
                }
            }
        }
    }
    public void processDirectoryTree(File root) throws IOException {
        for (File file : Directory.walk(root.getAbsolutePath(), ".*\\." + ext)) {
            strategy.process(file.getCanonicalFile());
        }
    }
    public static void main(String[] args) throws IOException {
        new ProcessFiles(new Strategy() {
            @Override
            public void process(File file) {
                System.out.println(file);
            }
        },"java").start(args);
    }
}
