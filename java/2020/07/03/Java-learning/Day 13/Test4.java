import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

/**
 * 数据流 专门用来做基本数据类型的读写
 */
public class Test4 {
    public static void main(String[] args) {
        try {
            Test4.testDateOutputStream();
            Test4.testDataInputStream();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    /**
     * 数据输出流
     * 用数据输出流写到文件中的基本数据类型的数据是乱码的，不能直接辨认出来
     * 需要数据的输入流来读取
     * @throws Exception
     */
    public static void testDateOutputStream() throws Exception {
        DataOutputStream out = new DataOutputStream(new FileOutputStream("F:\\PKU\\Freshman_summer\\Java\\Day 13\\tt8.txt"));

        out.writeBoolean(true);//输出的东西只能通过数据输入流才能读出来
        out.writeDouble(1.336d);
        out.flush();
        out.close();
    }

    /**
     * 数据输入流
     * 用数据输入流读取数据输出流输出的数据时，要保证使用和当时写的数据类型一致的类型来读取。
     * @throws Exception
     */
    public static void testDataInputStream() throws Exception {
        DataInputStream in = new DataInputStream(new FileInputStream("F:\\PKU\\Freshman_summer\\Java\\Day 13\\tt8.txt"));
        
        System.out.println(in.readBoolean());
        System.out.println(in.readDouble());

        in.close();
    }
}