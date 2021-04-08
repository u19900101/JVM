package atguigu.chapter15;

import java.Mlang.String;
import java.util.ArrayList;
import java.util.List;

/**
 * @author lppppp
 * @create 2021-04-07 22:10
 *
 * -XX:+PrintGCDetails
 */
public class StopTheWorldDemo {
    public static void main(String[] args) {
        PrintThread printThread = new PrintThread();
        WorkThread workThread = new WorkThread();
        printThread.start();
        workThread.start();
    }
    @Override
    protected void finalize() throws Throwable {
        System.out.println("调用鸟");
    }
}

class WorkThread extends Thread{
    @Override
    public void run() {
        List<byte[]> bytes = new ArrayList<>();
        while (true){
            for (int i = 0; i < 10000; i++) {
                bytes.add(new byte[1024]);
            }

            if(bytes.size()>1000){
                // System.out.println("进入回收");
                bytes.clear();
                // bytes = null;
                System.gc();
                // System.runFinalization();//可以强制调用
            }
        }
    }


}
class PrintThread extends Thread{
    @Override
    public void run() {
        long start = System.currentTimeMillis();
        try {
            while (true){
                long t = System.currentTimeMillis() - start;
                System.out.println(t/1000.0);
                Thread.sleep(1000);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
