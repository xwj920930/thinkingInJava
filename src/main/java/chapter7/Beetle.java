package chapter7;

/**
 * @Description 验证类的初始化顺序
 * 父类--静态变量,父类--静态初始化块
子类--静态变量,子类--静态初始化块
父类--变量,父类--初始化块,父类--构造器
子类--变量,子类--初始化块,子类--构造器
静态只初始化一次
方法调用才会运行
静态初始化甚至在main函数前面
 * @Author yuki
 * @Date 2018/12/20 19:19
 * @Version 1.0
 **/
class Inspect{
    private int i=9;
    protected int j;
    Inspect(){
        System.out.println("i ="+i+",j="+j);
        j=39;
    }
    private static int x1=printInit("static Inspect.x1 init");
    static int printInit(String s){
        System.out.println(s);
        return 47;
    }
}
public class Beetle extends Inspect{
    private int k=printInit("Beetle.k init");
    Beetle(){
        System.out.println("k="+k);
        System.out.println("j="+j);
    }
    private static int x2=printInit("static Beetle.x2 init");

    public static void main(String[] args) {
        System.out.println("beetle constructor");
        Beetle beetle=new Beetle();
    }
}
