package chapter5;

/**
 * @Description 非静态初始化
 * @Author yuki
 * @Date 2018/12/14 9:48
 * @Version 1.0
 **/
class Mug{
    Mug(int marker){
        System.out.println("Mug("+marker+")");
    }
    void f(int marker){
        System.out.println("f("+marker+")");
    }
}
public class NotStaticInitialization {
    Mug mug1;
    Mug mug2;
    {
        mug1=new Mug(1);
        mug2=new Mug(2);
        System.out.println("mug1 mug2 init");
    }
    NotStaticInitialization(){
        System.out.println("mugs()");
    }
    NotStaticInitialization(int marker){
        System.out.println("mugs(int)");
    }

    public static void main(String[] args) {
        System.out.println("inside main");
        new NotStaticInitialization();
        System.out.println("new mugs() complete");
        new NotStaticInitialization(1);
        System.out.println("new mugs(i) complete");
    }
}
