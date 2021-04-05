package atguigu.chapter09;

/**
 * non-final的类变量
 *-XX:MetaspaceSize的设置
 * windows下默认情况：
 *   -XX:MetaspaceSize是21M，
 *   -XX:MaxMetaspaceSize的值是-1，即没有限制。
 * 设置方式：
 *  -XX:MetaspaceSize=100M -XX:MaxMetaspaceSize=100M
 */
public class MethodAreaTest {
    public static void main(String[] args) throws InterruptedException {
        Order order = null;
        order.hello();
        System.out.println(order.count);
    /*  System.out.println("memeda...");
      Thread.sleep(1000000);*/
    }
}
class Order {
    public static int count = 1;
    public static final int number = 2;
    public static void hello() {
        System.out.println("hello!");
    }
}
