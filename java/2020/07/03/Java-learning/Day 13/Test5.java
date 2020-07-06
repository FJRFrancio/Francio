import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * ���л��뷴���л�
 * ע�⣺��������л��ͷ����л�ʹ�õ���Ҫ�ϸ�һ�£�һ�µ���������������ṹ�ȵ����ж�Ҫһ�¡�
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
     * ��������л�
     */
    public static void testSerialize() throws Exception{
        //����������������Ѷ������л�֮������ŵ�ָ�����ļ��С�
        ObjectOutputStream out= new ObjectOutputStream(new FileOutputStream("F:\\PKU\\Freshman_summer\\Java\\Day 13\\tt9.txt"));
        
        Person p = new Person();
        p.name = "zhangsan";
        p.age = 11;

        out.writeObject(p);
        out.flush();
        out.close();
    }

    /**
     * ����ķ����л�
     */
    public static void testDeserialize() throws Exception{
        //�����������������󣬴�ָ�����ļ��аѶ�������л��������ȡ����
        ObjectInputStream in = new ObjectInputStream(new FileInputStream("F:\\PKU\\Freshman_summer\\Java\\Day 13\\tt9.txt"));

        Object obj = in.readObject();
        Person p = (Person) obj;//ǿת����

        System.out.println(p.name);
        System.out.println(p.age);

        in.close();
    }
}