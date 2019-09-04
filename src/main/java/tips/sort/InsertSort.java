package tips.sort;

import java.util.Arrays;

/**
 * @Description 选择排序
每循环一次，左边的有序数组加一位
插入排序（Insertion Sort）
插入排序（Insertion-Sort）的算法描述是一种简单直观的排序算法。它的工作原理是通过构建有序序列，
对于未排序数据，在已排序序列中从后向前扫描，找到相应位置并插入。插入排序在实现上，通常采用
in-place排序（即只需用到O(1)的额外空间的排序），因而在从后向前扫描过程中，需要反复把已排序
元素逐步向后挪位，为最新元素提供插入空间。

算法描述
从第一个元素开始，该元素可以认为已经被排序；
取出下一个元素，在已经排序的元素序列中从后向前扫描；
如果该元素（已排序）大于新元素，将该元素移到下一位置；
重复步骤3，直到找到已排序的元素小于或者等于新元素的位置；
将新元素插入到该位置后；
重复步骤2~5。
 * @Author yuki
 * @Date 2019/5/6 17:00
 * @Version 1.0
 **/
public class InsertSort {
    public static int[] sort(int[] array){
        for (int i=1;i<array.length;i++){
            //j未排序初始点。j-1已排序末尾
            int j=i;
            int temp=array[j];
            while (j>0&&temp<array[j-1]){
                array[j]=array[j-1];
                j--;
            }
            array[j]=temp;
        }
        return array;
    }

    public static void main(String[] args) {
        int[] arr={1,4,6,7,9,8,2,3,5,0};
        int[] ints = InsertSort.sort(arr);
        System.out.println(Arrays.toString(ints));
    }
}
