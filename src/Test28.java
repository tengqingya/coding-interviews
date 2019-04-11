import static java.lang.System.out;

/**
 * Author: ������
 * Date: 2015-05-06
 * Time: 08:20
 * Declaration: All Rights Reserved !!!
 */
public class Test28 {
    /**
     * ��Ŀ������һ���ַ�������ӡ�����ַ������ַ����������С����������ַ���abc��
     * ���ӡ�����ַ�a��b��c �������г����������ַ���abc��acb��bac��bca��cab��cba��
     *
     * @param chars ��������ַ�����
     */


//https://www.jianshu.com/p/9cbd2634d3c4


    /**
     * ��chars�ֳɵ�һ��������Ĳ��֣���һ�����ܳ��ֵ���ʲô�����Ծͺͺ���Ľ���
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
        // �������
        if( chars == null || chars.length < 1 ) {
            return;
        }
        // �������в���
        permutation(chars, 0);
    }

    /**
     * ���ַ����������
     *
     * @param chars �����е��ַ���
     * @param begin ��ǰ�����λ��
     */
    public static void permutation( char[] chars, int begin ) {
        // ��������һ��Ԫ���ˣ���������н��
        if( chars.length - 1 == begin ) {
            out.print(new String(chars) + " ");
        } else {
            char tmp;
            // �Ե�ǰ��δ������ַ������д���ÿ���ַ���������Ϊ��ǰ����λ�õ�Ԫ��
            for( int i = begin; i < chars.length; i++ ) {
                // �����ǽ���Ԫ�ص�λ��
                tmp = chars[begin];
                chars[begin] = chars[i];
                chars[i] = tmp;

                // ������һ��λ��
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
