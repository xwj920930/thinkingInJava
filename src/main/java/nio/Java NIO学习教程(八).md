一：Files(用于替换老版本的file)
1.Files.exists()是否存在

2.Files.createDirectory()创建目录

3.Files.copy()复制文件

4.Files.move()移动文件

5.Files.delete()删除文件和文件夹(仅删除目录为空的文件夹)

6.Files.walkFileTree()
递归遍历目录树的功能。walkFileTree()方法采用Path实例和FileVisitoras作为参数。Path实例指向要
遍历的目录。在遍历期间调用FileVisitor。
6.1FileVisitor接口：
Files.walkFileTree(path, new FileVisitor<Path>() {
@Override
public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
  System.out.println("pre visit dir:" + dir);
  return FileVisitResult.CONTINUE;
}
@Override
public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
  System.out.println("visit file: " + file);
  return FileVisitResult.CONTINUE;
}
@Override
public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
  System.out.println("visit file failed: " + file);
  return FileVisitResult.CONTINUE;
}
@Override
public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
  System.out.println("post visit directory: " + dir);
  return FileVisitResult.CONTINUE;
}
});
如果你不需要挂钩所有这些方法，则可以扩展
SimpleFileVisitor该类，该类包含FileVisitor接口中所有方法的默认实现。
在访问任何目录之前调用previsitDirectory( )方法。只在访问目录后调用postVisitDirectory( )方法。
对于在文件浏览期间访问的每个文件，都会调用visitfile( )方法。它不是为目录调用的——只对文件。
如果访问文件失败，则调用visitFileFailed( )方法。
四种方法中的每一种都返回一个FileVisitResult枚举实例。FileVisitResult枚举包含以下四个选项：
CONTINUE 表示文件遍历应该正常继续。
TERMINATE 意味着文件遍历现在应该终止。
SKIP_SIBLINGS 表示文件遍历应该继续但不访问此文件或目录的任何兄弟。
SKIP_SUBTREE 表示文件遍历应该继续但不访问此目录中的条目,只有从previsitDirectory( )返回时，
此值才具有函数。如果从任何其他方法返回，它将被解释为continue。

7.实例：TestFiles.java