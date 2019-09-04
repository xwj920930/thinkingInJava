package chapter4;

/**
 * @Description goto
 * @Author yuki
 * @Date 2018/12/6 9:21
 * @Version 1.0
 **/
public class GotoTest {
    public static void main(String[] args) {
        out:
        for (int i=0;i<10;i++){
            for (int j=0;j<10;j++){
                if (j==2){
//                    break out;
                    continue out;
                }
            }
        }
    }
}
