package chapter5;

import javax.annotation.processing.SupportedSourceVersion;

/**
 * @Description 枚举类测试
 * @Author yuki
 * @Date 2018/12/17 11:09
 * @Version 1.0
 **/
public class EnumTest {
    private Spiciness spiciness;
    EnumTest(Spiciness spiciness){
        this.spiciness=spiciness;
    }
    //枚举类与switch混合使用
    void describe(){
        switch (spiciness){
            case NOT:
                System.out.println("not");
                break;
            case MILD:
            case MEDIUM:
            case FLAMING:
            default:
                break;
        }
    }
    public static void main(String[] args) {
        Spiciness spiciness=Spiciness.HOT;
        System.out.println(spiciness);
        for (Spiciness spiciness1 : Spiciness.values()) {
            System.out.println(spiciness1+";"+spiciness1.ordinal());
        }
        EnumTest enumTest=new EnumTest(Spiciness.NOT);
        enumTest.describe();
    }
}
