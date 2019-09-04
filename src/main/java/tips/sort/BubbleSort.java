package tips.sort;

import java.util.Arrays;

/**
 * @Description 冒泡排序
循环n次，每次通过交换将最大的数浮到最后
冒泡排序（Bubble Sort）
冒泡排序是一种简单的排序算法。它重复地走访过要排序的数列，一次比较两个元素，如果它们的顺序错误就
把它们交换过来。走访数列的工作是重复地进行直到没有再需要交换，也就是说该数列已经排序完成。这个算
法的名字由来是因为越大的元素会经由交换慢慢“浮”到数列的最后。

算法描述
比较相邻的元素。如果第一个比第二个大，就交换它们两个；
对每一对相邻元素作同样的工作，从开始第一对到结尾的最后一对，这样在最后的元素应该会是最大的数；
针对所有的元素重复以上的步骤，除了最后一个；
重复步骤1~3，直到排序完成。
 * @Author yuki
 * @Date 2019/5/6 16:16
 * @Version 1.0
 **/
public class BubbleSort {
    public static int[] sort(int[] array){
        for (int i=0;i<array.length;i++){
            for (int j=0;j<array.length-1-i;j++){
                if (array[j+1]<array[j]){
                    int temp=array[j];
                    array[j]=array[j+1];
                    array[j+1]=temp;
                }
            }
        }
        return array;
    }

    public static void main(String[] args) {
        int[] arr={1,4,6,7,9,8,2,3,5,0};
        int[] ints = BubbleSort.sort(arr);
        System.out.println(Arrays.toString(ints));
    }
}
