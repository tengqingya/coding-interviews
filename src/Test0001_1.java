import static java.lang.System.out;

public class Test0001_1 {
    public static class Num {
        int i = 1;
        // 两个线程看， 交替执行的一个标志
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
                        System.out.println("奇数----" + num.i);
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
                synchronized (num) {// 必须要用同意吧锁对象，这个对象是num
                    out.println(Thread.currentThread().getName() + "  enter----  ");
                    if (!num.flag) {
                        try {
                            out.println(Thread.currentThread().getName() + "wait---      ");
                            num.wait();// wait()函数必须和锁死同一个
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }

                    } else {
                        System.out.println("偶数----" + num.i);
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
