package atguigu.chapter13;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author lppppp
 * @create 2021-04-06 10:47
 */
public class genString {
    public static void main(String[] args) throws IOException {
        FileWriter fileWriter = new FileWriter("words.txt");

        for (int i = 0; i < 100000; i++) {
            // 生成 1-10的随机数
            int len = (int) (Math.round(Math.random() * (9)) +1);
            String string = getString(len);
            fileWriter.write(string+"\n");
            System.out.println(string+"----"+string.length());
        }
        fileWriter.close();
    }


    // 随机产生一个字母
    public static String getString(int len){
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < len; i++) {
            int temp = (int) (Math.round(Math.random() * ((116 - 65))) + 65);
            temp = temp>90?temp+6:temp;
            char temp1 = (char) temp;
            s.append(temp1);
        }
        return s.toString();
    }
}
