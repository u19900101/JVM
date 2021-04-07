package atguigu.chapter13;

/**
 * String的垃圾回收
 * -Xms15m -Xmx15m -XX:+PrintStringTableStatistics -XX:+PrintGCDetails
 */
public class StringGCTest {
    public static void main(String[] args) {
        for (int i = 0; i < 100000; i++) {
            String.valueOf(i).intern();
        }
    }

    /*
    StringTable statistics:
    Number of buckets       :     60013 =    480104 bytes, avg   8.000
    Number of entries       :      1700 =     40800 bytes, avg  24.000
    Number of literals      :      1700 =    153856 bytes, avg  90.504
    */

    /*
    循环 100 次时
    StringTable statistics:
    Number of buckets       :     60013 =    480104 bytes, avg   8.000
    Number of entries       :      1795 =     43080 bytes, avg  24.000
    Number of literals      :      1795 =    158344 bytes, avg  88.214
    */


    /*
    循环 10w 次时  开始显示GC
   [GC (Allocation Failure) [PSYoungGen: 4096K->488K(4608K)] 4096K->696K(15872K), 0.0629311 secs] [Times: user=0.00 sys=0.00, real=0.06 secs]
    Heap
     PSYoungGen      total 4608K, used 3923K [0x00000000ffb00000, 0x0000000100000000, 0x0000000100000000)
      eden space 4096K, 83% used [0x00000000ffb00000,0x00000000ffe5af78,0x00000000fff00000)
      from space 512K, 95% used [0x00000000fff00000,0x00000000fff7a020,0x00000000fff80000)
      to   space 512K, 0% used [0x00000000fff80000,0x00000000fff80000,0x0000000100000000)
     ParOldGen       total 11264K, used 208K [0x00000000ff000000, 0x00000000ffb00000, 0x00000000ffb00000)
      object space 11264K, 1% used [0x00000000ff000000,0x00000000ff034000,0x00000000ffb00000)
     Metaspace       used 3447K, capacity 4496K, committed 4864K, reserved 1056768K
  class space    used 376K, capacity 388K, committed 512K, reserved 1048576K
    SymbolTable statistics:
    Number of buckets       :     20011 =    160088 bytes, avg   8.000
    Number of entries       :     14140 =    339360 bytes, avg  24.000
    Number of literals      :     14140 =    601480 bytes, avg  42.537
    */
}
