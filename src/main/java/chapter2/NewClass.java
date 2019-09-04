package chapter2;

/**
 * @Description 类成员会初始化值，局部变量不会
 * @Author yuki
 * @Date 2018/11/29 19:37
 * @Version 1.0
 **/
public class NewClass {
    private int i;
    private ReferenceTest test;
    public void tt() {
        //基本数据类型字段会自动初始化
        System.out.println(i);
        System.out.println(test);
    }

    public static void main(String[] args) {
        NewClass aClass=new NewClass();
        aClass.tt();
        //main函数变量使用前必须初始化
//        int y;
//        System.out.println(y);
    }
}
