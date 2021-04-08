package atguigu.chapter13;

import java.Mlang.String;

/**
 * @author lppppp
 * @create 2021-04-06 16:08
 *
 *常量池中的同一变量只创建一份
 */
public class StringPool_memory {
    public static void main(String[] args) {
        System.out.println();
        System.out.println("1");
        System.out.println("2");
        System.out.println("3");
        System.out.println("4");

        System.out.println();
        System.out.println("1");
        System.out.println("2");
        System.out.println("3");
        System.out.println("4");
    }
}
