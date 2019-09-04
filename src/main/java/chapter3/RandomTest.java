package chapter3;

import java.util.Random;

/**
 * @Description 随机函数种子测试
 * math.random 返回0~1的随机数
 * random.nextInt(10) 返回0~10的随机数
 * @Author yuki
 * @Date 2018/12/5 9:57
 * @Version 1.0
 **/
public class RandomTest {
    public static void main(String[] args) {
        //种子定下来以后(47)每一次执行main函数结果都一样
        //默认种子为系统时间，所以每次执行都不一样
        Random random=new Random(47);
        //同一个random对象多次nextint的值不一样
        System.out.println(random.nextInt(10));
        System.out.println(random.nextInt(10));
        System.out.println(random.nextInt(10));
    }
}
