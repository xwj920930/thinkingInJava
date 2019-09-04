package chapter2;

/**
 * @Description 测试static修饰符
 * @Author yuki
 * @Date 2018/12/4 19:14
 * @Version 1.0
 **/
public class StaticTest {

    static int i;
    static void f(){
        //基本数据类型字段会初始化
        System.out.println(i++);
        System.out.println("StaticTest");
    }

    public static void main(String[] args) {
        System.out.println(StaticTest.i);
        StaticTest.f();
        System.out.println(StaticTest.i);
    }
}
