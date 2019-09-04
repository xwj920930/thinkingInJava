package chapter5;

/**
 * @Description 静态方法不能调用非静态成员/方法，
 * 反之非静态方法可以调用静态成员/方法
 * @Author yuki
 * @Date 2018/12/11 19:39
 * @Version 1.0
 **/
public class StaticMethod {
    static String s;
    String b;
    void get1(){
        s="";
        b="";
        get2();
    }
    static void get2(){
        s="";
//        b="";
//        get1();
    }
}
