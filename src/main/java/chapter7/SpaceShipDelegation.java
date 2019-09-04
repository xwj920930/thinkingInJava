package chapter7;

/**
 * @Description 代理模式（idea可以自动生成代码）
 * @Author yuki
 * @Date 2018/12/20 15:55
 * @Version 1.0
 **/
class SpaceShipControl{
    void up(int velocity){}
    void down(int velocity){}
}
public class SpaceShipDelegation {
    private SpaceShipControl control=new SpaceShipControl();

    public void up(int velocity) {
        control.up(velocity);
    }

    public void down(int velocity) {
        control.down(velocity);
    }
}
