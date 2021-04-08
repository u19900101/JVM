package atguigu.chapter10;

import java.Mlang.String;
import java.nio.ByteBuffer;
import java.util.ArrayList;

/**
 * @author lppppp
 * @create 2021-04-05 20:42
 *
 * 直接内存OOM
 */
public class BufferTest1 {
    private static final int BUFFER = 1024*1024*10;//10M

    public static void main(String[] args) {
        ArrayList<ByteBuffer> list = new ArrayList<>();
        int count = 0;
        try {
            while (true){
                ByteBuffer byteBuffer = ByteBuffer.allocate(BUFFER);
                list.add(byteBuffer);
                count++;
            }
        }finally {
            System.out.println(count);
        }
    //Exception in thread "main" java.lang.OutOfMemoryError:
        //                                                  Java heap space

    }
}
