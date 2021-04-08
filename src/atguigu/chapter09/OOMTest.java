package atguigu.chapter09;

import jdk.internal.org.objectweb.asm.ClassWriter;
import jdk.internal.org.objectweb.asm.Opcodes;

import java.Mlang.String;

/**
 * 元空间溢出
 * -XX:MetaspaceSize=10M -XX:MaxMetaspaceSize=10M
 */
public class OOMTest extends ClassLoader{
    public static void main(String[] args) {
        int j = 0;
        try {
            OOMTest test = new OOMTest();
            for (int i = 0; i < 10000; i++) {
                // 创建classWriter对象，用于生成类的二进制字节码
                ClassWriter classWriter = new ClassWriter(0);
                // 创建对应的基本信息（版本号 1.8，修饰符，类名，）
                classWriter.visit(Opcodes.V1_8, Opcodes.ACC_PUBLIC, "Class"+i, null, "java/lang/Object", null);
                // 返回byte[]
                byte [] code = classWriter.toByteArray();
                // 类的加载
                test.defineClass("Class"+i,code,0,code.length);// class对象
                j++;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            System.out.println(j);
        }
    }

//    3331
// Exception in thread "main" java.lang.OutOfMemoryError: Compressed class space
}
