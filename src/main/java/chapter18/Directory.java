package chapter18;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @Description 自定义目录工具
 * 运用递归统计文件夹内的文件和文件夹
 * @Author yuki
 * @Date 2019/5/27 17:30
 * @Version 1.0
 **/
public final class Directory {
    public static File[] local(File dir,final String regex){
        //返回文件本身
        return dir.listFiles((dir1, name) -> name.endsWith(regex));
    }
    public static File[] local(String path,final String regex){
        return local(new File(path),regex);
    }
//    静态类一定是内部类；
    public static class TreeInfo implements Iterable<File>{
        public List<File> files=new ArrayList<>();//存储后缀为txt的文件
        public List<File> dirs=new ArrayList<>();//存储所有的文件夹
        @Override
        public Iterator<File> iterator() {
            return files.iterator();
        }
        void addAll(TreeInfo other){
            files.addAll(other.files);
            dirs.addAll(other.dirs);
        }
    }
    //递归遍历文件夹
    static TreeInfo recurseDirs(File startDir,String regex){
        TreeInfo result=new TreeInfo();
        for (File item : startDir.listFiles()) {
            if (item.isDirectory()){
                result.dirs.add(item);
                result.addAll(recurseDirs(item,regex));
            }else {
                if (item.getName().endsWith(regex))
                    result.files.add(item);
            }
        }
        return result;
    }
    public static TreeInfo walk(String start,String regex){
        return recurseDirs(new File(start),regex);
    }
    public static TreeInfo walk(File start,String regex){
        return recurseDirs(start,regex);
    }
    public static void main(String[] args) {
        TreeInfo treeInfo = walk("D:\\test\\B", "txt");
        System.out.println("treeInfo.files = " + treeInfo.files);
        System.out.println("treeInfo.dirs = " + treeInfo.dirs);
    }
}
