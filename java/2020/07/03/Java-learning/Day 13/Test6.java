import java.io.FileNotFoundException;
import java.io.RandomAccessFile;

/**
 * �ļ��������д
 */
public class Test6 {
    public static void main(String[] args) {
        try {
            Test6.testRandomAccessFileRead();
            Test6.testRandomAccessFileWrite();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    /**
     * �����ȡ�ļ�
     */
    public static void testRandomAccessFileRead() throws Exception {
        // RandomAccessFile��������������������һΪ��ȡ�ļ���·�������������ļ��Ķ�ȡ��ʽ������ģʽ����
        RandomAccessFile ra = new RandomAccessFile("F:\\PKU\\Freshman_summer\\Java\\Day 13\\tt10.txt", "r");

        ra.seek(8);// ���ö�ȡ�ļ����ݵ���ʼ�㣨�ֽ�λ����ע�⣺���з�Ҳ���ֽڣ�/t������������

        byte[] b = new byte[1024];
        int len = 0;
        while ((len = ra.read(b)) != -1) {
            System.out.println(new String(b, 0, len));
        }

        ra.close();
    }

    /**
     * ���д
     * 
     * @throws Exception
     */
    public static void testRandomAccessFileWrite() throws Exception {
        RandomAccessFile ra = new RandomAccessFile("F:\\PKU\\Freshman_summer\\Java\\Day 13\\tt10.txt", "rw");

        ra.seek(8);//����д����ʼ�㣬0����ӿ�ͷд��ra.lenth()������ļ������д����ʱ��Ϊ�ļ���׷�ӡ�
        //ע�⣺��������ļ��Ŀ�ͷ�����м��ĳ��λ�ÿ�ʼд���ͻ���д�����ݸ��ǵ��ȳ��ȵ�ԭ���ݡ�

        ra.write("hello".getBytes());
        ra.close();



    }
    
}