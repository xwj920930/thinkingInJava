package chapter4;

/**
 * @Description 测试break和continue
 * @Author yuki
 * @Date 2018/12/5 19:40
 * @Version 1.0
 **/
public class BreakAndContinueTest {
    public static void main(String[] args) {
        for (int i=0;i<100;i++){
            if (i==10){
                break;
            }
            if (i%3==0){
                continue;
            }
            System.out.println(i);
        }
    }
}
