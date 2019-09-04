package chapter8;

/**
 * @Description 如果想要手动清理，那么清理顺序应与构件顺序相反
 * @Author yuki
 * @Date 2018/12/21 17:36
 * @Version 1.0
 **/
class Characteristic{
    private String s;
    Characteristic(String s){
        this.s=s;
        System.out.println("create characteristic "+s);
    }
    protected void dispose(){
        System.out.println("dispose characteristic "+s);
    }
}
class Description{
    private String s;
    Description(String s){
        this.s=s;
        System.out.println("create Description "+s);
    }
    protected void dispose(){
        System.out.println("dispose Description "+s);
    }
}
class LivingCreature{
    private Characteristic p=new Characteristic("is alive");
    private Description t=new Description("basic living creature");
    LivingCreature(){
        System.out.println("LivingCreature");
    }
    protected void dispose(){
        System.out.println("dispose LivingCreature");
        t.dispose();
        p.dispose();
    }
}
class Animal extends LivingCreature{
    private Characteristic p=new Characteristic("has heart");
    private Description t=new Description("animal not vegetable");
    Animal(){
        System.out.println("Animal");
    }
    protected void dispose(){
        System.out.println("dispose Animal");
        t.dispose();
        p.dispose();
        super.dispose();
    }
}
class Amphibian extends Animal{
    private Characteristic p=new Characteristic("can live in water");
    private Description t=new Description("both water and land");
    Amphibian(){
        System.out.println("Amphibian");
    }
    protected void dispose(){
        System.out.println("dispose Amphibian");
        t.dispose();
        p.dispose();
        super.dispose();
    }
}
public class Frog extends Amphibian{
    private Characteristic p=new Characteristic("croaks");
    private Description t=new Description("eat bugs");
    Frog(){
        System.out.println("Frog");
    }
    protected void dispose(){
        System.out.println("dispose Frog");
        t.dispose();
        p.dispose();
        super.dispose();
    }

    public static void main(String[] args) {
        Frog frog=new Frog();
        System.out.println("bye");
        frog.dispose();
    }
}
