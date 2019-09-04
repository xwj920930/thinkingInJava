package chapter5;

/**
 * @Description 可变参数列表的重载
 * 最明确匹配而非最佳匹配
普通方法f(long)可以接收int,可变参数f(long...)不接受int
 * @Author yuki
 * @Date 2018/12/17 10:38
 * @Version 1.0
 **/
public class VarArgsOverloading {
    static void f(Character... args){
        System.out.println("Character");
    }
    static void f(Integer... args){
        System.out.println("Integer");
    }
    static void f(Long... args){
        System.out.println("Long");
    }
    public static void main(String[] args) {
        f(1);
        //编译无法通过
//        f();
    }
}
