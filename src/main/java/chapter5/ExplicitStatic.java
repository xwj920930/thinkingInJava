package chapter5;

/**
 * @Description 显式静态初始化
 * @Author yuki
 * @Date 2018/12/13 17:32
 * @Version 1.0
 **/
class Cup{
    Cup(int marker){
        System.out.println("cup("+marker+")");
    }
    void f(int marker){
        System.out.println("f("+marker+")");
    }
}
class Cups{
    static Cup cup1;
    static Cup cup2;
    static {
        cup1=new Cup(1);
        cup2=new Cup(2);
    }
    Cups(){
        System.out.println("cups()");
    }
}
public class ExplicitStatic {
    public static void main(String[] args) {
        System.out.println("inside main()");
        Cups.cup1.f(99);
    }
}
