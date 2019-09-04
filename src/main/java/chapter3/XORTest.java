package chapter3;

/**
 * @Description 亦或,相异为或，相异为1
 * @Author yuki
 * @Date 2018/12/5 11:08
 * @Version 1.0
 **/
public class XORTest {
    public static void main(String[] args) {
        //101
        int a=5;
        System.out.println(Integer.toBinaryString(a));
        //011
        int b=3;
        System.out.println(Integer.toBinaryString(b));
        //110
        System.out.println(a^b);
        System.out.println(true^false);
    }
}
