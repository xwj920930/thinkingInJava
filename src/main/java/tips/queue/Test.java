package tips.queue;

/**
 * @Description 测试非循环队列
 * @Author yuki
 * @Date 2019/4/26 17:24
 * @Version 1.0
 **/
public class Test {
    public static void main(String[] args) {
        MyQueue<Integer> queue=new MyQueue<>(3);
        queue.add(1);
        System.out.println(queue);
        queue.add(2);
        System.out.println(queue);
        queue.add(3);
        System.out.println(queue);
        Integer peek = queue.peek();
        System.out.println("peek:"+peek);
        System.out.println(queue);
        queue.pop();
        System.out.println(queue);
        Integer pop=queue.pop();
        System.out.println("pop:"+pop);
        System.out.println(queue);
        queue.pop();
        System.out.println(queue);
    }
}
