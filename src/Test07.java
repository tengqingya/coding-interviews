import java.util.Stack;

/**
 * Author: ������
 * Date: 2015-04-22
 * Time: 09:11
 * Declaration: All Rights Reserved !!!
 */
public class Test07 {
    /**
     * ������ջģ��Ķ���
     * ��������ʵ��һ�����С����е��������£���ʵ��������������appendTail��deleteHead��
     * �ֱ�����ڶ���β����������ڶ���ͷ��ɾ�����Ĺ��ܡ�
     */






    public static Stack<Integer> sta1;
    public static Stack<Integer> sta2;

    /**
     * ĳ���ֿ���ʡ��!!!
     * @param i
     */
    public static void enq(int i){
        //s1Ϊ��,��Ҫs2�ȷ���s1
        if(sta1.isEmpty()){
            while( !sta2.isEmpty() ){
                sta1.push(sta2.pop());
            }
        }
        sta1.push(i);
        //s1��Ϊ��ֱ�����
    }
    public static int deq(){
        //s2Ϊ�գ�s1����s2
        if(sta2.isEmpty()){
            while( !sta1.isEmpty() ){
                sta2.push(sta1.pop());
            }
        }
        return sta2.pop();
        //s2��Ϊ�գ�ֱ�ӳ���
    }































    public static class MList<T> {
        // ����ջ��ֻ���ڲ��������
        private Stack<T> stack1 = new Stack<>();
        // ����ջ��ֻ���ڵ�������
        private Stack<T> stack2 = new Stack<>();

        public MList() {
        }
        
        // ��Ӳ��������ڶ���β��������
        public void appendTail(T t) {
            stack1.add(t);
        }

        // ɾ���������ڶ���ͷ��ɾ�����
        public T deleteHead() {

            // ���жϵ���ջ�Ƿ�Ϊ�գ����Ϊ�վͽ�����ջ���������ݵ���ջ��
            // ���ҽ�����������ѹ�뵯��ջ��
            if (stack2.isEmpty()) {
                while (!stack1.isEmpty()) {
                    stack2.add(stack1.pop());
                }
            }

            // �������ջ�л�û�����ݾ��׳��쳣
            if (stack2.isEmpty()) {
                throw new RuntimeException("No more element.");
            }

            // ���ص���ջ��ջ��Ԫ�أ���Ӧ�ľ��Ƕ���Ԫ�ء�
            return stack2.pop();
        }
    }
}
