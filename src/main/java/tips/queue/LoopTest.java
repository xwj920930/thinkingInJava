package tips.queue;

/**
 * @Description 测试非循环队列
 * @Author yuki
 * @Date 2019/4/26 17:24
 * @Version 1.0
 **/
public class LoopTest {
    public static void main(String[] args) {
        System.out.println("add");
        LoopQueue<Integer> queue=new LoopQueue<>(3);
        queue.add(1);
        System.out.println(queue);
        queue.add(2);
        System.out.println(queue);
        queue.add(3);
        System.out.println(queue);
        System.out.println("pop");
        queue.pop();
        System.out.println(queue);
        queue.pop();
        System.out.println(queue);
        System.out.println("add");
        queue.add(4);
        System.out.println(queue);
        queue.add(5);
        System.out.println(queue);
    }
}
