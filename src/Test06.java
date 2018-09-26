import com.sun.org.apache.regexp.internal.RE;
import sun.security.util.Length;

import java.awt.event.PaintEvent;
import java.util.HashMap;
import java.util.Map;

import static java.lang.System.out;

/**
 * Author: ������
 * Date: 2015-04-22
 * Time: 08:17
 * Declaration: All Rights Reserved !!!
 */
public class Test06 {








    //����ĳ��������ǰ���������������Ľ�������ؽ����ö����������������ǰ���������������Ľ���ж������ظ������֡�

    public static class Node6{
        public Node6 left;
        public Node6 right;
        public int value;
    }

    /**
     * ��������Ȼ����������ж�λ��
     * @param a ����
     * @param b ����
     * @return
     */
    public static Node6 fa(int[] a ,int[] b){
        if(a.length!=b.length){
            return null;
        }
        Map<Integer,Integer> map=new HashMap<>();
        //map�д�����˳�����a>b��b��a�ĺ���,�����������ӻ����ɺ���������ȷ��
        for(int i=0;i<a.length;i++){
            map.put(a[i],i);
        }
        Node6 preNode =null;
        Node6 root =null;
        int rootValue = a[0];
        for(int i=0;i<b.length;i++){
            int temB = b[i];
            Node6 n = new Node6();
            n.value=temB;
            if(i==0){
                preNode = n;
                root = n;
            }else {
                int aIndex = map.get(b[i-1]); //�����ǰһ���ڵ��������е�λ��
                int bIndex = map.get(temB);//����ǰһ���ڵ��������е�λ��
                if(aIndex>bIndex){
                    //a������
                    n.left = root;
                    root= n;
                }else{
                    //a�Ǹ�
                    preNode.right = n;
                }
            }
            //���������ұߵ�������ʱ���߲���ȥ��
            preNode = n;
//            if(n.value == rootValue)
//                root = preNode;
        }
        return root;
    }


    public static void print(Node6 root){
        if(root!=null){
            out.println(root.value);
            if(root.left!=null)print(root.left);
            if(root.right!=null)print(root.right);
        }
    }

    public static void printMid(Node6 root){
        if(root!=null){
            if(root.left!=null)printMid(root.left);
            out.println(root.value);
            if(root.right!=null)printMid(root.right);
        }
    }


    /**
     *
     * @param pre ����
     * @param mid ����
     */
    public static Node6 funa(int pre[],int mid[]){
        return funb(pre,0,pre.length-1,mid,0,mid.length-1);
    }

    private static Node6 funb( int[] pre, int preStart, int preEnd, int[] mid, int midStart, int midEnd ) {
        if(preStart>preEnd)return null;
        Node6 root = new Node6();
        root.value = pre[preStart];
        //�ҵ�midStart�������λ��
        //��������Ԫ�ظ�����index-midStart+1��
        //������Ԫ�ظ�����preEnd-index+1
        //preStart ���� index-midStart+1 ==����preStart+1����index-midStart
        int index = find(mid,pre[preStart]);
        root.left =  funb(pre,preStart+1,preStart+index-midStart,mid,midStart,index-1);
        root.right =  funb(pre,preStart+index-midStart+1,preEnd,mid,index+1,midEnd);
        return root;
    }























    /**
     * ����һ����ϱ�
     * @param hl
     */
    public static void printHL( double hl){
        out.println("����һ����ϱ�");
        for(int i =0;i<44;i++){
            out.println(i + "--->>>" + i * hl);
        }
    }
    /**
     * ����һ��ɸ۱�
     * @param hl
     */
    public static void printHL2(double hl){
        out.println("����һ��ɸ۱�");
        for(int i =0;i<44;i++){
            out.println(i + "--->>>"+ i * hl);
        }
    }
    /**
     * �ϱһ��������
     * @param hl
     */
    public static void printHL3(double hl){
        out.println("�ϱһ��������");
        for(int i =0;i<44;i++){
            out.println(i + "--->>>" + i * hl);
        }
    }
    /**
     * �۱һ��������
     * @param hl
     */
    public static void printHL4( double hl){
        out.println("�۱һ��������");
        for(int i =0;i<44;i++){
            out.println(i + "--->>>" + i * hl);
        }
    }

    private static int find( int[] pre, int midStart ) {
        for(int i=0;i<pre.length;i++ ){
            if(pre[i] == midStart)
                return i;
        }
        return 0;
    }


    /**
     * �������ڵ���
     */
    public static class BinaryTreeNode {
        int value;
        BinaryTreeNode left;
        BinaryTreeNode right;
    }

