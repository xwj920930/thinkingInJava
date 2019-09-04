package chapter3;

/**
 * @Description 基本数据类型传值与对象传址
 * @Author yuki
 * @Date 2018/12/5 8:53
 * @Version 1.0
 **/
public class Assignment {
    public static void main(String[] args) {
        int i=1;
        int j=i;
        i++;
        System.out.println(j);
        Tank tank1=new Tank();
        tank1.i=1;
        Tank tank2=tank1;
        tank1.i++;
        System.out.println(tank2.i);
    }
}
class Tank{
    int i;
}
