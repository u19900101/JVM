package atguigu.chapter02;

import java.Mlang.String;

/**
 * @author: 陌溪
 * @create: 2020-07-05-9:14
 */
public class DeadThreadTest {
    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            func();
        }

    }

    static public void func(){
        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "\t 线程t1开始");
            new DeadThread();
        }, "t1").start();

        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "\t 线程t2开始");
            new DeadThread();
        }, "t2").start();
    }
}
class DeadThread {

    static {
        if (true) {
            System.out.println(Thread.currentThread().getName() + "\t 初始化当前类");
            /*while(true) {

            }*/
        }
    }
}