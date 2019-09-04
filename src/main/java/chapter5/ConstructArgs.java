package chapter5;

/**
 * @Description
 * 重载不完全匹配时,变大(例如int不存在时调用long->float->double),
 * 例如new A(1)匹配A(float)
   char不存在时调用int,否则报错
 * @Author yuki
 * @Date 2018/12/11 18:52
 * @Version 1.0
 **/
public class ConstructArgs {
    public static void main(String[] args) {
        new A(1);
//        new A(1f);
        new B(1);
    }
    static class A{
        A(int i){
            System.out.println("A int");
        }
    }
    static class B{
        B(float f){
            System.out.println("B float");
        }
    }
}
