package chapter4;

import java.util.Random;

/**
 * @Description 测试foreach
 * @Author yuki
 * @Date 2018/12/5 19:28
 * @Version 1.0
 **/
public class ForeachTest {
    public static void main(String[] args) {
        float[] floats=new float[10];
        Random random=new Random(47);
        for (int i=0;i<10;i++){
            floats[i]=random.nextFloat();
        }
        for (float aFloat : floats) {
            System.out.println(aFloat);
        }
    }
}
