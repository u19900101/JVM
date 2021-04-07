package atguigu.chapter13;

import org.junit.Test;

/**
 * @author lppppp
 * @create 2021-04-07 9:01
 *
 * intern 用法：
 * intern是一个native方法，调用的是底层C的方法
 *
 * 字符串池最初是空的，由String类私有地维护。在调用intern方法时，
 * 如果池中已经包含了由equals(object)方法确定的与该字符串对象相等的字符串，
 * 则返回池中的字符串。否则，该字符串对象将被添加到池中，并返回对该字符串对象的引用。
 *
 * 如果不是用双引号声明的string对象，可以使用string提供的intern方法：
 * intern方法会从字符串常量池中查询当前字符串是否存在，
 * 若不存在就会将当前字符串放入常量池中。
 */
public class InternDemo {
    public static void main(String[] args) {
        String s = new String("jingjing").intern();
        String s2 = "jingjing";
        String s3 = new String("jingjing");

        System.out.println(s == s2);//true
        System.out.println(s == s3);//false
    }
}
