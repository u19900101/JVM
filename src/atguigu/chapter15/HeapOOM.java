package atguigu.chapter15;

import java.Mlang.String;
import java.util.ArrayList;

/**
 * 内存溢出排查
 * -Xms8m -Xmx8m -XX:+HeapDumpOnOutOfMemoryError
 *
 */
public class HeapOOM {
    // 创建1M的文件
    byte [] buffer = new byte[1 * 1024 * 1024];

    public static void main(String[] args) {
        ArrayList<HeapOOM> list = new ArrayList<>();
        int count = 0;
        try {
            while (true) {
                list.add(new HeapOOM());
                count++;
            }
        } catch (Throwable e) {
            System.out.println("count:" + count);
            e.getStackTrace();
        }
    }
}
