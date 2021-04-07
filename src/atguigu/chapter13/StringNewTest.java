package atguigu.chapter13;

/**
 * new String("ab") 会创建几个对象？ 看字节码就知道是2个对象
 *
 * String str = new String("a") + new String("b");
 * 我们创建了6个对象
 *
 * - 对象1：new StringBuilder()
 * - 对象2：new String("a")
 * - 对象3：常量池的 a
 * - 对象4：new String("b")
 * - 对象5：常量池的 b
 * - 对象6：toString中会创建一个 new String("ab")
 *   - 调用toString方法，不会在常量池中生成ab
 */
public class StringNewTest {
    public static void main(String[] args) {
        String str = new String("a") + new String("b");
    }
}
