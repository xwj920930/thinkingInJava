package chapter5;

/**
 * @Description this关键字的用法
 * 1.返回当前对象
 * 2.构造器内部调用另一个构造器(方法不能用this调用构造器，
 * this只能在第一行，this调用只能一次)
 * 3.调用数据成员
 * @Author yuki
 * @Date 2018/12/11 19:14
 * @Version 1.0
 **/
public class ThisTest {
    static class Leaf{
        int i=0;
        Leaf increment(){
            i++;
            return this;
        }
        void print(){
            System.out.println("i="+i);
        }
    }
    static class This2{
        This2(){
            this(1);
//            this(2);
        }
        This2(int i){
        }
        void print(){
//            this(1);
        }
        static class This3{
            private String s;
            String a;
            This3(String s){
                this.s=s;
                a=s;
            }
        }
    }

    public static void main(String[] args) {
        Leaf leaf=new Leaf();
        leaf.increment().increment().increment().print();
    }
}
