import static java.lang.System.out;

public class Test0001_1 {
    public static class Num {
        int i = 1;
        // �����߳̿��� ����ִ�е�һ����־
        boolean flag = false;
    }
    public static class PrintOdd implements Runnable {
        Num num;

        public PrintOdd(Num num) {
            this.num = num;

        }

        public void run() {
            while (num.i <= 100) {
                synchronized (num) {
                    out.println(Thread.currentThread().getName() + "  enter++++  ");
                    if (num.flag) {
                        try {
                            out.println(Thread.currentThread().getName() + "wait+++      ");
                            num.wait();
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }

                    } else {
                        System.out.println("����----" + num.i);
                        num.i++;
                        num.flag = true;
                        out.println(Thread.currentThread().getName() + "notify+++      ");
                        num.notify();
                    }
                    out.println(Thread.currentThread().getName() + "leave+++      ");
                }
            }
        }
    }
    public static class PrintEven implements Runnable {

        Num num;

        public PrintEven(Num num) {
            this.num = num;

        }

        public void run() {
            while (num.i <= 100) {
                synchronized (num) {// ����Ҫ��ͬ������������������num
                    out.println(Thread.currentThread().getName() + "  enter----  ");
                    if (!num.flag) {
                        try {
                            out.println(Thread.currentThread().getName() + "wait---      ");
                            num.wait();// wait()�������������ͬһ��
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }

                    } else {
                        System.out.println("ż��----" + num.i);
                        num.i++;
                        num.flag = false;
                        out.println(Thread.currentThread().getName() + "notify---      ");
                        num.notify();
                    }
                    out.println(Thread.currentThread().getName() + "leave---      ");
                }
            }
        }

    }

    public static void main(String[] args) {

        Num num = new Num();

        PrintOdd printOdd = new PrintOdd(num);
        PrintEven printEven = new PrintEven(num);

        Thread thread1 = new Thread(printOdd);
        Thread thread2 = new Thread(printEven);

        thread1.start();
        thread2.start();
    }
}
