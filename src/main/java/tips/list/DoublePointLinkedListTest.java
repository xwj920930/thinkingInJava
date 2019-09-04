package tips.list;

/**
 * @Description TODO
 * @Author yuki
 * @Date 2019/4/29 16:30
 * @Version 1.0
 **/
public class DoublePointLinkedListTest {
    public static void main(String[] args) {
        DoublePointLinkedList list=new DoublePointLinkedList();
        list.addHead("C");
        list.addHead("B");
        list.addHead("A");
        list.addTail("D");
        list.addTail("E");
        System.out.println(list);
        System.out.println("删除头");
        list.deleteHead();
        System.out.println(list);
        System.out.println("删除B");
        list.delete("B");
        System.out.println(list);
        System.out.println("查找D");
        System.out.println(list.find("D"));
    }
}
