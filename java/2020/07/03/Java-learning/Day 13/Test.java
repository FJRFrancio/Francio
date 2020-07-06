import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 缓冲字节流
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
     * 缓冲字节输入流
     * 
     * @throws IOException
     */
    public static void testBufferedInputStream() throws IOException {
        // 文件字节输入流对象
        FileInputStream in = new FileInputStream("F:\\PKU\\Freshman_summer\\Java\\Day 13\\tt.txt");

        // 缓冲字节输入流对象
        BufferedInputStream br = new BufferedInputStream(in);// 把文件字节输入流放进缓冲字节输入流里

        byte[] b = new byte[10];

        int len = 0;

        while ((len = br.read(b)) != -1) {
            System.out.println(new String(b, 0, len));
        }

        in.close();
        br.close();

    }

    /**
     * 缓冲字节输出流
     * 
     * @throws IOException
     */
    public static void testBufferedOutputStream() throws IOException {
        // 创建字节输出流对象
        FileOutputStream out = new FileOutputStream("F:\\PKU\\Freshman_summer\\Java\\Day 13\\tt1.txt");

        // 把字节输出流对象放进缓冲字节输出流对象里
        BufferedOutputStream bo = new BufferedOutputStream(out);

        String s = "Hello World";

        bo.write(s.getBytes());

        bo.flush();

        bo.close();
        out.close();
    }

    /**
     * 用缓冲流实现文件的复制
     * 
     * @throws FileNotFoundException
     */
    public static void copyFile() throws Exception {
        //缓冲输入流
        BufferedInputStream br = new BufferedInputStream(new FileInputStream("F:\\PKU\\Freshman_summer\\Java\\Day 13\\tt1.txt"));//匿名对象

        //缓冲输出流
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