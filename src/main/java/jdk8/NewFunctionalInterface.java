package jdk8;

/**
 * @Description 函数式接口，有且仅有一个抽象方法，Object的public方法除外,
 * 可以有default方法
 * 可以用来转换为lambda表达式
 * FunctionalInterface注解可有可无
 * @Author yuki
 * @Date 2019/3/22 20:29
 * @Version 1.0
 **/
@FunctionalInterface
public interface NewFunctionalInterface {
    void function();
    default void f(){};
    boolean equals(Object o);
}
class A{
    public static void main(String[] args) {
        NewFunctionalInterface anInterface=new NewFunctionalInterface() {
            @Override
            public void function() {
            }
            @Override
            public void f() {
            }
        };
    }
}
