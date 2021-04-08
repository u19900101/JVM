package atguigu.chapter08;


/**
 * 栈上分配  逃逸分析和标量替换  一起开启效果好，单独开启无甚用
 * -Xmx1G -Xms1G
 * -XX:+DoEscapeAnalysis 默认为 true
 * -XX:+EliminateAllocations 默认为 true
 * -XX:+PrintGCDetails
 * 开启逃逸分析时 耗时 5ms
 * 不开启逃逸分析时 耗时 735ms
 *
 */
class User {
    public String name;
    public int age;
    public String gender;
    public String phone;
}
public class StackAllocation {
    public static void main(String[] args) throws InterruptedException {
        long start = System.currentTimeMillis();
        for (int i = 0; i < 100000000; i++) {
            alloc();
        }
        long end = System.currentTimeMillis();
        System.out.println("花费的时间为：" + (end - start) + " ms");

        // 为了方便查看堆内存中对象个数，线程sleep
        Thread.sleep(10000000);
    }

    private static void alloc() {
        User user = new User();
        user.age = 1;
        user.gender = "kk";
        user.name= "kk";
        user.phone = "1569999";

    }
}
