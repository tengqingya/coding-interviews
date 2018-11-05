import static java.lang.System.in;
import static java.lang.System.out;

/**
 * Author: 王俊超
 * Date: 2015-04-23
 * Time: 13:39
 * Declaration: All Rights Reserved !!!
 */
public class Test12 {

    /**
     * 输入数字n，按顺序打印出从1最大的n位十进制数。比如输入3，则打印出1、2、3 一直到最大的3位数即999。
     *
     * @param n 数字的最大位数
     */



    public static void fun12(int n){
        //@Deprecated F(n) = F(1) * F(n-1)  //字符串拼接，不是直接相加
        int []num = new int[n];
        //{1,2,3} 则打印 123,{0,0,1}则打印1
        printDG(num,n,0);
    }

    /**
     *
     * @param number
     * @param length
     * @param index
     */
    private static void printDG( int[] number, int length, int index) {
        //共性是数组的每位都是0到9循环，所以递归的最外层肯定是0到9的循环
        //结束条件：对数组的每一位进行递归，当递归到最后一位的时候就结束了并且打印
        if(index==length-1){
            p(number);
            return;
        }

        for(int i =0;i<=9;i++){
            number[index] = i; //number[index] 和 number[index+1] 的区别？？？？
            printDG(number,length,index+1); //往前移一位
            //最里面的递归一定是一直在重复的
        }
    }

    /**
     * 打印数组,最前面的0去掉
     * @param number
     */
    private static void p( int[] number ) {
        for(int i=0;i<number.length;i++){
            if(number[i]!=0)
                out.print(number[i]);
        }
        out.println("");
    }

    private static void print12( StringBuffer sb ) {
        //从末尾开始依次打印
        int index =0;
        for(int len = sb.length()-1;len>=0;len--){
            //index表示本次打印几位
            int num = sb.charAt(len) - '0';
            //打印
            if(index==0){
                sb.setCharAt(0,'1');
                print12_1(sb);
                index++;
            }else {
                sb.setCharAt(index-1,'0');
                sb.setCharAt(index++,'1');
                print12_1(sb);
            }
        }
    }

    private static void print12_1(StringBuffer sb ) {
        //1,10,100,1000依次打印

    }


    public static void printOneToNthDigits(int n) {
        // 输入的数字不能为小于1
        if (n < 1) {
            throw new RuntimeException("The input number must larger than 0");
        }
        // 创建一个数组用于打存放值
        int[] arr = new int[n];
        printOneToNthDigits(0, arr);
    }

    /**
     * 输入数字n，按顺序打印出从1最大的n位十进制数。
     *
     * @param n   当前处理的是第个元素，从0开始计数
     * @param arr 存放结果的数组
     */
    public static void printOneToNthDigits(int n, int[] arr) {

        // 说明所有的数据排列选择已经处理完了
        if (n >= arr.length) {
            // 可以输入数组的值
            printArray(arr);
        } else {
            // 对
            for (int i = 0; i <= 9; i++) {
                arr[n] = i;
                printOneToNthDigits(n + 1, arr);
            }
        }
    }

    /**
     * 输入数组的元素，从左到右，从第一个非0值到开始输出到最后的元素。
     *
     * @param arr 要输出的数组
     */
    public static void printArray(int[] arr) {
        // 找第一个非0的元素
        int index = 0;
        while (index < arr.length && arr[index] == 0) {
            index++;
        }

        // 从第一个非0值到开始输出到最后的元素。
        for (int i = index; i < arr.length; i++) {
            out.print(arr[i]);
        }
        // 条件成立说明数组中有非零元素，所以需要换行
        if (index < arr.length) {
            out.println();
        }
    }

    /**
     * 输入数字n，按顺序打印出从1最大的n位十进制数。比如输入3，则打印出1、2、3 一直到最大的3位数即999。
     * 【第二种方法，比上一种少用内存空间】
     *
     * @param n 数字的最大位数
     */
    public static void printOneToNthDigits2(int n) {
        // 输入值必须大于0
        if (n < 1) {
            throw new RuntimeException("The input number must larger than 0");
        }

        // 创建一个长度为n的数组
        int[] arr = new int[n];
        // 为数组元素赋初始值
        for (int i = 0; i < arr.length; i++) {
            arr[i] = 0;
        }

        // 求结果，如果最高位没有进位就一直进行处理
        while (addOne(arr) == 0) {
            printArray(arr);
        }
    }

    /**
     * 对arr表示的数组的最低位加1 arr中的每个数都不能超过9不能小于0，每个位置模拟一个数位
     *
     * @param arr 待加数组
     * @return 判断最高位是否有进位，如果有进位就返回1，否则返回0
     */
    public static int addOne(int[] arr) {
        // 保存进位值，因为每次最低位加1
        int carry = 1;
        // 最低位的位置的后一位
        int index = arr.length;

        do {
            // 指向上一个处理位置
            index--;
            // 处理位置的值加上进位的值
            arr[index] += carry;
            // 求处理位置的进位
            carry = arr[index] / 10;
            // 求处理位置的值
            arr[index] %= 10;
        } while (carry != 0 && index > 0);

        // 如果index=0说明已经处理了最高位，carry>0说明最高位有进位，返回1
        if (carry > 0 && index == 0) {
            return 1;
        }

        // 无进位返回0
        return 0;
    }


    public static void main(String[] args) {
//        printOneToNthDigits2(2);
//        out.println();
//        printOneToNthDigits(2);
        fun12(4);
    }

}
