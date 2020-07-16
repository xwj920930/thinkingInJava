package jdk8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @Description
 * 一个非 final 的局部变量或方法参数，其值在初始化后就从未更改，那么该变量就是 effectively final，可以省略final
 * @Author yuki
 * @Date 2019/3/23 21:06
 * @Version 1.0
 **/
class Man{
    int age;
    String name;
    Man(int age,String name){
        this.age=age;
        this.name=name;
    }
    public void setName(String name) {
        this.name = name;
    }
}
public class EffectivelyFinal {
    public static void main(String[] args) {
        Man a1 = new Man(1, "A");
        Man b1 = new Man(2, "B");
        List<Man> mans = new ArrayList<>();
        mans.add(a1);
        mans.add(b1);
        String name = "man";
        //name = " "; 流式计算需要final，初始化后未修改默认final，注解放开错误
        mans.forEach(m->m.setName(name));
    }
}
