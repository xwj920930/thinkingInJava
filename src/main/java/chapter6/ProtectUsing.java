package chapter6;

/**
 * @Description protect修饰符不仅是继承可以访问，包也能访问
 * @Author yuki
 * @Date 2018/12/20 14:34
 * @Version 1.0
 **/
public class ProtectUsing {
    public static void main(String[] args) {
        Protect1 protect1=new Protect1();
        protect1.get();
    }
}
