import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.InputStreamReader;

/**
 * ��׼���������
 */
public class Test3 {
    public static void main(String[] args) {
        try {
            //Test3.testSystemIn();
            Test3.write2TXT();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    /**
     * ��׼������
     * @throws Exception
     */
    public static void testSystemIn() throws Exception{
        //����һ�����ռ����������ݵ�������
        InputStreamReader is = new InputStreamReader(System.in);

        //���������ŵ���������
        BufferedReader br = new BufferedReader(is);

        String str = "";//����һ����ʱ�������ݵ��ַ���

        while((str = br.readLine()) != null){
            System.out.println(str);
        }

        br.close();
        is.close();

    }

    /**
     * ������̨���������д��TXT�ļ���
     * �����յ��ַ���overʱ��������������
     */
    public static void write2TXT() throws Exception{
        //����һ�����ռ����������ݵ�������
        InputStreamReader is = new InputStreamReader(System.in);

        //���������ŵ���������
        BufferedReader br = new BufferedReader(is);

        BufferedWriter out = new BufferedWriter(new FileWriter("F:\\PKU\\Freshman_summer\\Java\\Day 13\\tt7.txt"));

        String line = "";
        
        while((line = br.readLine()) != null){
            if(line.equals("over")){
                break;
            }
            //��ȡ��ÿһ�ж�Ҫд��TXT��

            out.write(line);
        }
        out.flush();
        out.close();
        br.close();
        is.close();
    }
}