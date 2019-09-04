package chapter7;

/**
 * @Description
 * 对于继承与重载：
当类以及父类具有f(int)和f(float)时，如果输入f(1)；
方法重载顺序为本类f(int)->父类f(int)->本类f(float)->父类f(float)
 * @Author yuki
 * @Date 2018/12/20 19:42
 * @Version 1.0
 **/
class OverTest{
//    void f(int i){
//        System.out.println("father f(int)");
//    }
    void f(float i){
        System.out.println("father f(float)");
    }
}
public class OverLoadingTest extends OverTest{
//    void f(int i){
//        System.out.println("son f(int)");
//    }
//    void f(float i){
//        System.out.println("son f(float)");
//    }
    public static void main(String[] args) {
        OverLoadingTest test=new OverLoadingTest();
        test.f(1);
    }
}
