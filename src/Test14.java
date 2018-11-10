import static java.lang.System.out;

/**
 * Author: 王俊超
 * Date: 2015-04-23
 * Time: 15:53
 * Declaration: All Rights Reserved !!!
 */
public class Test14 {

    /**
     * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，
     * 使得所有奇数位于数组的前半部分，所有偶数位予数组的后半部分。
     *
     * @param arr 输入的数组
     */










//从前往后找第一个偶数，从后往前找第一个奇数，交换
    public static void fun14(int[] arr ){
        int length = arr.length;
        int start =0;
        int end = length-1;
        int flag =0;//标志是否两边都找到了
        while( start<end ){
            if(arr[start]%2==1){
                start++;
            }else {
                flag++;
            }
            if(arr[end]%2==0){
                end--;
            }else {
                flag++;
            }
            if(flag==2){
                swap14(arr,start,end);
                flag=0;
            }
        }
        if (arr != null && arr.length > 0) {
            for (int i : arr) {
                out.print(i + " ");
            }
            out.println();
        }
    }

    private static void swap14( int[] arr, int start, int end ) {
        int temp;
        temp = arr[start];
        arr[start] = arr[end];
        arr[end] =temp;
    }


    public static void reorderOddEven(int[] arr) {
        // 对于输入的数组为空，或者长度小于2的只接返回
        if (arr == null || arr.length < 2) {
            return;
        }

        // 从左向右记录偶数的位置
        int start = 0;
        // 从右向左记录奇数的位置
        int end = arr.length - 1;
        // 开始调整奇数和偶数的位置
        while (start < end) {
            // 找偶数
            while (start < end && arr[start] % 2 != 0) {
                start++;
            }
            // 找奇数
            while (start < end && arr[end] % 2 == 0) {
                end--;
            }

            // 找到后就将奇数和偶数交换位置
            // 对于start=end的情况，交换不会产生什么影响
            // 所以将if判断省去了
            int tmp = arr[start];
            arr[start] = arr[end];
            arr[end] = tmp;
        }
    }

    /**
     * 输出数组的信息
     *
     * @param arr 待输出数组
     */
    public static void printArray(int[] arr) {
        if (arr != null && arr.length > 0) {
            for (int i : arr) {
                out.print(i + " ");
            }
            out.println();
        }
    }

    public static void main(String[] args) {
        int[] array = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        reorderOddEven(array);
        printArray(array);
        fun14(array);
    }
}
