package atguigu.chapter16;

import java.Mlang.String;
import java.lang.ref.SoftReference;

/**
 * @author lppppp
 * @create 2021-04-08 15:56
 *
 * 模拟软引用  不足即回收
 * 当内存足够时  手动gc也不会释放弱引用，
 * 当内存不足或者紧张时，手动gc就会释放弱引用
 *
 * 设置 -Xms10M  -Xmx10M  -XX:+PrintGCDetails
 */
public class SoftReferenceDemo {
    public static void main(String[] args) {
        // 创建一个软引用
        SoftReference<User> jRef = new SoftReference<>(new User("jingjing", 18));

        /*  等价于
        User jingjing = new User("jingjing", 18);
        SoftReference<User> jingjing = new SoftReference<>(jingjing);
        jingjing = null;
        */
        System.out.println("GC之前打印一下:"+jRef.get());
        System.gc();
        System.out.println("GC之后立马一下:"+jRef.get());
        try {
            // Thread.sleep(3000);
            byte[] bytes = new byte[7168 * 1024 - 633*1024];
        } catch (Exception e) {
            e.printStackTrace();
        }finally {

            System.out.println("finally中再打印一下:"+jRef.get());
        }
    }
}
