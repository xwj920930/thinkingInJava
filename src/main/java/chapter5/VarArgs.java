package chapter5;

/**
 * @Description 可变参数列表
 * @Author yuki
 * @Date 2018/12/14 17:24
 * @Version 1.0
 **/
class A{}
public class VarArgs {
    static void printArray(Object[] args){
        for (Object arg : args) {
            System.out.print(arg+" ");
        }
        System.out.println();
    }
    static void printArray2(Object... args){
        for (Object arg : args) {
            System.out.print(arg+" ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        printArray(new Object[]{47,new Float(3.14),new Double(11.11)});
        printArray(new String[]{"one","two","three"});
        printArray(new Object[]{new A(),new A(),new A()});
//        printArray();
        printArray2((Object) new Integer[]{new Integer(47),3,11});
        printArray2(new Object[]{"one","two","three"});
        printArray2(new A(),new A(),new A());
        printArray2();
    }
}
