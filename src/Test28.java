import static java.lang.System.out;

/**
 * Author: 王俊超
 * Date: 2015-05-06
 * Time: 08:20
 * Declaration: All Rights Reserved !!!
 */
public class Test28 {
    /**
     * 题目：输入一个字符串，打印出该字符事中字符的所有排列。例如输入字符串abc。
     * 则打印出由字符a、b、c 所能排列出来的所有字符串abc、acb、bac、bca、cab和cba。
     *
     * @param chars 待排序的字符数组
     */


//https://www.jianshu.com/p/9cbd2634d3c4


    /**
     * 把chars分成第一个和其余的部分，第一个可能出现的是什么？所以就和后面的交换
     *
     *
     *
     *
     * @param chars
     */
    public static void test28( char chars[] ) {
        test28_1(chars,0);
    }


    public static void test28_1( char chars[], int start ) {
        int length = chars.length;
        out.println(new String(chars));
        for( int i = start; i < length; i++ ) {
            char temp = chars[start];
            chars[start] = chars[i];
            chars[i] = temp;
            test28_1(chars, start + 1);
        }
    }


    public static void permutation( char[] chars ) {
        // 输入较验
        if( chars == null || chars.length < 1 ) {
            return;
        }
        // 进行排列操作
        permutation(chars, 0);
    }

    /**
     * 求字符数组的排列
     *
     * @param chars 待排列的字符串
     * @param begin 当前处理的位置
     */
    public static void permutation( char[] chars, int begin ) {
        // 如果是最后一个元素了，就输出排列结果
        if( chars.length - 1 == begin ) {
            out.print(new String(chars) + " ");
        } else {
            char tmp;
            // 对当前还未处理的字符串进行处理，每个字符都可以作为当前处理位置的元素
            for( int i = begin; i < chars.length; i++ ) {
                // 下面是交换元素的位置
                tmp = chars[begin];
                chars[begin] = chars[i];
                chars[i] = tmp;

                // 处理下一个位置
                permutation(chars, begin + 1);
            }
        }
    }

    public static void main( String[] args ) {
//        char[] c1 = {'a', 'b', 'c'};
//        permutation(c1);
//        out.println();

        char[] c2 = {'a', 'b', 'c', 'd'};
        permutation(c2);
        out.println("");
        out.println("");
        out.println("");
        test28(c2);
    }
}
