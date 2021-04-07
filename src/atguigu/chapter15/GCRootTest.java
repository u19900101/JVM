package atguigu.chapter15;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

/**
 * @author lppppp
 * @create 2021-04-07 19:29
 *
 * 使用JProfile 查看 GCRoot
 */
public class GCRootTest {
    public static void main(String[] args) {
        List<Object> numList = new ArrayList<>();
        Date birth  = new Date();
        for (int i = 0; i < 100; i++) {
            numList.add(String.valueOf(i));
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("数据添加完毕，请继续操作...");
        new Scanner(System.in).next();
        numList = null;
        birth  = null;

        System.out.println("已制空....,输入结束");

        new Scanner(System.in).next();
        System.out.println("OVER...");
    }
}
