import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * 转换流
 * 可以把字节流转换为字符流
 * 当字节流中的数据都是字符时，使用转换流将其转换为字符流效率更高
 */
public class Test2 {
    public static void main(String[] args) {
        // 所以的文件都是有编码格式的
        // 对于我们来说，TXT与Java文件一般来讲有三种编码，
        // ISO8859-1：西欧编码，纯粹英文编码，不适用于汉字
        // GBK和UTF-8适用于中英文，我们一般使用UTF-8编码。

        try {
            Test2.testInputStreamReader();
            Test2.testOutputStreamWriter();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
    /**
     * 转换字节输入流为字符输入流
     * 注意在转换字符流的时候，设置的字符集编码要与读取文件的数据的编码一致，否则出现乱码
     */
    public static void testInputStreamReader() throws Exception{
        FileInputStream fs = new FileInputStream("F:\\PKU\\Freshman_summer\\Java\\Day 13\\tt5.txt");

        //把字节流转换为字符流
        InputStreamReader in = new InputStreamReader(fs, "gb2312");//参数一是字节流，参数二是编码

        char[] c = new char[100];

        int len = 0;
        while((len = in.read(c)) != -1){
            System.out.println(new String(c,0,len));
        }

        in.close();
        fs.close();

    }

    /**
     * 转换字节输出流为字符输出流
     */
    public static void testOutputStreamWriter() throws Exception{
        FileOutputStream out = new FileOutputStream("F:\\PKU\\Freshman_summer\\Java\\Day 13\\tt6.txt");

        OutputStreamWriter os = new OutputStreamWriter(out,"GB2312");

        os.write("你好");
        os.flush();

        os.close();
        out.close();


    }
}