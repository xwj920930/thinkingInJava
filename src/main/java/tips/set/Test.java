package tips.set;

import java.util.Iterator;

/**
 * @Author yuki
 * @Date 2019/6/18 10:03
 * @Version 1.0
 **/
public class Test {
    public static void main(String[] args) {
        MyHashSet<Integer> mySet= new MyHashSet<>();
        mySet.add(1);
        mySet.add(2);
        mySet.add(5);
        mySet.add(null);
        System.out.println("size:"+mySet.size());
        Iterator iterator = mySet.iterator();
        while (iterator.hasNext()){
            System.out.print(iterator.next()+" ");
        }
        System.out.println();
        System.out.println("插入重复元素：2");
        mySet.add(2);
        Iterator iterator1 = mySet.iterator();
        while (iterator1.hasNext()){
            System.out.print(iterator1.next()+" ");
        }
    }
}
