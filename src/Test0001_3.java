import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import static java.lang.System.out;

/**
 * ½»Ìæ´òÓ¡ÆæÅ¼Êý
 *
 * @author tengqingya
 * @create 2018-11-15 19:48
 */
public class Test0001_3 {
    public static int i;
    private static Lock lock = new ReentrantLock();
    private static Condition odd = lock.newCondition();
    private static Condition even = lock.newCondition();

    public static class MyThread1 extends Thread {
        @Override
        public void run() {
            while( i<100 ) {
                lock.lock();
                out.println(Thread.currentThread().getName() + "  enter++++  " + i);
                if( i % 2 == 0 ) {
                    out.println(Thread.currentThread().getName() + "    " + i++);
                    out.println(Thread.currentThread().getName() + "    notify");
                    try {
                        odd.signal();
                        even.await(); //important
                    } catch( Exception e ) {
                        e.printStackTrace();
                    }
                } else {
                    try {
                        out.println(Thread.currentThread().getName() + "    wait");
                        even.await();
                        out.println(Thread.currentThread().getName() + "    wait over");
                    } catch( Exception e ) {
                        e.printStackTrace();
                    }
                }
                lock.unlock();
                out.println(Thread.currentThread().getName() + "leave++++     " + i);
            }
        }
    }

    public static class MyThread2 extends Thread {
        @Override
        public void run() {

            while( i<100 ) {
                lock.lock();
                    out.println(Thread.currentThread().getName() + "  enter----  " + i);
                    if( i % 2 == 1 ) {
                        out.println(Thread.currentThread().getName() + "    " + i++);
                        out.println(Thread.currentThread().getName() + "    notify");
                        try {
                            even.signal();
                            odd.await();   //important
                        } catch( Exception e ) {
                            e.printStackTrace();
                        }
                    } else {
                        try {
                            out.println(Thread.currentThread().getName() + "    wait");
                            odd.await();
                            out.println(Thread.currentThread().getName() + "    wait over");
                        } catch( Exception e ) {
                            e.printStackTrace();
                        }
                    }
                    lock.unlock();
                    out.println(Thread.currentThread().getName() + "leave---      " + i);
            }
        }
    }

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
