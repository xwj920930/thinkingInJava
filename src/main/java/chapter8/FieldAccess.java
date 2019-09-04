package chapter8;

/**
 * @Description
 * 调用方法是多态的，调用域不是多态的
 * 例如A a=new B();
 * a.f()指的是B的f();
 * a.i指的是a的i
 * @Author yuki
 * @Date 2018/12/21 16:32
 * @Version 1.0
 **/
class Super{
    public int field=0;
    public int getField(){return field;}
}
class Sub extends Super{
    public int field=1;
    public int getField(){return field;}
    public int getSuperField(){return super.field;}
}
public class FieldAccess {
    public static void main(String[] args) {
        Sub sub=new Sub();
        System.out.println(sub.field+";"+sub.getField()+";"+sub.getSuperField());
        Super aSuper=new Sub();
        System.out.println(aSuper.field+";"+aSuper.getField());
    }
}
