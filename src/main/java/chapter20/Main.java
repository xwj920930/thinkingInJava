package chapter20;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import java.util.Map;

public class Main {
    public static void main(String ...args) throws NoSuchFieldException, IllegalAccessException {

        //获取Bar的val字段
        Field field = Bar.class.getDeclaredField("val");
        //获取val字段上的Foo注解实例
        Foo foo = field.getAnnotation(Foo.class);
        //获取 foo 这个代理实例所持有的 InvocationHandler
        InvocationHandler h = Proxy.getInvocationHandler(foo);
        // 获取 AnnotationInvocationHandler 的 memberValues 字段
        Field hField = h.getClass().getDeclaredField("memberValues");
        // 因为这个字段事 private final 修饰，所以要打开权限
        hField.setAccessible(true);
        // 获取 memberValues
        Map memberValues = (Map) hField.get(h);
        // 修改 value 属性值
        memberValues.put("value", "ddd");
        // 获取 foo 的 value 属性值
        String value = foo.value();
        System.out.println(value); // ddd

        //获取Bar实例
        Bar bar = new Bar();
        //获取Bar的val字段
        Field field1 = Bar.class.getDeclaredField("val");
        //获取val字段上的Foo注解实例
        Foo foo1 = field1.getAnnotation(Foo.class);
        //获取Foo注解实例的 value 属性值
        String value1 = foo1.value();
        //打印该值
        System.out.println(value1); // fff
    }
}