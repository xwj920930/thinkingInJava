package tips.stack;

/**
 * @Description TODO
 * @Author yuki
 * @Date 2019/4/26 17:30
 * @Version 1.0
 **/
public class Test {
    public static void main(String[] args) {
        MyStack<Integer> stack=new MyStack<>(3);
        stack.push(1);
        System.out.println(stack);
        stack.push(2);
        System.out.println(stack);
        stack.push(3);
        System.out.println(stack);
        Integer peek=stack.peek();
        System.out.println("peek:"+peek);
        System.out.println(stack);
        stack.pop();
        System.out.println(stack);
        Integer pop=stack.pop();
        System.out.println("pop:"+pop);
        System.out.println(stack);
    }
}
