package atguigu.chapter05;

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
