package chapter4;

/**
 * @Description 测试while
 * @Author yuki
 * @Date 2018/12/5 18:48
 * @Version 1.0
 **/
public class WhileTest {
    static boolean condition(){
        double number=Math.random();
        System.out.println(number);
        boolean result=number<0.99;
        return result;
    }
    public static void main(String[] args) {
        while (condition()){
        }
        System.out.println("outside while");
    }
}
