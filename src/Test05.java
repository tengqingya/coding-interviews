import java.util.Stack;

import static java.lang.System.out;

/**
 * Author: 王俊超
 * Date: 2015-04-21
 * Time: 21:36
 * Declaration: All Rights Reserved !!!
 */
public class Test05 {
        // 输入个链表的头结点，从尾到头反过来打印出每个结点的值
        //使用栈的方式进行

  public static class Node{
      Node next;
      int value;

      /**
       * 如果想使结果一层一层传上来，我们该怎么做？其实很简单，就是在递归调用前面加上return即可
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
     * 结点对象
     */
    public static class ListNode {
        int val; // 结点的值
        ListNode nxt; // 下一个结点
    }

    /**
     * 输入个链表的头结点，从尾到头反过来打印出每个结点的值
     * 使用栈的方式进行
     *
     * @param root 链表头结点
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
     * 输入个链表的头结点，从尾到头反过来打印出每个结点的值
     * 使用栈的方式进行
     *
     * @param root 链表头结点
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
