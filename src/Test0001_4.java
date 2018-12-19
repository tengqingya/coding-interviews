import static java.lang.System.out;

/**
 * 交替打印奇偶数
 *
 * @author tengqingya
 * @create 2018-11-13 19:48
 */
public class Test0001_4 {
    public static Object obj = new Object();
    public static int i;

    public static class MyThread1 extends Thread {
        @Override
        public void run() {

                synchronized( obj ) {
                    while( i<100 ) {
                    out.println(Thread.currentThread().getName() + "  enter++++  " + i);
                    if( i % 2 == 0 ) {
                        out.println(Thread.currentThread().getName() + "    " + i++);
                        out.println(Thread.currentThread().getName() + "    notify");
                        obj.notify();
                    } else {
                        try {
                            out.println(Thread.currentThread().getName() + "    wait");
                            obj.wait();
                            out.println(Thread.currentThread().getName() + "    wait over");
                        } catch( InterruptedException e ) {
                            e.printStackTrace();
                        }
                    }
                    out.println(Thread.currentThread().getName() + "leave++++     " + i);
                }
            }
        }
    }

    public static class MyThread2 extends Thread {
        @Override
        public void run() {


                synchronized( obj ) {
                    while( i<100 ) {
                    out.println(Thread.currentThread().getName() + "  enter----  " + i);
                    if( i % 2 == 1 ) {
                        out.println(Thread.currentThread().getName() + "    " + i++);
                        out.println(Thread.currentThread().getName() + "    notify");
                        obj.notify();
                    } else {
                        try {
                            out.println(Thread.currentThread().getName() + "    wait");
                            obj.wait();
                            out.println(Thread.currentThread().getName() + "    wait over");
                        } catch( InterruptedException e ) {
                            e.printStackTrace();
                        }
                    }
                    out.println(Thread.currentThread().getName() + "leave---      " + i);
                }
            }
        }
    }
//notify 之后自己也是可以抢占锁的 ！！！
    //或者  调用了notify()之后立即调wait();
    public static void main( String[] args ) {
        Thread t1 = new MyThread1();
        Thread t2 = new MyThread2();
        t1.start();

        try {
            Thread.sleep(111);
        } catch( InterruptedException e ) {
            e.printStackTrace();
        }
        t2.start();
    }
}
