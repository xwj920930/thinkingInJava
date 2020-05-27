package jdk8;

import jdk.nashorn.internal.runtime.logging.Logger;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * @Description 反射
 * @Author yuki
 * @Date 2020/5/27
 * @Version 1.0
 **/
@Logger
@Deprecated
class Student{
    enum Gender{
        male,female
    }
    private String name;
    public int age;
    protected Gender gender;
    public Student(String name,int age,Gender gender){
    }
    public Student(){
    }
    public String getName() {
        return name;
    }
    private int getAge(){
        return age;
    }
    protected Gender getGender(){
        return gender;
    }
    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
public class Reflection {
    //获取类
    static void getClassMessage(){
        Class<Student> cl = Student.class;
//        Class<?> aClass = Class.forName("jdk8.Student");
        System.out.println("类名称:"+cl.getName());
        System.out.println("简单类名称:"+cl.getSimpleName());
        System.out.println("包名:"+cl.getPackage());
        System.out.println("是否为接口:"+cl.isInterface());
        System.out.println("是否为基本类型:"+cl.isPrimitive());
        System.out.println("是否为数组对象:"+cl.isArray());
        System.out.println("父类名称:"+cl.getSuperclass().getName());
    }
    //获取类中各种信息
    static void getMessageFromClass(){
        Class<Student> cl = Student.class;
        // 取得包对象
        Package p = cl.getPackage();
        System.out.println("包名:" + p.getName());
        // 访问修饰符
        int modifier = cl.getModifiers();
        System.out.println("类访问修饰符：" + Modifier.toString(modifier));
        //取得构造函数信息
        Constructor<?>[] constructors=cl.getConstructors();
        for(Constructor<?> constructor:constructors){
            System.out.print("构造函数访问修饰符：" + Modifier.toString(constructor.getModifiers()));
            System.out.print("构造函数名："+constructor.getName());
            System.out.println();
        }
        //取得声明的数据成员
        Field[] fields = cl.getDeclaredFields();
        for (Field field : fields) {
            System.out.print("数据成员访问修饰符：" + Modifier.toString(field.getModifiers()));
            System.out.print("数据成员类型："+field.getType().getName());
            System.out.print("数据成员成员名："+field.getName());
            System.out.println();
        }
        //取得成员方法
        Method[] methods=cl.getDeclaredMethods();
        for(Method method:methods){
            System.out.print("成员方法访问修饰符：" + Modifier.toString(method.getModifiers()));
            System.out.print("成员方法返回值类型："+method.getReturnType().getName());
            System.out.print("成员方法方法名："+method.getName());
            System.out.println();
        }
        Annotation[] annotations = cl.getDeclaredAnnotations();
        for (Annotation annotation : annotations) {
            System.out.println("注解：" + annotation.toString());
        }
    }
    //建立实例对象
    static Student initClass() throws IllegalAccessException, InstantiationException {
        Class<Student> studentClass = Student.class;
        return studentClass.newInstance();
    }
    //操作成员方法
    static void operateMethod() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class<Student> cl = Student.class;
        // 指定构造函数
        Constructor<?> constructor = cl.getConstructor(String.class, Integer.TYPE);
        // 根据指定的构造函数来获取对象
        Object object = constructor.newInstance("叶", 22);
        // 指定方法名称来获取对应的公开的Method实例
        Method getName = cl.getMethod("getName");
        // 调用对象object的方法
        getName.invoke(object);
        // 指定方法名称来获取对应的私有的的Method实例
        Method getAge = cl.getDeclaredMethod("getAge");
        getAge.setAccessible(true);
        // 调用对象object的方法
        getAge.invoke(object);
    }
    public static void main(String[] args) throws InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        getClassMessage();
        getMessageFromClass();
        initClass();
        operateMethod();
    }
}
