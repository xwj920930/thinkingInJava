package jdk7;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**非jdk7特性，Collections用于集合操作
 * @Description arrays用法
 * 1.原生数据类型数据的数组作为参数时使用错误，要使用包装类数组
 * 2.不能修改 List 的大小，例如使用add
 * asList 方法的参数必须是对象或者对象数组，而原生数据类型不是对象
 * @Author yuki
 * @Date 2019/3/22 10:05
 * @Version 1.0
 **/
public class CollectionsSupport {
    public static void main(String[] args) {
        List<Integer> list1=new ArrayList<>();
        list1.add(3);
        list1.add(2);
        list1.add(1);
        List<Integer> list2= Arrays.asList(3,2,1);
        System.out.println(list1.size()+list2.size());
        //Arrays.asList不能add
//        list2.add(4);
        Collections.sort(list1);
        Collections.sort(list2);
        System.out.println(list1);
        System.out.println(list2);
        //线程安全的list，底层实现就是加了synchronize锁
        Collections.synchronizedList(list1);
    }
}
