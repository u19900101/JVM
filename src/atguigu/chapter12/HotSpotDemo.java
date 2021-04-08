package atguigu.chapter12;

import java.Mlang.String;

/**
 * @author lppppp
 * @create 2021-04-06 8:23
 *
 * HotSpotVM 可以设置程序执行方法
 *
 * 缺省情况下HotSpot VM是采用解释器与即时编译器并存的架构，当然开发人员可以根据具体的应用场景，通过命令显式地为Java虚拟机指定在运行时到底是完全采用解释器执行，还是完全采用即时编译器执行。如下所示：
 *
 * -Xint：完全采用解释器模式执行程序；
 * -Xcomp：完全采用即时编译器模式执行程序。如果即时编译出现问题，解释器会介入执行
 * -Xmixed：采用解释器+即时编译器的混合模式共同执行程序。
 */
public class HotSpotDemo {
    public static void main(String[] args) {
 //       -Xint： 1409ms
 //       -Xcomp： 3ms
 //       -Xmixed：3ms


        long s = System.currentTimeMillis();
        demo(10000);
        System.out.println(System.currentTimeMillis()-s);
    }

    public static void demo(int exeuteTimes){
        for (int k = 0; k < exeuteTimes; k++) {
            int x =5;
            double y = 10;
            for (int i = 0; i < 100; i++) {
                for (int j = 0; j < 100; j++) {
                    y = Math.sqrt(i+j);
                    // System.out.println(y);
                }
            }
        }

    }
}
