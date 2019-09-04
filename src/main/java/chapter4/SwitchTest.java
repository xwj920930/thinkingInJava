package chapter4;

/**
 * @Description switch_case
 * @Author yuki
 * @Date 2018/12/6 9:31
 * @Version 1.0
 **/
public class SwitchTest {
    static void choose(String i){
        switch (i){
            case "111":
                break;
            case "222":
                break;
            default:
                break;
        }
    }
    public static void main(String[] args) {
        choose("111");
    }
}
