/**
 * Author: ������
 * Date: 2015-06-13
 * Time: 09:02
 * Declaration: All Rights Reserved !!!
 */
public class Test37 {
    /**
     * ��������
     */
    private static class ListNode {
        int val;
        ListNode next;

        public ListNode() {

        }

        public ListNode(int val) {
            this.val = val;
        }

        @Override
        public String toString() {
            return val + "";
        }
    }

    /**
     * ���������ĵ�һ��������㣬���û���ҵ�����null�������ȽϺã�������������������null�����
     *
     * @param head1 ��һ������
     * @param head2 �ڶ�������
     * @return �ҵ��Ĺ�����㣬û�з���null
     */






    //Ӧ��Ĭ��������ģ�
    public static ListNode test37(ListNode head1, ListNode head2) {
        ListNode p1 = head1;
        ListNode p2 = head2;
        if(p1==null||p2==null)
            return null;
        while(p1!=null&&p2!=null && p1.val<p2.val){
            p1 = p1.next;
        }
        if(p1==null)
            return null;
        while(p1!=null&&p2!=null &&  p1.val>p2.val){
            p2=p2.next;
        }
        if(p2==null)
            return null;
        if(p1.val == p2.val){
            return p1;
        }
        return test37(p1,p2);
    }











    public static ListNode findFirstCommonNode(ListNode head1, ListNode head2) {
        int length1 = getListLength(head1);
        int length2 = getListLength(head2);

        int diff = length1 - length2;
        ListNode longListHead = head1;
        ListNode shortListHead = head2;

        if (diff < 0) {
            longListHead = head2;
            shortListHead = head1;
            diff = length2 - length1;
        }

        for (int i = 0; i < diff; i++) {
            longListHead = longListHead.next;
        }

        while (longListHead != null && shortListHead != null && longListHead != shortListHead) {
            longListHead = longListHead.next;
            shortListHead = shortListHead.next;
        }

        // ���ص�һ����ͬ�Ĺ�����㣬���û�з���null
        return longListHead;
    }

    private static int getListLength(ListNode head) {
        int result = 0;
        while (head != null) {
            result++;
            head = head.next;
        }

        return result;
    }

    public static void main(String[] args) {
        test1();
        test2();
        test3();
        test4();
        test5();
    }

    private static void test1() {
        // ��һ����������������м�
        // 1 - 2 - 3 \
        //            6 - 7
        //     4 - 5 /
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        ListNode n6 = new ListNode(6);
        ListNode n7 = new ListNode(7);

        n1.next = n2;
        n2.next = n3;
        n3.next = n6;
        n6.next = n7;

        n4.next = n5;
        n5.next = n6;

        System.out.println(findFirstCommonNode(n1, n4)); // 6
    }


    private static void test2() {
        // û�й������
        // 1 - 2 - 3 - 4
        //
        // 5 - 6 - 7
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        ListNode n6 = new ListNode(6);
        ListNode n7 = new ListNode(7);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;

        n5.next = n6;
        n6.next = n7;
        System.out.println(test37(n1, n5)); // null
    }

    private static void test3() {
        // ������������һ�����
        // 1 - 2 - 3 - 4 \
        //                7
        //         5 - 6 /
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        ListNode n6 = new ListNode(6);
        ListNode n7 = new ListNode(7);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n7;

        n5.next = n6;
        n6.next = n7;
        System.out.println(test37(n1, n5)); // 7
    }

    private static void test4() {
        // ��������ǵ�һ�����
        // 1 - 2 - 3 - 4 - 5
        // ����������ȫ�غ�
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        ListNode n6 = new ListNode(6);
        ListNode n7 = new ListNode(7);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;

        System.out.println(test37(n1, n1)); // 1
    }

    private static void test5() {
        // ��������ǵ�һ�����
        // 1 - 2 - 3 - 4 - 5
        // ����������ȫ�غ�
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        ListNode n7 = new ListNode(7);
        ListNode n8 = new ListNode(8);
        ListNode n9 = new ListNode(9);
        ListNode n10 = new ListNode(10);
        ListNode n11 = new ListNode(11);
        ListNode n12 = new ListNode(12);
        ListNode n13 = new ListNode(13);
        ListNode n16 = new ListNode(16);
        ListNode n17 = new ListNode(17);

        n1.next = n2;
        n2.next = n3;
        n3.next = n7;
        n7.next = n11;
        n11.next = n13;
        n13.next = n17;
        n4.next = n5;
        n5.next = n8;
        n8.next = n9;
        n9.next = n10;
        n10.next = n12;
        n12.next = n16;
        n16.next = n17;

        System.out.println(test37(n1, n4)); // 1
    }


}
