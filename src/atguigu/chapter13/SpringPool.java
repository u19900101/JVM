package atguigu.chapter13;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

/**
 * @author lppppp
 * @create 2021-04-06 10:38
 *
 * StringPool 底层为HashTable
 * 使用-XX:StringTableSize可设置stringTable的长度

  在jdk6中stringTable是固定的，就是1009的长度，所以如果常量池中的字符串过多就会导致效率下降很快。stringTablesize设置没有要求

  在jdk7中，stringTable的长度默认值是60013，

    在JDK8中，StringTable可以设置的最小值为-XX:StringTableSize=1009，默认值是60013
    若设置不正确则会
    Error: Could not create the Java Virtual Machine.
 *  Error: A fatal exception has occurred. Program will exit.
 *  StringTable size of 109 is invalid; must be between 1009 and 2305843009213693951
 */
public class SpringPool {
    public static void main(String[] args) throws IOException {
        // System.out.println("测试 -XX:StringTablesize 设置...");
        // Thread.sleep(1000000);
        // 读取10w个字符
        // BufferedReader bf = null;
        // bf  = new BufferedReader(new FileReader("words.txt"));
        // long start = System.currentTimeMillis();
        // String data;
        // while ((data = bf.readLine())!= null){
        //     data.intern();//如果字符串常量池中没有对应的data字符串，则在常量池中生成
        // }
        // long end = System.currentTimeMillis();
        // System.out.println("耗时： "+(end-start) + " ms");
    //     默认时  -XX:StringTableSize=60013时      耗时：  48 ms
    //     调整    -XX:StringTableSize=1009时       耗时： 157 ms


        T_内存结构分配到位置();
    }


    public static void T_内存结构分配到位置(){
        // -XX:MetaspaceSize=6M  -XX:MaxMetaspaceSize=6M -Xms6M -Xmx6M
        // java.lang.OutOfMemoryError: GC overhead limit exceeded
        int i =0;
        try {
            Set s = new HashSet();

            while (true){
                s.add(String.valueOf(i++).intern());
            }
        }finally {
            System.out.println(i);
        }

    }


}
