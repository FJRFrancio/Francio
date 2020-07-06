import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.InputStreamReader;

/**
 * 标准输入输出流
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
     * 标准输入流
     * @throws Exception
     */
    public static void testSystemIn() throws Exception{
        //创建一个接收键盘输入数据的输入流
        InputStreamReader is = new InputStreamReader(System.in);

        //把输入流放到缓冲流里
        BufferedReader br = new BufferedReader(is);

        String str = "";//定义一个临时接收数据的字符串

        while((str = br.readLine()) != null){
            System.out.println(str);
        }

        br.close();
        is.close();

    }

    /**
     * 将控制台输入的内容写到TXT文件里
     * 当接收到字符串over时，结束程序运行
     */
    public static void write2TXT() throws Exception{
        //创建一个接收键盘输入数据的输入流
        InputStreamReader is = new InputStreamReader(System.in);

        //把输入流放到缓冲流里
        BufferedReader br = new BufferedReader(is);

        BufferedWriter out = new BufferedWriter(new FileWriter("F:\\PKU\\Freshman_summer\\Java\\Day 13\\tt7.txt"));

        String line = "";
        
        while((line = br.readLine()) != null){
            if(line.equals("over")){
                break;
            }
            //读取的每一行都要写到TXT里

            out.write(line);
        }
        out.flush();
        out.close();
        br.close();
        is.close();
    }
}