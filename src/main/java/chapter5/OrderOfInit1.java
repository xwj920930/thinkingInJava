package chapter5;

/**
 * @Description 类成员无论分布在何处都会最先初始化
 * @Author yuki
 * @Date 2018/12/12 19:15
 * @Version 1.0
 **/
class Window{
    Window(int marker){
        System.out.println("Window("+marker+")");
    }
}
class House{
    Window window1=new Window(1);
    House(){
        System.out.println("House()");
        window3=new Window(33);
    }
    Window window2=new Window(2);
    void f(){
        System.out.println("f()");
    }
    Window window3=new Window(3);
}
public class OrderOfInit1 {
    public static void main(String[] args) {
        House house=new House();
        house.f();
    }
}
