
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;

/**
 * �����ַ���
 */
public class Test1 {
    public static void main(String[] args) throws Exception {
        Test1.testBufferedReader();
        Test1.testBufferedWriter();
        Test1.copyFile();
    }

    /**
     * �����ַ�������
     * 
     * @throws Exception
     */
    public static void testBufferedReader() throws Exception {
        FileReader r = new FileReader("F:\\PKU\\Freshman_summer\\Java\\Day 13\\tt.txt");

        BufferedReader br = new BufferedReader(r);

        char[] c = new char[100];

        int len = 0;

        while ((len = br.read(c)) != -1) {
            System.out.println(new String(c, 0, len));
        }

        br.close();
        r.close();
    }

    /**
     * �����ַ������
     * 
     * @throws Exception
     */
    public static void testBufferedWriter() throws Exception {
        FileWriter fw = new FileWriter("F:\\PKU\\Freshman_summer\\Java\\Day 13\\tt3.txt");

        BufferedWriter bw = new BufferedWriter(fw);

        String s = "hello world";

        bw.write(s);
        bw.flush();

        bw.close();
        fw.close();
    }

    /**
     * �����ַ��������ļ�
     * 
     * @throws Exception
     */
    public static void copyFile() throws Exception {
        BufferedReader br = new BufferedReader(new FileReader("F:\\PKU\\Freshman_summer\\Java\\Day 13\\tt3.txt"));

        BufferedWriter bw = new BufferedWriter(new FileWriter("F:\\PKU\\Freshman_summer\\Java\\Day 13\\tt4.txt"));

        char[] c = new char[100];

        int len = 0;

        while((len = br.read(c)) != -1){
            bw.write(c,0,len);
        }

        bw.flush();

        bw.close();
        br.close();

    }
}