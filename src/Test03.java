/**
 * Author: ������
 * Date: 2015-04-21
 * Time: 18:43
 * Declaration: All Rights Reserved !!!
 */
public class Test03 {

    public static boolean t(int[][] arr,int a){
        //Ĭ��������
        int l1 = arr[0].length; //����
        int l2 = arr.length; //�߶�
        for(int i =0;i<l2;i++){
            if(a>arr[i][l1-1]){
            }else if(a<arr[i][l1-1]){
                for(int j = 0;j<l1;j++){
                    if(a==arr[i][j]) return true;
                }
            }else {
                return true;
            }
        }
        return false;
    }








    /**
     * ��һ����ά�����У�ÿһ�ж����մ����ҵ�����˳������ÿһ�ж����մ��ϵ��µ�����˳������
     * �����һ������������������һ����ά�����һ���������ж��������Ƿ��и�������
     * <p/>
     * ���ɣ�����ѡȡ���������Ͻǵ����֡���������ֵ���Ҫ���ҵ����֣����ҹ��̽�����
     * ��������ִ���Ҫ���ҵ����֣��޳�����������ڵ��У����������С��Ҫ���ҵ����֣��޳�����������ڵ��С�
     * Ҳ����˵���Ҫ���ҵ����ֲ�����������Ͻǣ���ÿ���ζ�������Ĳ��ҷ�Χ���޳����л���һ�У�����ÿһ����������С
     * ���ҵķ�Χ��ֱ���ҵ�Ҫ���ҵ����֣����߲��ҷ�ΧΪ�ա�
     *
     * @param matrix �����ҵ�����
     * @param number Ҫ���ҵ���
     * @return ���ҽ����true�ҵ���falseû���ҵ�
     */





    public static boolean find(int[][] matrix, int number) {

        // ���������ж�
        if (matrix == null || matrix.length < 1 || matrix[0].length < 1) {
            return false;
        }

        int rows = matrix.length; // ���������
        int cols = matrix[1].length; // �����е�����

        int row = 0; // ��ʼ��ʼ���к�
        int col = cols - 1; // ��ʼ��ʼ���к�

        // Ҫ���ҵ�λ��ȷ��������֮��
        while (row >= 0 && row < rows && col >= 0 && col < cols) {
            if (matrix[row][col] == number) { // ����ҵ��˾�ֱ���˳�
                return true;
            } else if (matrix[row][col] > number) { // ����ҵ�������Ҫ�ҵ�����˵��Ҫ�ҵ����ڵ�ǰ�������
                col--; // ������һ�����������ƶ�
            } else { // ����ҵ�������Ҫ�ҵ���С��˵��Ҫ�ҵ����ڵ�ǰ�����±�
                row++; // ������һ�����������ƶ�
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 8, 9},
                {2, 4, 9, 12},
                {4, 7, 10, 13},
                {6, 8, 11, 15}
        };
        System.out.println(find(matrix, 7));    // Ҫ���ҵ�����������
        System.out.println(find(matrix, 5));    // Ҫ���ҵ�������������
        System.out.println(find(matrix, 1));    // Ҫ���ҵ�������������С������
        System.out.println(find(matrix, 15));   // Ҫ���ҵ�������������������
        System.out.println(find(matrix, 0));    // Ҫ���ҵ�������������С�����ֻ�С
        System.out.println(find(matrix, 16));   // Ҫ���ҵ������������������ֻ���
        System.out.println(find(null, 16));     // ��׳�Բ��ԣ������ָ��

        System.out.println("-----------------");
        System.out.println(t(matrix, 7));
        System.out.println(t(matrix, 5));
        System.out.println(t(matrix, 1));
        System.out.println(t(matrix, 15));
        System.out.println(t(matrix, 0));
        System.out.println(t(matrix, 16));
    }
}
