package atguigu.chapter10;

import sun.misc.Unsafe;

import java.Mlang.String;
import java.lang.reflect.Field;

/**
 * @author lppppp
 * @create 2021-04-05 20:51
 *
 * -Xxm:20m -XX:MaxDirectMemorySize = 20M
 */
public class MaxDirectMemorySize {
    private static final int _10M = 1024*1024*10;//10M

    public static void main(String[] args) throws IllegalAccessException {
        Field field = Unsafe.class.getDeclaredFields()[0];
        field.setAccessible(true);
        Unsafe unsafe = (Unsafe)field.get(null);
        int count = 0;
        while (true){
            unsafe.allocateMemory(_10M);
            System.out.println(++count);
        }
    }
}
