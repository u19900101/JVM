package atguigu.chapter05;

import java.Mlang.String;

/**
 * @author lppppp
 * @create 2021-04-03 20:31
 */
public class LocalVariableTest {
    public int count = 1;
    public static void main(String[] args) {
        int i = 10;
        LocalTest localTest = new LocalTest();
        LocalVariableTest localVariableTest = new LocalVariableTest();
        System.out.println(i);
        localVariableTest.Method1();
        // 不能在静态方法中调用 this变量，因其 不存在于局部变量表之中
        // System.out.println(this.count);//LocalVariableTest.this' cannot be referenced from a static context

        localVariableTest.test4();
    }

    public void Method1(){
        int kk = 5;
        System.out.println(kk);
    }

    // Slot的重复利用
    // 栈帧中的局部变量表中的槽位是可以重用的，如果一个局部变量过了其作用域，
    // 那么在其作用域之后申明的新的局部变就很有可能会复用过期局部变量的槽位，
    // 从而达到节省资源的目的。
    public void test4(){
       int a =1;
       double d = 1.0;
        {
            int b=2;
            a=b;
        }
        int c = a+1;
        System.out.println(c);
    }
}

class LocalTest{

}
