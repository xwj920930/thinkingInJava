package chapter5;

/**
 * @Description 系统自带默认构造器，如果写了其他构造器，默认的就会失效
 * @Author yuki
 * @Date 2018/12/11 19:04
 * @Version 1.0
 **/
public class DefaultConstruct {
    public static void main(String[] args) {
        new A();
//        new B();
    }
    static class A{
    }
    static class B{
        B(int i){
        }
    }
}
