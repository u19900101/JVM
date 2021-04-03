package atguigu.chapter05;

/**
 * 演示栈中的异常：StackOverflowError
 *
 *
 * 设置栈的大小 -Xss256k    时 count为 2224
 * 不设置           默认时 count为 9869
 */
public class StackErrorTest {
    private static int count = 1;
    public static void main(String[] args) {
        System.out.println(count++);
        main(args);
    //    9869
    // Exception in thread "main" java.lang.StackOverflowError
    }
}
