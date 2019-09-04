package chapter5;

import chapter6.Protect1;

/**
 * @Description 可变参数列表:
 * 1.参数数量可以为0
 * 2.会自动装箱拆箱
 * @Author yuki
 * @Date 2018/12/14 17:24
 * @Version 1.0
 **/
public class VarArgsType{
    static void f(Character...args){
        System.out.println(args.getClass());
        System.out.println(args.length);
    }
    static void g(int... args){
        System.out.println(args.getClass());
        System.out.println(args.length);
    }

    public static void main(String[] args) {
        f('a');
        f();
        g(1);
        g(new Integer(1));
        g();
        System.out.println(new Integer[2].getClass());
    }
}
