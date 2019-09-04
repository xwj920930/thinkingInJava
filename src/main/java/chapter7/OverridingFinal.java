package chapter7;

/**
 * @Description final方法
 * @Author yuki
 * @Date 2018/12/20 18:50
 * @Version 1.0
 **/
class WithFinal{
    private final void f(){}
}
public class OverridingFinal extends WithFinal{
    //只是名字相同，并没有覆盖
    private final void f(){}
}
