package jdk8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @Description 流，用于操作集合。默认操作foreach元素
 * 1.不存储数据(需要collect)2.stream不改变源数据3.stream的延迟执行特性
 *创建使用collection.stream或者stream.of，新方法foreach属于流
 * sorted排序filter过滤limit截断distinct去重
 * max最大map将每个元素映射出另一个flatmap二位变为一维
 * @Author yuki
 * @Date 2019/3/23 21:06
 * @Version 1.0
 **/
public class NewStream {
    public static void main(String[] args) {
        List<String> list=Arrays.asList("a","b","c");
        List<String> newList=list.stream()
                .filter((s)->!s.startsWith("a"))
                .sorted(Comparator.reverseOrder())
                .limit(5)
                .collect(Collectors.toList());
        System.out.println(newList);
        List<String> list2=Arrays.asList("a","a","b","c");
        Optional<String> string=list2.stream()
                .distinct()
                .map((s)->s+1)
                .max(String::compareTo);
        System.out.println(string);
        String[] words = new String[]{"Hello","World"};
        List<String> a = Arrays.stream(words)
                .map(word -> word.split(""))
                .flatMap(Arrays::stream)
                .distinct()
                .collect(Collectors.toList());
        a.forEach(System.out::print);
        System.out.println();
        List<Person> personList = new ArrayList<>();
        personList.add(new Person(1, "a"));
        personList.add(new Person(1, "b"));
        personList.add(new Person(2, "c"));
        Map<Integer, List<Person>> collect = personList.stream().collect(Collectors.groupingBy(p -> p.id));
        for (Map.Entry<Integer, List<Person>> entry : collect.entrySet()) {
            System.out.println();
            for (Person person : entry.getValue()) {
                System.out.print(person);
            }
        }
    }
}
