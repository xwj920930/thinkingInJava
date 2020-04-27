package jdk8;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @Description
 * 主要用于类似于∑的操作，数1与数2得到结果，结果再与数3操作 ...
 * 1.Optional<T> reduce(BinaryOperator<T> accumulator); 单参数
 * 2.T reduce(T identity, BinaryOperator<T> accumulator); 双参数，基础上多了一个初始化的值
 * 3.<U> U reduce(U identity,BiFunction<U, ? super T, U> accumulator,BinaryOperator<U> combiner);
 * 三参数，用于并行，但是值和理解上的不同
 * @Author yuki
 * @Date 2019/3/23 21:06
 * @Version 1.0
 **/
public class Reduce {
    public static void main(String[] args) {
        Stream<Integer> stream = Arrays.stream(new Integer[]{1, 2, 3, 4, 5});
        //求集合元素之和
        Integer sum = stream.reduce((a, b) -> a + b).get();
        System.out.println(sum);

        Stream<Integer> stream1 = Arrays.stream(new Integer[]{1, 3, 4, 5});
        //求最大值
        Integer max = stream1.reduce((a, b) -> a >= b ? a : b).get();
        System.out.println(max);

        //求最小值
        Stream<Integer> stream2 = Arrays.stream(new Integer[]{1, 2, 3, 4, 5});
        Integer min = stream2.reduce((a, b) -> a <= b ? a : b).get();
        System.out.println(min);

        //求积
        Stream<Integer> stream3 = Arrays.stream(new Integer[]{1, 2, 4});
        Integer result2 = stream3.reduce((i, j) -> i * j).get();
        System.out.println(result2);

        //做逻辑
        Stream<Integer> stream4 = Arrays.stream(new Integer[]{1, 2, 3, 4, 5});
        Integer integer = stream4.reduce((i, j) -> i > j ? j : i).get();
        System.out.println(integer);

        //求积(双参数)
        Stream<Integer> stream5 = Arrays.stream(new Integer[]{1, 2, 4});
        Integer result3 = stream5.reduce(0 , (i, j) -> i * j);
        System.out.println(result3);
    }
}
