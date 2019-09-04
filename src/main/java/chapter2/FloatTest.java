package chapter2;

/**
 * @Description 浮点数的相等
 * @Author yuki
 * @Date 2018/11/29 19:13
 * @Version 1.0
 **/
public class FloatTest {
    public static void main(String[] args) {
        System.out.println(equal(0.01f,0.01f));
    }

    public static boolean equal(float num1,float num2){
        return num1==num2||Math.abs(num1-num2)<1E-3;
    }
}
