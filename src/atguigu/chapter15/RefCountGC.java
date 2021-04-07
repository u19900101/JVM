package atguigu.chapter15;

/**
 * 引用计数算法测试
 *
 */
public class RefCountGC {
    // 这个成员属性的唯一作用就是占用一点内存
    private byte[] bigSize = new byte[5*1024*1024];
    // 引用
    Object reference = null;

    public static void main(String[] args) {
        RefCountGC obj1 = new RefCountGC();
        RefCountGC obj2 = new RefCountGC();
        obj1.reference = obj2;
        obj2.reference = obj1;
        obj1 = null;
        obj2 = null;
        // 显示的执行垃圾收集行为，判断obj1 和 obj2是否被回收？
        System.gc();
    }
    /*
    不使用 gc时
    Heap
     PSYoungGen      total 38400K, used 14235K [0x00000000d5b00000, 0x00000000d8580000, 0x0000000100000000)
      eden space 33280K, 42% used [0x00000000d5b00000,0x00000000d68e6db0,0x00000000d7b80000)
      from space 5120K, 0% used [0x00000000d8080000,0x00000000d8080000,0x00000000d8580000)
      to   space 5120K, 0% used [0x00000000d7b80000,0x00000000d7b80000,0x00000000d8080000)
     ParOldGen       total 87552K, used 0K [0x0000000081000000, 0x0000000086580000, 0x00000000d5b00000)
      object space 87552K, 0% used [0x0000000081000000,0x0000000081000000,0x0000000086580000)
     Metaspace       used 3185K, capacity 4496K, committed 4864K, reserved 1056768K
      class space    used 350K, capacity 388K, committed 512K, reserved 1048576K
    */

    /*使用GC后
    [GC (System.gc()) [PSYoungGen: 13569K->808K(38400K)] 13569K->816K(125952K), 0.0009645 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
    [Full GC (System.gc()) [PSYoungGen: 808K->0K(38400K)] [ParOldGen: 8K->632K(87552K)] 816K->632K(125952K), [Metaspace: 3160K->3160K(1056768K)], 0.0047061 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
    Heap
     PSYoungGen      total 38400K, used 998K [0x00000000d5b00000, 0x00000000d8580000, 0x0000000100000000)
      eden space 33280K, 3% used [0x00000000d5b00000,0x00000000d5bf9b20,0x00000000d7b80000)
      from space 5120K, 0% used [0x00000000d7b80000,0x00000000d7b80000,0x00000000d8080000)
      to   space 5120K, 0% used [0x00000000d8080000,0x00000000d8080000,0x00000000d8580000)
     ParOldGen       total 87552K, used 632K [0x0000000081000000, 0x0000000086580000, 0x00000000d5b00000)
      object space 87552K, 0% used [0x0000000081000000,0x000000008109e0f8,0x0000000086580000)
     Metaspace       used 3177K, capacity 4496K, committed 4864K, reserved 1056768K
      class space    used 347K, capacity 388K, committed 512K, reserved 1048576K
    */
}

