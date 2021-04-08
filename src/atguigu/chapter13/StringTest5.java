package atguigu.chapter13;

import org.junit.Test;


/**
 * 字符串拼接
 *
 */
public class StringTest5 {

    @Test
    public void T(){
        String s1 = "a" + "b" + "c";  // 得到 abc的常量池
        String s2 = "abc"; // abc存放在常量池，直接将常量池的地址返回
        /**
         * 最终java编译成.class，再执行.class
         */
        System.out.println(s1 == s2); // true，因为存放在字符串常量池
        System.out.println(s1.equals(s2)); // true
    }

    //只要其中有一个是变量，结果就在堆中(不在字符串常量池中)。
    // 变量拼接的原理是StringBuilder
    @Test
    public void test2() {
        String s1 = "javaEE";
        String s2 = "hadoop";
        String s3 = "javaEEhadoop";
        String s4 = "javaEE" + "hadoop";//编译期 优化了
        String s5 = s1 + "hadoop";
        String s6 = "javaEE" + s2;
         /*
          s1 + s2的执行细节
          StringBuilder s = new StringBuilder();
          s.append(s1);
          s.append(s2);
          s.toString();  -> 类似于new String("ab");

        在JDK5之后，使用的是StringBuilder，在JDK5之前使用的是StringBuffer
        */

        String s7 = s1 + s2;

        System.out.println(s3 == s4); // true
        System.out.println(s3 == s5); // false
        System.out.println(s3 == s6); // false
        System.out.println(s3 == s7); // false
        System.out.println(s5 == s6); // false
        System.out.println(s5 == s7); // false
        System.out.println(s6 == s7); // false
        //intern方法，则会判断字符串常量池中是否存在JavaEEhadoop值，
        // 如果存在则返回常量池中的值，否者就在常量池中创建,并返回此对象的地址。
        String s8 = s6.intern();
        System.out.println(s3 == s8); // true
    }

    @Test
    public  void test4() {
        final String s1 = "a";
        final String s2 = "b";
        String s3 = "ab";

        // 1.字符串拼接操作，不一定使用的时StringBuilder
        //如果拼接符号左右都是 字符串常量 或 字符串常量引用,则仍然使用 编译器优化，即 非StringBuilder方式
        // 2.针对于final修饰的类、方法、基本数据类型、引用数据类型
        String s4 = s1 + s2;
        System.out.println(s3 == s4);
    }

    // s1 + s2 与  s.append(s1) 性能比较  6691 ms   2ms
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        method1(100000);
        long end = System.currentTimeMillis();
        System.out.println(end-start);

        start = System.currentTimeMillis();
        method2(100000);
        end = System.currentTimeMillis();
        System.out.println(end-start);
    }

    public static void method1(int highLevel) {
        String src = "";
        for (int i = 0; i < highLevel; i++) {
            src += "a"; // 每次循环都会创建一个StringBuilder对象
        }
    }

    public static void method2(int highLevel) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < highLevel; i++) {
            sb.append("a");
        }
    }


}
