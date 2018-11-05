import static java.lang.System.in;
import static java.lang.System.out;

/**
 * Author: ������
 * Date: 2015-04-23
 * Time: 13:39
 * Declaration: All Rights Reserved !!!
 */
public class Test12 {

    /**
     * ��������n����˳���ӡ����1����nλʮ����������������3�����ӡ��1��2��3 һֱ������3λ����999��
     *
     * @param n ���ֵ����λ��
     */



    public static void fun12(int n){
        //@Deprecated F(n) = F(1) * F(n-1)  //�ַ���ƴ�ӣ�����ֱ�����
        int []num = new int[n];
        //{1,2,3} ���ӡ 123,{0,0,1}���ӡ1
        printDG(num,n,0);
    }

    /**
     *
     * @param number
     * @param length
     * @param index
     */
    private static void printDG( int[] number, int length, int index) {
        //�����������ÿλ����0��9ѭ�������Եݹ�������϶���0��9��ѭ��
        //�����������������ÿһλ���еݹ飬���ݹ鵽���һλ��ʱ��ͽ����˲��Ҵ�ӡ
        if(index==length-1){
            p(number);
            return;
        }

        for(int i =0;i<=9;i++){
            number[index] = i; //number[index] �� number[index+1] �����𣿣�����
            printDG(number,length,index+1); //��ǰ��һλ
            //������ĵݹ�һ����һֱ���ظ���
        }
    }

    /**
     * ��ӡ����,��ǰ���0ȥ��
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
        //��ĩβ��ʼ���δ�ӡ
        int index =0;
        for(int len = sb.length()-1;len>=0;len--){
            //index��ʾ���δ�ӡ��λ
            int num = sb.charAt(len) - '0';
            //��ӡ
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
        //1,10,100,1000���δ�ӡ

    }


    public static void printOneToNthDigits(int n) {
        // ��������ֲ���ΪС��1
        if (n < 1) {
            throw new RuntimeException("The input number must larger than 0");
        }
        // ����һ���������ڴ���ֵ
        int[] arr = new int[n];
        printOneToNthDigits(0, arr);
    }

    /**
     * ��������n����˳���ӡ����1����nλʮ��������
     *
     * @param n   ��ǰ������ǵڸ�Ԫ�أ���0��ʼ����
     * @param arr ��Ž��������
     */
    public static void printOneToNthDigits(int n, int[] arr) {

        // ˵�����е���������ѡ���Ѿ���������
        if (n >= arr.length) {
            // �������������ֵ
            printArray(arr);
        } else {
            // ��
            for (int i = 0; i <= 9; i++) {
                arr[n] = i;
                printOneToNthDigits(n + 1, arr);
            }
        }
    }

    /**
     * ���������Ԫ�أ������ң��ӵ�һ����0ֵ����ʼ���������Ԫ�ء�
     *
     * @param arr Ҫ���������
     */
    public static void printArray(int[] arr) {
        // �ҵ�һ����0��Ԫ��
        int index = 0;
        while (index < arr.length && arr[index] == 0) {
            index++;
        }

        // �ӵ�һ����0ֵ����ʼ���������Ԫ�ء�
        for (int i = index; i < arr.length; i++) {
            out.print(arr[i]);
        }
        // ��������˵���������з���Ԫ�أ�������Ҫ����
        if (index < arr.length) {
            out.println();
        }
    }

    /**
     * ��������n����˳���ӡ����1����nλʮ����������������3�����ӡ��1��2��3 һֱ������3λ����999��
     * ���ڶ��ַ���������һ�������ڴ�ռ䡿
     *
     * @param n ���ֵ����λ��
     */
    public static void printOneToNthDigits2(int n) {
        // ����ֵ�������0
        if (n < 1) {
            throw new RuntimeException("The input number must larger than 0");
        }

        // ����һ������Ϊn������
        int[] arr = new int[n];
        // Ϊ����Ԫ�ظ���ʼֵ
        for (int i = 0; i < arr.length; i++) {
            arr[i] = 0;
        }

        // ������������λû�н�λ��һֱ���д���
        while (addOne(arr) == 0) {
            printArray(arr);
        }
    }

    /**
     * ��arr��ʾ����������λ��1 arr�е�ÿ���������ܳ���9����С��0��ÿ��λ��ģ��һ����λ
     *
     * @param arr ��������
     * @return �ж����λ�Ƿ��н�λ������н�λ�ͷ���1�����򷵻�0
     */
    public static int addOne(int[] arr) {
        // �����λֵ����Ϊÿ�����λ��1
        int carry = 1;
        // ���λ��λ�õĺ�һλ
        int index = arr.length;

        do {
            // ָ����һ������λ��
            index--;
            // ����λ�õ�ֵ���Ͻ�λ��ֵ
            arr[index] += carry;
            // ����λ�õĽ�λ
            carry = arr[index] / 10;
            // ����λ�õ�ֵ
            arr[index] %= 10;
        } while (carry != 0 && index > 0);

        // ���index=0˵���Ѿ����������λ��carry>0˵�����λ�н�λ������1
        if (carry > 0 && index == 0) {
            return 1;
        }

        // �޽�λ����0
        return 0;
    }


    public static void main(String[] args) {
//        printOneToNthDigits2(2);
//        out.println();
//        printOneToNthDigits(2);
        fun12(4);
    }

}