    /**
     * ����ĳ��������ǰ���������������Ľ�������ؽ����ö����������������ǰ���������������Ľ���ж������ظ������֡�
     *
     * @param preorder ǰ�����
     * @param inorder  �������
     * @return ���ĸ����
     */
    public static BinaryTreeNode construct(int[] preorder, int[] inorder) {
        // ����ĺϷ����жϣ��������鶼����Ϊ�գ����Ҷ������ݣ��������ݵ���Ŀ��ͬ
        if (preorder == null || inorder == null || preorder.length != inorder.length || inorder.length < 1) {
            return null;
        }

        return construct(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    /**
     * ����ĳ��������ǰ���������������Ľ�������ؽ����ö����������������ǰ���������������Ľ���ж������ظ������֡�
     *
     * @param preorder ǰ�����
     * @param ps       ǰ������Ŀ�ʼλ��
     * @param pe       ǰ������Ľ���λ��
     * @param inorder  �������
     * @param is       ��������Ŀ�ʼλ��
     * @param ie       ��������Ľ���λ��
     * @return ���ĸ����
     */
    public static BinaryTreeNode construct(int[] preorder, int ps, int pe, int[] inorder, int is, int ie) {

        // ��ʼλ�ô��ڽ���λ��˵���Ѿ�û����Ҫ�����Ԫ����
        if (ps > pe) {
            return null;
        }
        // ȡǰ������ĵ�һ�����֣����ǵ�ǰ�ĸ����
        int value = preorder[ps];
        int index = is;
        // ������������������Ҹ�����λ��
        while (index <= ie && inorder[index] != value) {
            index++;
        }

        // ������������������������û���ҵ���˵������Ĳ����ǲ��Ϸ��ģ��׳��쳣
        if (index > ie) {
            throw new RuntimeException("Invalid input");
        }

        // ������ǰ�ĸ���㣬����Ϊ��㸳ֵ
        BinaryTreeNode node = new BinaryTreeNode();
        node.value = value;

//        root.left =  funb(pre,preStart+1,preStart+index-midStart+1,mid,midStart,index-1);
//        root.right =  funb(pre,preStart+index-midStart+1,preEnd-index+1,mid,index+1,midEnd);

        // �ݹ鹹����ǰ����������������������Ԫ�ظ�����index-is+1��
        // ��������Ӧ��ǰ�������λ����[ps+1, ps+index-is]
        // ��������Ӧ�����������λ����[is, index-1]
        node.left = construct(preorder, ps + 1, ps + index - is, inorder, is, index - 1);
        // �ݹ鹹����ǰ����������������������Ԫ�ظ�����ie-index��
        // ��������Ӧ��ǰ�������λ����[ps+index-is+1, pe]
        // ��������Ӧ�����������λ����[index+1, ie]
        node.right = construct(preorder, ps + index - is + 1, pe, inorder, index + 1, ie);

        // ���ش����ĸ����
        return node;
    }

    // �������������
    public static void printTree(BinaryTreeNode root) {
        if (root != null) {
            printTree(root.left);
            out.print(root.value + " ");
            printTree(root.right);
        }

    }

    // ��ͨ������
    //              1
    //           /     \
    //          2       3
    //         /       / \
    //        4       5   6
    //         \         /
    //          7       8
    private static void test1() {
        int[] preorder = {1, 2, 4, 7, 3, 5, 6, 8};
        int[] inorder = {4, 7, 2, 1, 5, 3, 8, 6};
        BinaryTreeNode root = construct(preorder, inorder);
        printTree(root);
    }

    // ���н�㶼û�����ӽ��
    //            1
    //           /
    //          2
    //         /
    //        3
    //       /
    //      4
    //     /
    //    5
    private static void test2() {
        int[] preorder = {1, 2, 3, 4, 5};
        int[] inorder = {5, 4, 3, 2, 1};
        BinaryTreeNode root = construct(preorder, inorder);
        printTree(root);
    }

    // ���н�㶼û�����ӽ��
    //            1
    //             \
    //              2
    //               \
    //                3
    //                 \
    //                  4
    //                   \
    //                    5
    private static void test3() {
        int[] preorder = {1, 2, 3, 4, 5};
        int[] inorder = {1, 2, 3, 4, 5};
        BinaryTreeNode root = construct(preorder, inorder);
        printTree(root);
    }

    // ����ֻ��һ�����
    private static void test4() {
        int[] preorder = {1};
        int[] inorder = {1};
        BinaryTreeNode root = construct(preorder, inorder);
        printTree(root);
    }

    // ��ȫ������
    //              1
    //           /     \
    //          2       3
    //         / \     / \
    //        4   5   6   7
    private static void test5() {
        int[] preorder = {1, 2, 4, 5, 3, 6, 7};
        int[] inorder = {4, 2, 5, 1, 6, 3, 7};
        BinaryTreeNode root = construct(preorder, inorder);
        printTree(root);
    }

    // �����ָ��
    private static void test6() {
        construct(null, null);
    }

    // ������������в�ƥ��
    private static void test7() {
        int[] preorder = {1, 2, 4, 5, 3, 6, 7};
        int[] inorder = {4, 2, 8, 1, 6, 3, 7};
        BinaryTreeNode root = construct(preorder, inorder);
        printTree(root);
    }


    public static void main(String[] args) {

//        test1();
//        System.out.println();
//        test2();
//        System.out.println();
//        test3();
//        System.out.println();
//        test4();
//        System.out.println();
//        test5();
//        System.out.println();
//        test6();
//        System.out.println();
//        test7();
//        printHL(1.1745);
//        printHL2(1.1425);
//        printHL3(0.8515);
//        printHL4(0.8753);
        int[] preorder = {1, 2, 4, 5, 3, 6, 7};
        int[] inorder = {4, 2, 5, 1, 6, 3, 7};
        Node6 funb = funb(preorder, 0, 6, inorder, 0, 6);
        print(funb);
        out.println("");
        printMid(funb);
    }
}
