package atguigu.chapter08;

import java.Mlang.String;

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
 * 3.手动设置大小 -Xms500M -Xmx500M
 *
 * 4.查看堆内存的内存分配情况   jps  ->  jstat -gc 进程id
 * 5. -XX:+PrintGCDetails
 *
 *
 * -Xms:479M
 * -Xmx:479M
 * Heap
 *  PSYoungGen      total 149504K, used 7711K [0x00000000f5980000, 0x0000000100000000, 0x0000000100000000)
 *   eden space 128512K, 6% used [0x00000000f5980000,0x00000000f6107c70,0x00000000fd700000)
 *   from space 20992K, 0% used [0x00000000feb80000,0x00000000feb80000,0x0000000100000000)
 *   to   space 20992K, 0% used [0x00000000fd700000,0x00000000fd700000,0x00000000feb80000)
 *  ParOldGen       total 341504K, used 0K [0x00000000e0c00000, 0x00000000f5980000, 0x00000000f5980000)
 *   object space 341504K, 0% used [0x00000000e0c00000,0x00000000e0c00000,0x00000000f5980000)
 *  Metaspace       used 3167K, capacity 4496K, committed 4864K, reserved 1056768K
 *   class space    used 345K, capacity 388K, committed 512K, reserved 1048576K
 *
 */
public class HeapSpaceInitial {
    public static void main(String[] args) {
        // 返回Java虚拟机中的堆内存总量
        long initialMemory = Runtime.getRuntime().totalMemory() / 1024 / 1024;
        // 返回Java虚拟机试图使用的最大堆内存
        long maxMemory = Runtime.getRuntime().maxMemory() / 1024 / 1024;
        System.out.println("-Xms:" + initialMemory + "M");
        System.out.println("-Xmx:" + maxMemory + "M");
       /* try {
            Thread.sleep(100000000);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("end.......");
        }*/
        // System.out.println("系统内存大小为： "+initialMemory*64.0/1024+" G");
        // System.out.println("系统内存大小为： "+maxMemory*4.0/1024+" G");
    }
}
