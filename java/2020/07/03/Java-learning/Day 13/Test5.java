import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * 序列化与反序列化
 * 注意：对象的序列化和反序列化使用的类要严格一致，一致到包名、类名、类结构等等所有都要一致。
 */
public class Test5 {
    public static void main(String[] args) {
        try {
            Test5.testSerialize();
            Test5.testDeserialize();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    /**
     * 对象的序列化
     */
    public static void testSerialize() throws Exception{
        //定义对象的输出流，把对象序列化之后的流放到指定的文件中。
        ObjectOutputStream out= new ObjectOutputStream(new FileOutputStream("F:\\PKU\\Freshman_summer\\Java\\Day 13\\tt9.txt"));
        
        Person p = new Person();
        p.name = "zhangsan";
        p.age = 11;

        out.writeObject(p);
        out.flush();
        out.close();
    }

    /**
     * 对象的反序列化
     */
    public static void testDeserialize() throws Exception{
        //创建对象输入流对象，从指定的文件中把对象的序列化后的流读取出来
        ObjectInputStream in = new ObjectInputStream(new FileInputStream("F:\\PKU\\Freshman_summer\\Java\\Day 13\\tt9.txt"));

        Object obj = in.readObject();
        Person p = (Person) obj;//强转类型

        System.out.println(p.name);
        System.out.println(p.age);

        in.close();
    }
}