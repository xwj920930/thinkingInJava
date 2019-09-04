package chapter3;

/**
 * @Description 左移<<,右移>>,无符号右移>>>
 * @Author yuki
 * @Date 2018/12/5 14:33
 * @Version 1.0
 **/
public class MoveScale {
    public static void main(String[] args) {
        //101
        int a=5;
        //左移
        a<<=1;
        //1010
        System.out.println(a);
        //101
        int b=5;
        //右移
        b>>=1;
        //10
        System.out.println(b);
        //11111111111111111111111111101100
        int c=-20;
        System.out.println(Integer.toBinaryString(c));
        //无符号右移
        c>>>=1;
        //01111111111111111111111111110110
        System.out.println(Integer.toBinaryString(c));
    }
}
