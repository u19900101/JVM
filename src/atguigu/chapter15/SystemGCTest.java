package atguigu.chapter15;

/**
 * @author lppppp
 * @create 2021-04-07 20:57
 */
public class SystemGCTest {
    // 类变量，属于GC Roots的一部分
    public static int i = 0;

    @Override
    protected void finalize() throws Throwable {
        System.out.println(i);
        System.out.println("调用当前类重写的finalize()方法,不指定引用");
    }

    public static void main(String[] args) throws InterruptedException {
        for (i = 0; i < 100; i++) {
            new SystemGCTest();
            System.gc();//不一定马上调用
            System.runFinalization();//可以强制调用
        }
    }
}
