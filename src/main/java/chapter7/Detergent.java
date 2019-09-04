package chapter7;

import java.util.logging.XMLFormatter;

/**
 * @Description 继承
 * @Author yuki
 * @Date 2018/12/20 15:22
 * @Version 1.0
 **/
class Cleanser{
    private String s="cleanser";
    public void append(String a){s+=a;}
    public void dilute(){append(" dilute()");}
    public void apply(){append(" apply()");}
    public void scrub(){append(" scrub()");}
    @Override
    public String toString() {
        return s;
    }
    public static void main(String[] args) {
        Cleanser cleanser=new Cleanser();
        cleanser.dilute();
        cleanser.apply();
        cleanser.scrub();
        System.out.println(cleanser);
    }
}
public class Detergent extends Cleanser{
    @Override
    public void scrub() {
        append(" Detergent.scrub()");
        super.scrub();
    }
    public void foam() {
        append(" foam()");
        super.scrub();
    }
    public static void main(String[] args) {
        Detergent detergent=new Detergent();
        detergent.dilute();
        detergent.apply();
        detergent.scrub();
        detergent.foam();
        System.out.println(detergent);
        System.out.println("test base class");
        Cleanser.main(args);
    }
}
