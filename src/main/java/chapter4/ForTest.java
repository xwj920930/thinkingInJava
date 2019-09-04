package chapter4;

/**
 * @Description 测试for
 * @Author yuki
 * @Date 2018/12/5 19:20
 * @Version 1.0
 **/
public class ForTest {
    public static void main(String[] args) {
        for (char c=0;c<128;c++){
            if (Character.isLowerCase(c)){
                System.out.println(c);
            }
        }
        char c=100;
        System.err.println(c);
    }
}
