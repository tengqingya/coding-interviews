import java.util.Stack;

import static java.lang.System.out;

/**
 * Author: ������
 * Date: 2015-04-21
 * Time: 21:36
 * Declaration: All Rights Reserved !!!
 */
public class Test05 {
        // ����������ͷ��㣬��β��ͷ��������ӡ��ÿ������ֵ
        //ʹ��ջ�ķ�ʽ����

  public static class Node{
      Node next;
      int value;

      /**
       * �����ʹ���һ��һ�㴫���������Ǹ���ô������ʵ�ܼ򵥣������ڵݹ����ǰ�����return����
       * @param node
       */
      public static void print(Node node){
          if(node.next == null){
              out.println(node.value);
          }else {
              Node.print(node.next);
              out.println(node.value);
          }
      }
  }



















    /**
     * ������
     */
    public static class ListNode {
        int val; // ����ֵ
        ListNode nxt; // ��һ�����
    }

    /**
     * ����������ͷ��㣬��β��ͷ��������ӡ��ÿ������ֵ
     * ʹ��ջ�ķ�ʽ����
     *
     * @param root ����ͷ���
     */
    public static void printListInverselyUsingIteration(ListNode root) {
        Stack<ListNode> stack = new Stack<>();
        while (root != null) {
            stack.push(root);
            root = root.nxt;
        }
        ListNode tmp;
        while (!stack.isEmpty()) {
            tmp = stack.pop();
            out.print(tmp.val + " ");
        }
    }

    /**
     * ����������ͷ��㣬��β��ͷ��������ӡ��ÿ������ֵ
     * ʹ��ջ�ķ�ʽ����
     *
     * @param root ����ͷ���
     */
    public static void printListInverselyUsingRecursion(ListNode root) {
        if (root != null) {
            printListInverselyUsingRecursion(root.nxt);
            out.print(root.val + " ");
        }
    }











    public static void main(String[] args) {
        ListNode root = new ListNode();
        root.val = 1;
        root.nxt = new ListNode();
        root.nxt.val = 2;
        root.nxt.nxt = new ListNode();
        root.nxt.nxt.val = 3;
        root.nxt.nxt.nxt = new ListNode();
        root.nxt.nxt.nxt.val = 4;
        root.nxt.nxt.nxt.nxt = new ListNode();
        root.nxt.nxt.nxt.nxt.val = 5;

        printListInverselyUsingIteration(root);
        out.println();
        printListInverselyUsingRecursion(root);
        out.println();

        Node node = new Node();
        node.value=1;
        node.next=new Node();
        node.next.value=2;
        node.next.next = new Node();
        node.next.next.value = 3;
        node.next.next.next = new Node();
        node.next.next.next.value = 4;
        node.next.next.next.next = new Node();
        node.next.next.next.next.value = 5;
        Node.print(node);
        Node.print(node);
    }

}
