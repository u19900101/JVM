package atguigu.chapter05;

/**
 * @author lppppp
 * @create 2021-04-04 9:48
 */
public class VirtualTest {

}


class Father{
    public static void staticShow(){
        System.out.println("father staticShow...");
    }

    private void privateShow(){
        System.out.println("father privateShow...");
    }

    void finalShow(){
        System.out.println("father finalShow...");
    }
}

class Son extends Father{
    public void sonShow(){
        System.out.println("son show ...");
        super.finalShow();
        finalShow();
        super.staticShow();
        staticShow();

    }


}
