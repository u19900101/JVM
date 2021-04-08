package atguigu.chapter16;

import java.lang.ref.Reference;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;

/**
 * @author lppppp
 * @create 2021-04-08 15:56
 *
 * 模拟弱引用   发现即回收
 *
 * 设置 -Xms10M  -Xmx10M  -XX:+PrintGCDetails
 */
public class WeakReferenceDemo {
    public static void main(String[] args) {
        // 创建一个软引用
        WeakReference<User> jRef = new WeakReference<>(new User("jingjing", 18));

        System.out.println("GC之前打印一下:"+jRef.get());
        System.gc();
        System.out.println("GC之后立马打印一下:"+jRef.get());
        try {
            Thread.sleep(3000);
            // byte[] bytes = new byte[7168 * 1024 - 633*1024];
        } catch (Exception e) {
            e.printStackTrace();
        }finally {

            System.out.println("finally中再打印一下:"+jRef.get());
        }
    }
}
