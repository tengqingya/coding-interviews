/**
 * Author: ������
 * Date: 2015-04-23
 * Time: 09:09
 * Declaration: All Rights Reserved !!!
 */
public class Test09 {

    /**
     * дһ������������n����쳲�������Fibonacci) ���еĵ�n��
     * F(1)=1��F(2)=1, F(3)=2 ,F(n)=F(n-1)+F(n-2)��n>=4��n��N*��
     * @param n Fibonacci��������
     * @return ��n��Ľ��
     */

    //todo ��ѭ�����õݹ�



    public static long fb(int n){
        if(n==1 || n==2 )return 1;
        if(n==3) return 2;
        return fb(n-1) + fb(n-2);
    }








    public static long fibonacci(int n) {

        // ���������������ʱ�򷵻�0
        if (n <= 0) {
            return 0;
        }

        // ����1����2��ʱ�򷵻�1
        if (n == 1 || n == 2) {
            return 1;
        }

        // ��¼ǰ��������n-2������Fibonacci����ֵ
        long prePre = 1;
        // ��¼ǰ��������n-1������Fibonacci����ֵ
        long pre = 1;
        // ��¼ǰ��������n������Fibonacci����ֵ
        long current = 2;

        // ����n����Fibonacci����ֵ
        for (int i = 3; i <= n ; i++) {
            // ���i����Fibonacci����ֵ
            current = prePre + pre;
            // ���¼�¼�Ľ����prePreԭ�ȼ�¼��i-2��Fibonacci����ֵ
            // ���ڼ�¼��i-1��Fibonacci����ֵ
            prePre = pre;
            // ���¼�¼�Ľ����preԭ�ȼ�¼��i-1��Fibonacci����ֵ
            // ���ڼ�¼��i��Fibonacci����ֵ
            pre = current;
        }

        // ��������Ľ��
        return current;
    }

    public static void main(String[] args) {
        System.out.println(fibonacci(0));
        System.out.println(fibonacci(1));
        System.out.println(fibonacci(2));
        System.out.println(fibonacci(3));
        System.out.println(fibonacci(4));
        System.out.println(fibonacci(5));
        System.out.println(fibonacci(6));
        System.out.println(fibonacci(7));
        System.out.println(fb(7));
    }
}
