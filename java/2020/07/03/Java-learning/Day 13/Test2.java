import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * ת����
 * ���԰��ֽ���ת��Ϊ�ַ���
 * ���ֽ����е����ݶ����ַ�ʱ��ʹ��ת��������ת��Ϊ�ַ���Ч�ʸ���
 */
public class Test2 {
    public static void main(String[] args) {
        // ���Ե��ļ������б����ʽ��
        // ����������˵��TXT��Java�ļ�һ�����������ֱ��룬
        // ISO8859-1����ŷ���룬����Ӣ�ı��룬�������ں���
        // GBK��UTF-8��������Ӣ�ģ�����һ��ʹ��UTF-8���롣

        try {
            Test2.testInputStreamReader();
            Test2.testOutputStreamWriter();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
    /**
     * ת���ֽ�������Ϊ�ַ�������
     * ע����ת���ַ�����ʱ�����õ��ַ�������Ҫ���ȡ�ļ������ݵı���һ�£������������
     */
    public static void testInputStreamReader() throws Exception{
        FileInputStream fs = new FileInputStream("F:\\PKU\\Freshman_summer\\Java\\Day 13\\tt5.txt");

        //���ֽ���ת��Ϊ�ַ���
        InputStreamReader in = new InputStreamReader(fs, "gb2312");//����һ���ֽ������������Ǳ���

        char[] c = new char[100];

        int len = 0;
        while((len = in.read(c)) != -1){
            System.out.println(new String(c,0,len));
        }

        in.close();
        fs.close();

    }

    /**
     * ת���ֽ������Ϊ�ַ������
     */
    public static void testOutputStreamWriter() throws Exception{
        FileOutputStream out = new FileOutputStream("F:\\PKU\\Freshman_summer\\Java\\Day 13\\tt6.txt");

        OutputStreamWriter os = new OutputStreamWriter(out,"GB2312");

        os.write("���");
        os.flush();

        os.close();
        out.close();


    }
}