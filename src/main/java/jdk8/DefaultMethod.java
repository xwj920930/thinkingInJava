package jdk8;

/**
 * @Description 默认方法和静态方法
 * 静态方法，只能通过接口名调用
 * default方法，只能通过接口实现类的对象来调用
 * 如果有两个接口中的静态方法一模一样，并且一个实现类同时实现了这两个接口，
 * 此时并不会产生错误，因为jdk8只能通过接口类调用接口中的静态方法，
 * 所以对编译器来说是可以区分的。但是如果两个接口中定义了一模一样的默认方法，
 * 并且一个实现类同时实现了这两个接口，那么必须在实现类中重写默认方法，否则编译失败
 * @Author yuki
 * @Date 2019/3/22 20:57
 * @Version 1.0
 **/
interface JDK8Interface{
    static void staticMethod(){
    }
    default void defaultMethod(){
    }
}
public class DefaultMethod implements JDK8Interface {
    //因为默认方法不是抽象方法，所以可以不重写
//    @Override
//    public void defaultMethod() {
//    }
    public static void main(String[] args) {
        JDK8Interface.staticMethod();
        new DefaultMethod().defaultMethod();
    }
}
