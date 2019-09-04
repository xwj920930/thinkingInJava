package chapter5;

/**
 * @Description 可变参数列表的重载
 * @Author yuki
 * @Date 2018/12/17 10:38
 * @Version 1.0
 **/
public class VarArgsOverloading2 {
    static void f(float f,Character... args){
        System.out.println("first");
    }
    static void f(Character... args){
        System.out.println("second");
    }
    public static void main(String[] args) {
        f();
        f(1,'a');
        //'a'既可以被当做float也可以被当做char
//        f('a','b');
    }
}
