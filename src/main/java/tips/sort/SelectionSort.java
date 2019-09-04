package tips.sort;

import java.util.Arrays;

/**
 * @Description 选择排序
循环n次，每一次都取出最小的交换到最前面
选择排序（Selection Sort）
选择排序(Selection-sort)是一种简单直观的排序算法。它的工作原理：首先在未排序序列中找到最小元
素，存放到排序序列的起始位置，然后，再从剩余未排序元素中继续寻找最小元素，然后放到已排序序列
的后面组成新的已排序元素。以此类推，直到所有元素均排序完毕。

算法描述
n个记录的直接选择排序可经过n-1趟直接选择排序得到有序结果。具体算法描述如下：
初始状态：无序区为R[1..n]，有序区为空；
第i趟排序(i=1,2,3…n-1)开始时，当前有序区和无序区分别为R[1..i-1]和R(i..n）。该趟排序从当前无序区
中-选出关键字最小的记录 R[k]，将它与无序区的第1个记录R交换，使R[1..i]和R[i+1..n)分别变为记录个数
增加1个的新有序区和记录个数减少1个的新无序区；
n-1趟结束，数组有序化了。
 * @Author yuki
 * @Date 2019/5/6 17:00
 * @Version 1.0
 **/
public class SelectionSort {
    public static int[] sort(int[] array){
        for (int i=0;i<array.length;i++){
            int minIndex=i;
            for (int j=i;j<array.length;j++){
                if (array[j]<array[minIndex]){
                    minIndex=j;
                }
            }
            int temp=array[i];
            array[i]=array[minIndex];
            array[minIndex]=temp;
        }
        return array;
    }

    public static void main(String[] args) {
        int[] arr={1,4,6,7,9,8,2,3,5,0};
        int[] ints = SelectionSort.sort(arr);
        System.out.println(Arrays.toString(ints));
    }
}
