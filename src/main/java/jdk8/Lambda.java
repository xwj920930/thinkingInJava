package jdk8;

/**
 * @Description lambda表达式可用来快速构建接口(单方法)的实现
 * lambda表达式的语法由参数列表、箭头符号->和函数体组成。
 * 函数体既可以是一个表达式，也可以是一个语句块：
 *表达式：表达式会被执行然后返回执行结果。(参数输入)->return输出(返回值为void时没有return)
 *语句块：语句块中的语句会被依次执行，就像方法中的语句一样(参数输入)->{方法体,显式return}
 * foreach方法专为lambda设计，但是方法中无法return；lambda主要用于直接调用已有方法，很少下述运用
 * @Author yuki
 * @Date 2019/3/22 14:58
 * @Version 1.0
 **/
interface MathOperation {
    int operation(int a, int b);
//    int a();
}

interface GreetingService {
    void sayMessage(String message);
}
public class Lambda {
    private int operate(int a, int b, MathOperation mathOperation){
        return mathOperation.operation(a, b);
    }
    public static void main(String[] args) {
        Lambda lambda=new Lambda();
        int i1=lambda.operate(1, 2, new MathOperation() {
            @Override
            public int operation(int a, int b) {
                return a-b;
            }
//            @Override
//            public int a() {
//                return 0;
//            }
        });
        //lambda的局限性，接口只能有一个方法
        //lambda两种特定写法
        int i2=lambda.operate(1,2,(a,b)-> {System.out.println("");return a+b;});
        int i3=lambda.operate(1,2,(a,b)-> a+b);
        System.out.println(i1);
        System.out.println(i2);
        ((GreetingService)(s)->System.out.println(s)).sayMessage("greet");
    }
}
