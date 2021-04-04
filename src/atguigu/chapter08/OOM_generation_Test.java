package atguigu.chapter08;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * OOM测试
 *
 *配置新生代与老年代在堆结构的占比。
 *
 * - 默认-XX:NewRatio=2，表示新生代占1，老年代占2，新生代占整个堆的1/3
 *
 * - 可以修改-XX:NewRatio=4，表示新生代占1，老年代占4，新生代占整个堆的1/5
 *
 * 在HotSpot中，Eden空间和另外两个survivor空间缺省所占的比例是8：1：1
 * 当然开发人员可以通过选项“-xx:SurvivorRatio”调整这个空间比例。
 * 比如-xx:SurvivorRatio=8
 */
public class OOM_generation_Test {
    public static void main(String[] args) throws InterruptedException {
        List<Picture> list = new ArrayList<>();
        while(true) {
            Thread.sleep(20);
            list.add(new Picture(new Random().nextInt(1024*1024)));
        }
    }


}

class Picture{
    private byte[] pixles;
    Picture(int length){
        this.pixles = new byte[length];
    }
}