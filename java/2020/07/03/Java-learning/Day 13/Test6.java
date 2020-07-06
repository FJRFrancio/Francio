import java.io.FileNotFoundException;
import java.io.RandomAccessFile;

/**
 * 文件的随机读写
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
     * 随机读取文件
     */
    public static void testRandomAccessFileRead() throws Exception {
        // RandomAccessFile构造由两个参数，参数一为读取文件的路径，参数二是文件的读取方式（访问模式）。
        RandomAccessFile ra = new RandomAccessFile("F:\\PKU\\Freshman_summer\\Java\\Day 13\\tt10.txt", "r");

        ra.seek(8);// 设置读取文件内容的起始点（字节位数）注意：换行符也算字节（/t，算两个。）

        byte[] b = new byte[1024];
        int len = 0;
        while ((len = ra.read(b)) != -1) {
            System.out.println(new String(b, 0, len));
        }

        ra.close();
    }

    /**
     * 随机写
     * 
     * @throws Exception
     */
    public static void testRandomAccessFileWrite() throws Exception {
        RandomAccessFile ra = new RandomAccessFile("F:\\PKU\\Freshman_summer\\Java\\Day 13\\tt10.txt", "rw");

        ra.seek(8);//设置写的起始点，0代表从开头写，ra.lenth()代表从文件的最后写，此时即为文件的追加。
        //注意：如果是在文件的开头或是中间的某个位置开始写，就会用写的内容覆盖掉等长度的原内容。

        ra.write("hello".getBytes());
        ra.close();



    }
    
}