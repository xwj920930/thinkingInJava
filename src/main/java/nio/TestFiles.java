package nio;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

/**
 * files处理文件
 * 更多方法参考本工程jdk7\NewFiles.java
 */
public class TestFiles {
    public static void main(String[] args) throws IOException {
        Path path = Paths.get("D:\\test\\A\\test.txt");
        System.out.println(Files.exists(path));//是否存在
        Path path1 = Paths.get("D:\\test\\A\\create");
//        Files.createDirectory(path1);//创建文件夹
        Path path2 = Paths.get("D:\\test\\A\\test2.txt");
//        Files.copy(path,path2, StandardCopyOption.REPLACE_EXISTING);//强制复制
        Path path3 = Paths.get("D:\\test\\A\\create\\newTest2.txt");
//        Files.move(path2,path3);//移动文件并改名
//        Files.delete(path3);//删除文件
        Path rootPath = Paths.get("D:\\test");
        Files.walkFileTree(rootPath,new SimpleFileVisitor<Path>(){//递归遍历,找到一个后缀为md文件
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                String path=file.toAbsolutePath().toString();
                if (path.endsWith(".md")){
                    System.out.println(path);
                    return FileVisitResult.TERMINATE;
                }
                return FileVisitResult.CONTINUE;
            }
        });
//        Files.delete()方法仅删除目录为空的目录。通过遍历所有目录并删除每个目录中的所有文件
//        （在visitFile( )内），然后删除目录本身（在postVisitDirectory( )内），可以删除包含所有
//        子目录和文件的目录
        Path deletePath = Paths.get("D:\\test\\B");//把B都删除了==
        Files.walkFileTree(deletePath,new SimpleFileVisitor<Path>(){//删除文件夹内所有文件和文件夹
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                Files.delete(file);
                return FileVisitResult.CONTINUE;
            }
            @Override
            public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
                Files.delete(dir);
                return FileVisitResult.CONTINUE;
            }
        });
    }
}