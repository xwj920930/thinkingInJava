package chapter5;

/**
 * @Description 完整版类的初始化顺序
 * 类的初始化顺序：
父类--静态变量,父类--静态初始化块
子类--静态变量,子类--静态初始化块
父类--变量,父类--初始化块,父类--构造器
子类--变量,子类--初始化块,子类--构造器
静态只初始化一次
 * @Author yuki
 * @Date 2018/12/12 19:22
 * @Version 1.0
 **/
class Print{
    Print(String s){
        System.out.println("init "+s);
    }
}
class Father{
    static Print print1=new Print("father static variable");
    Print print2=new Print("father variable");
    static {
        Print print3=new Print("father static block");
    }
    {
        Print print4=new Print("father block");
    }
    Father(){
        Print print5=new Print("father constructor");
    }
}
class Son extends Father{
    static Print print1=new Print("son static variable");
    Print print2=new Print("son variable");
    static {
        Print print3=new Print("son static block");
    }
    {
        Print print4=new Print("son block");
    }
    Son(){
        Print print5=new Print("son constructor");
    }
}
public class OrderOfInit2 {
    public static void main(String[] args) {
//        Father father=new Father();
        Son son=new Son();
//        new Son();
    }
}
