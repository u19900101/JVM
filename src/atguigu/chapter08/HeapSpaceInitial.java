package atguigu.chapter08;

/**
 * 1.
 * -Xms 用来设置堆空间（年轻代+老年代）的初始内存大小
 *  -X：是jvm运行参数
 *  ms：memory start
 * -Xmx：用来设置堆空间（年轻代+老年代）的最大内存大小
 *
 * 2.默认情况下
 *
 * - 初始内存大小：物理电脑内存大小/64
 *
 * - 最大内存大小：物理电脑内存大小/4
 */
public class HeapSpaceInitial {
    public static void main(String[] args) {
        // 返回Java虚拟机中的堆内存总量
        long initialMemory = Runtime.getRuntime().totalMemory() / 1024 / 1024;
        // 返回Java虚拟机试图使用的最大堆内存
        long maxMemory = Runtime.getRuntime().maxMemory() / 1024 / 1024;
        System.out.println("-Xms:" + initialMemory + "M");
        System.out.println("-Xmx:" + maxMemory + "M");

        System.out.println("系统内存大小为： "+initialMemory*64.0/1024+" G");
        System.out.println("系统内存大小为： "+maxMemory*4.0/1024+" G");
    }
}
