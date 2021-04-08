package atguigu.chapter17;

/**
 *如何查看默认垃圾收集器
 *
 * -XX:+PrintCommandLineFlags：查看命令行相关参数（包含使用的垃圾收集器）
 *
 * 使用命令行指令：jinfo -flag  相关垃圾回收器参数  进程ID

    jdk1.8   -XX:+UseParallelGC
    jdk11    -XX:+UseG1GC
 */
public class GCUseTest {
    static final Integer _1MB = 1024 * 1024;
    public static void main(String[] args) {
       /* byte [] allocation1, allocation2, allocation3, allocation4;
        allocation1 = new byte[2 *_1MB];
        allocation2 = new byte[2 *_1MB];
        allocation3 = new byte[2 *_1MB];
        allocation4 = new byte[6 *_1MB];*/
    }
}
