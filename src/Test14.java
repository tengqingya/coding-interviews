import static java.lang.System.out;

/**
 * Author: ������
 * Date: 2015-04-23
 * Time: 15:53
 * Declaration: All Rights Reserved !!!
 */
public class Test14 {

    /**
     * ����һ���������飬ʵ��һ�����������������������ֵ�˳��
     * ʹ����������λ�������ǰ�벿�֣�����ż��λ������ĺ�벿�֡�
     *
     * @param arr ���������
     */










//��ǰ�����ҵ�һ��ż�����Ӻ���ǰ�ҵ�һ������������
    public static void fun14(int[] arr ){
        int length = arr.length;
        int start =0;
        int end = length-1;
        int flag =0;//��־�Ƿ����߶��ҵ���
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
        // �������������Ϊ�գ����߳���С��2��ֻ�ӷ���
        if (arr == null || arr.length < 2) {
            return;
        }

        // �������Ҽ�¼ż����λ��
        int start = 0;
        // ���������¼������λ��
        int end = arr.length - 1;
        // ��ʼ����������ż����λ��
        while (start < end) {
            // ��ż��
            while (start < end && arr[start] % 2 != 0) {
                start++;
            }
            // ������
            while (start < end && arr[end] % 2 == 0) {
                end--;
            }

            // �ҵ���ͽ�������ż������λ��
            // ����start=end������������������ʲôӰ��
            // ���Խ�if�ж�ʡȥ��
            int tmp = arr[start];
            arr[start] = arr[end];
            arr[end] = tmp;
        }
    }

    /**
     * ����������Ϣ
     *
     * @param arr ���������
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
