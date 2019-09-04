package jdk8;

import java.util.Arrays;
import java.util.List;

/**
 * @Description 方法引用，lambda表达式的一种简写
 * 通过方法的名字来指向一个方法，减少代码冗余
引用静态方法	ContainingClass::staticMethodName
引用某个对象的实例方法	containingObject::instanceMethodName
引用某个类型的任意对象的实例方法	ContainingType::methodName
引用构造方法	ClassName::new
 * @Author yuki
 * @Date 2019/3/22 21:18
 * @Version 1.0
 **/
public class MethodReference {
    public static void main(String[] args) {
        List<String> list= Arrays.asList("a","b","c");
        //lambda表达式写法
//        list.forEach(str->System.out.println(str));
        //将list中的string传入，引用system.out方法来执行
        list.forEach(System.out::println);
    }
}
