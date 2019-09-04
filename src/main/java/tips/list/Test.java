package tips.list;

/**
 * @Description TODO
 * @Author yuki
 * @Date 2019/4/25 17:29
 * @Version 1.0
 **/
public class Test {
    public static void main(String[] args) {
        MyArrayList list=new MyArrayList(1);
        list.add("A");
        System.out.println(list);
        list.add("B");
        System.out.println(list);
        list.add("C");
        System.out.println(list);
        list.add("D");
        System.out.println(list);
        list.remove(1);
        System.out.println(list);
        list.remove(1);
        System.out.println(list);
        list.add("E");
        System.out.println(list);
        list.remove("E");
        System.out.println(list);
        System.out.println("get(1):"+list.get(1));
    }
}
