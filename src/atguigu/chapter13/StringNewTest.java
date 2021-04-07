package atguigu.chapter13;

/**
 * new String("ab") 会创建几个对象？ 看字节码就知道是2个对象
 *
 * String str = new String("a") + new String("b");
 * 我们创建了6个对象
 *
 * - 对象1：new StringBuilder()
 * - 对象2：new String("a")
 * - 对象3：常量池的 a
 * - 对象4：new String("b")
 * - 对象5：常量池的 b
 * - 对象6：toString中会创建一个 new String("ab")
 *   - 调用toString方法，不会在常量池中生成ab
 */
public class StringNewTest {
    public static void main(String[] args) {


        String s1 = new String("1");//此时 已经在常量池中创建了 常量 1
        s1.intern();// 常量池中 未发生变化
        String s2 = "1";
        System.out.println(s1 == s2); // false


        String s3 = new String("1") + new String("1");// 此时 常量池中没有 11
        s3.intern(); // 在常量池 指向 堆中 s3 的地址
        String s4 = "11";
        System.out.println(s3 == s4); // true

        // 交换位置后 结果发生改变
        String s5 = new String("2") + new String("2");// 此时 常量池中没有 22
        String s6 = "22";
        s5.intern(); // 常量池中 未发生变化
        System.out.println(s5 == s6); // false


        //变形1
     /*   String c = new String("c") +new String("d");
        String d = c.intern();
        System.out.println(c == "cd");//true
        System.out.println(d == "cd");//true
        System.out.println(d == c);//true*/

        //变形2
        String x = "cd";
        String c = new String("c") +new String("d");
        String d = c.intern();
        System.out.println(c == "cd");//false
        System.out.println(d == "cd");//true
        System.out.println(d == c);//false

        //变形3
        String str31 = new String("a") + new String("b");
        String str32 = new String("ab");
        str31.intern();
        str32.intern();
        String str33 = "ab";
        System.out.println(str33 == str31);//false
        System.out.println(str33 == str32);//false

    }
    /*
    * 总结string的intern（）的使用：

        JDK1.6中，将这个字符串对象尝试放入串池。

        - 如果串池中有，则并不会放入。返回已有的串池中的对象的地址
        - 如果没有，会把此 对象复制一份 ，放入串池，并返回串池中的对象地址

        JDK1.7起，将这个字符串对象尝试放入串池。

        - 如果串池中有，则并不会放入。返回已有的串池中的对象的地址
        - 如果没有，则会把 对象的引用地址 复制一份，放入串池，并返回串池中的引用地址
    * */
}
