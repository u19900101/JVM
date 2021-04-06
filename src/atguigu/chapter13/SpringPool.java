package atguigu.chapter13;

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
    public static void main(String[] args) throws InterruptedException {
        System.out.println("测试 -XX:StringTablesize 设置...");
        Thread.sleep(1000000);
    }
}
