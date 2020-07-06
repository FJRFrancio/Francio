import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * �����ֽ���
 */
public class Test {
    public static void main(String[] args) throws Exception {
        try {
            Test.testBufferedInputStream();
            Test.testBufferedOutputStream();
            Test.copyFile();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    /**
     * �����ֽ�������
     * 
     * @throws IOException
     */
    public static void testBufferedInputStream() throws IOException {
        // �ļ��ֽ�����������
        FileInputStream in = new FileInputStream("F:\\PKU\\Freshman_summer\\Java\\Day 13\\tt.txt");

        // �����ֽ�����������
        BufferedInputStream br = new BufferedInputStream(in);// ���ļ��ֽ��������Ž������ֽ���������

        byte[] b = new byte[10];

        int len = 0;

        while ((len = br.read(b)) != -1) {
            System.out.println(new String(b, 0, len));
        }

        in.close();
        br.close();

    }

    /**
     * �����ֽ������
     * 
     * @throws IOException
     */
    public static void testBufferedOutputStream() throws IOException {
        // �����ֽ����������
        FileOutputStream out = new FileOutputStream("F:\\PKU\\Freshman_summer\\Java\\Day 13\\tt1.txt");

        // ���ֽ����������Ž������ֽ������������
        BufferedOutputStream bo = new BufferedOutputStream(out);

        String s = "Hello World";

        bo.write(s.getBytes());

        bo.flush();

        bo.close();
        out.close();
    }

    /**
     * �û�����ʵ���ļ��ĸ���
     * 
     * @throws FileNotFoundException
     */
    public static void copyFile() throws Exception {
        //����������
        BufferedInputStream br = new BufferedInputStream(new FileInputStream("F:\\PKU\\Freshman_summer\\Java\\Day 13\\tt1.txt"));//��������

        //���������
        BufferedOutputStream bo = new BufferedOutputStream(new FileOutputStream("F:\\PKU\\Freshman_summer\\Java\\Day 13\\tt2.txt"));
        
        byte[] b = new byte[1024];

        int len = 0;

        while((len = br.read(b)) != -1){
            bo.write(b, 0, len);
        }

        bo.flush();

        bo.close();
        br.close();


    }
}