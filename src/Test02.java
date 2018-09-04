import static java.lang.System.out;

/**
 * Author: 王俊超
 * Date: 2015-04-21
 * Time: 13:58
 * Declaration: All Rights Reserved !!!
 */
public class Test02 {

    /**
     * 单例模式，懒汉式，线程安全
     */
    public static class Singleton {
        private final static Singleton INSTANCE = new Singleton();

        private Singleton() {

        }

        public static Singleton getInstance() {
            return INSTANCE;
        }
    }

    /**
     * 单例模式，饿汉式，线程不安全
     */
    public static class Singleton2 {
        private static Singleton2 instance = null;

        private Singleton2() {

        }

        public static Singleton2 getInstance() {
            if (instance == null) {
                instance = new Singleton2();
            }

            return instance;
        }
    }


    /**
     * 单例模式，饿汉式，线程安全，多线程环境下效率不高
     */
    public static class Singleton3 {
        private static Singleton3 instance = null;

        private Singleton3() {

        }

        public static synchronized Singleton3 getInstance() {
            if (instance == null) {
                instance = new Singleton3();
            }

            return instance;
        }
    }

    /**
     * 单例模式，饿汉式，变种，线程安全
     */
    public static class Singleton4 {
        private static Singleton4 instance = null;

        static {
            instance = new Singleton4();
        }

        private Singleton4() {

        }

        public static Singleton4 getInstance() {
            return instance;
        }
    }

    /**
     * 单例模式，懒汉式，使用静态内部类，线程安全【推荐】
     */
    public static class Singleton5 {
        private final static class SingletonHolder {
            private static final Singleton5 INSTANCE = new Singleton5();
        }

        private Singleton5() {

        }

        public static Singleton5 getInstance() {
            return SingletonHolder.INSTANCE;
        }
    }

    /**
     * 静态内部类，使用枚举方式，线程安全【推荐】
     *
     * 枚举中的每个枚举变量都调用了一次构造方法
     */
    public enum Singleton6 {
        INSTANCE,
        INSTANCE1(1);

        Singleton6() {
            out.println("Singleton6");
        }
        Singleton6(int a) {
            out.println("Singleton6666");
        }

        public void whateverMethod() {

        }
    }

    /**
     * 静态内部类，使用双重校验锁，线程安全【推荐】
     */
    public static class Singleton7 {
        private volatile static Singleton7 instance = null;

        private Singleton7() {

        }

        public static Singleton7 getInstance() {
            if (instance == null) {
                synchronized (Singleton7.class) {
                    if (instance == null) {
                        instance = new Singleton7();
                    }
                }
            }

            return instance;
        }
    }

    public static void main(String[] args) {
        out.println(Singleton.getInstance() == Singleton.getInstance());
        out.println(Singleton2.getInstance() == Singleton2.getInstance());
        out.println(Singleton3.getInstance() == Singleton3.getInstance());
        out.println(Singleton4.getInstance() == Singleton4.getInstance());
        out.println(Singleton5.getInstance() == Singleton5.getInstance());
        out.println(Singleton6.INSTANCE1 == Singleton6.INSTANCE1);
        out.println(Singleton7.getInstance() == Singleton7.getInstance());
    }

}
