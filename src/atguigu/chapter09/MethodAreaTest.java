package atguigu.chapter09;

/**
 * non-final的类变量
 *
 */
public class MethodAreaTest {
    public static void main(String[] args) throws InterruptedException {
      /*  Order order = new Order();
        order.hello();
        System.out.println(order.count);*/
      System.out.println("memeda...");
      Thread.sleep(1000000);
    }
}
class Order {
    public static int count = 1;
    public static final int number = 2;
    public static void hello() {
        System.out.println("hello!");
    }
}
