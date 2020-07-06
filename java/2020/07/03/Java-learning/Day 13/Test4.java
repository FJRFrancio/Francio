import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

/**
 * ������ ר�������������������͵Ķ�д
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
     * ���������
     * �����������д���ļ��еĻ����������͵�����������ģ�����ֱ�ӱ��ϳ���
     * ��Ҫ���ݵ�����������ȡ
     * @throws Exception
     */
    public static void testDateOutputStream() throws Exception {
        DataOutputStream out = new DataOutputStream(new FileOutputStream("F:\\PKU\\Freshman_summer\\Java\\Day 13\\tt8.txt"));

        out.writeBoolean(true);//����Ķ���ֻ��ͨ���������������ܶ�����
        out.writeDouble(1.336d);
        out.flush();
        out.close();
    }

    /**
     * ����������
     * ��������������ȡ������������������ʱ��Ҫ��֤ʹ�ú͵�ʱд����������һ�µ���������ȡ��
     * @throws Exception
     */
    public static void testDataInputStream() throws Exception {
        DataInputStream in = new DataInputStream(new FileInputStream("F:\\PKU\\Freshman_summer\\Java\\Day 13\\tt8.txt"));
        
        System.out.println(in.readBoolean());
        System.out.println(in.readDouble());

        in.close();
    }
}