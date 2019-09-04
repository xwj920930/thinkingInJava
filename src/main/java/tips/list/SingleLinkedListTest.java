package tips.list;

/**
 * @Description TODO
 * @Author yuki
 * @Date 2019/4/29 16:30
 * @Version 1.0
 **/
public class SingleLinkedListTest {
    public static void main(String[] args) {
        SingleLinkedList list=new SingleLinkedList();
        list.addHead("A");
        list.addHead("B");
        list.addHead("C");
        list.addHead("D");
        list.addHead("E");
        System.out.println(list);
        System.out.println("删除头");
        list.deleteHead();
        System.out.println(list);
        System.out.println("删除B");
        list.delete("B");
        System.out.println(list);
        System.out.println("查找A");
        System.out.println(list.find("A"));
        SingleLinkedList list2=new SingleLinkedList();
        list2.addHead("A");
        list2.addHead("B");
        list2.addHead("C");
        list2.addHead("D");
        list2.addHead("E");
        System.out.println(list2);
        System.out.println("反转");
        list2.reverse();
        System.out.println(list2);
        System.out.println("反向输出");
        list2.printReversely();
        System.out.println();
        System.out.println("中间数为："+list2.searchMid());
    }
}
