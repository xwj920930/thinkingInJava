package chapter4;

/**
 * @Description 测试do_while
 * @Author yuki
 * @Date 2018/12/5 18:48
 * @Version 1.0
 **/
public class DoWhileTest {
    public static void main(String[] args) {
        int i =0;
        do{
            System.out.println(i);
            i++;
        }
        while (i<0);
        System.out.println(i);
        int j=0;
        while (j<0){
            System.err.println(j);
            j++;
        }
        System.err.println(j);
    }
}
