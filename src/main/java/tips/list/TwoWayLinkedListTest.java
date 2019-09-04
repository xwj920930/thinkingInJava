package tips.list;

/**
 * @Description TODO
 * @Author yuki
 * @Date 2019/4/29 16:30
 * @Version 1.0
 **/
public class TwoWayLinkedListTest {
    public static void main(String[] args) {
        TwoWayLinkedList list=new TwoWayLinkedList();
        list.addHead("C");
        list.addHead("B");
        list.addHead("A");
        list.addTail("D");
        list.addTail("E");
        System.out.println(list);
        System.out.println("删除头");
        list.deleteHead();
        System.out.println(list);
        System.out.println("删除尾");
        list.deleteTail();
        System.out.println(list);
        System.out.println(list.display());
    }
}
