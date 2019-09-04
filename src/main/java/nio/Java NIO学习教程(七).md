一：Path(用于替换老版本的file路径)
1.创建绝对路径
Path path = Paths.get("D:\\test\\A\\test.txt")
Path path = Paths.get("D:\\test\\A","test.txt")//拼接

2.创建相对路径(.代表同级目录..代表父目录)
Path path2=Paths.get(".");
Path path3=Paths.get("D:\\test\\A","..\\test.txt");

3.normalize(规范化路径)
String originalPath = "d:\\data\\projects\\a-project\\..\\another-project";
Path path1 = Paths.get(originalPath);
Path path2 = path1.normalize();
去除\.\..符号：
path1 = d:\data\projects\a-project\..\another-project
path2 = d:\data\projects\another-project