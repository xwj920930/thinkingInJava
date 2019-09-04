package tips.sort;

import java.util.Arrays;

/**
 * @Description 希尔排序
插入排序的优化，主要特点是分组
希尔排序（Shell Sort）
希尔排序也是一种插入排序，它是简单插入
排序经过改进之后的一个更高效的版本，也称为缩小增量排序，
它与插入排序的不同之处在于，它会优先比较距离较远的元素。希尔排序又叫缩小增量排序。
希尔排序是把记录按下表的一定增量分组，对每组使用直接插入排序算法排序；随着增量逐渐减少，
每组包含的关键词越来越多，当增量减至1时，整个文件恰被分成一组，算法便终止。

算法描述
我们来看下希尔排序的基本步骤，在此我们选择增量gap=length/2，缩小增量继续以gap = gap/2的方式，
这种增量选择我们可以用一个序列来表示，{n/2,(n/2)/2...1}，称为增量序列。希尔排序的增量序列的
选择与证明是个数学难题，我们选择的这个增量序列是比较常用的，也是希尔建议的增量，称为希尔增量，
但其实这个增量序列不是最优的。此处我们做示例使用希尔增量。

先将整个待排序的记录序列分割成为若干子序列分别进行直接插入排序，具体算法描述：
选择一个增量序列t1，t2，…，tk，其中ti>tj，tk=1；
按增量序列个数k，对序列进行k 趟排序；
每趟排序，根据对应的增量ti，将待排序列分割成若干长度为m 的子序列，分别对各子表进行直接插入
排序。仅增量因子为1 时，整个序列作为一个表来处理，表长度即为整个序列的长度。
 * @Author yuki
 * @Date 2019/5/6 17:00
 * @Version 1.0
 **/
public class ShellSort {
    public static int[] sort(int[] array){
        int gap = array.length/2;
        while (gap > 0) {
            for (int i = gap; i < array.length; i++) {
                int tmp = array[i];
                int j = i - gap;
                while (j >= 0 && array[j] > tmp) {
                    array[j + gap] = array[j];
                    j -= gap;
                }
                array[j + gap] = tmp;
            }
            gap = gap / 2;
        }
        return array;
    }

    public static void main(String[] args) {
        int[] arr={1,4,6,7,9,8,2,3,5,0};
        int[] ints = ShellSort.sort(arr);
        System.out.println(Arrays.toString(ints));
    }
}
