package tips.sort;

import java.util.Arrays;

/**
 * @Description 归并排序
先拆分到最小然后一层层合并排序，使用递归
归并排序（Merge Sort）
归并排序（MERGE-SORT）是利用归并的思想实现的排序方法，该算法采用经典的分治（divide-and-conquer）
策略（分治法将问题分(divide)成一些小的问题然后递归求解，而治(conquer)的阶段则将分的阶段得到的各
答案"修补"在一起，即分而治之)

算法描述
把长度为n的输入序列分成两个长度为n/2的子序列；
对这两个子序列分别采用归并排序；
将两个排序好的子序列合并成一个最终的排序序列。
 * @Author yuki
 * @Date 2019/5/6 16:16
 * @Version 1.0
 **/
public class MergeSort {
    //拆分
    public static int[] sort(int[] array){
        if (array.length < 2) return array;//长度为1不再拆分
        int mid = array.length / 2;
        int[] left = Arrays.copyOfRange(array, 0, mid);
        int[] right = Arrays.copyOfRange(array, mid, array.length);
        return merge(sort(left), sort(right));
    }
    //将左右数组合并排序
    public static int[] merge(int[] left, int[] right) {
        int[] result = new int[left.length + right.length];
        int i = 0, j = 0;//左右的指针初始为0
        for (int index = 0; index < result.length; index++) {
            if (i >= left.length)//左边的数已经取完了，将右边直接插入
                result[index] = right[j++];
            else if (j >= right.length)//右边的数已经取完了，将左边直接插入
                result[index] = left[i++];
            else if (left[i] > right[j])//右小右插入，然后右指针加一
                result[index] = right[j++];
            else//左小左插入，然后左指针加一
                result[index] = left[i++];
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr={1,4,6,7,9,8,2,3,5,0};
        int[] ints = MergeSort.sort(arr);
        System.out.println(Arrays.toString(ints));
    }
}
