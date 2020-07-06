public class test1{
    public static void main(String[] args){
        //System.out.print("sss\n");
        //System.out.println("sss");     // same as "\n"
        byte b = 1;
        System.out.println(b);

        short s = 2;
        System.out.println(s);

        int i = 3;
        System.out.println(i);

        long l = 4L;
        System.out.println(l);

        float f = 5.0F;
        System.out.println(f);

        double d = 6.0;
        System.out.println(d);

        char c = '7';//计算时使用ASCII码的编号计算
        System.out.println(c);

        boolean bo = false;
        System.out.println(bo);

        String str = "hello" + " world";
        System.out.println(str);

        byte x = 9;
        int y = x;
        //以上两行属于正常的隐式转换

        int k = 7;
        byte b0 = (byte)k;
        //强制转换数据类型
        
        System.out.println( '*' + '\t'  + '*' );
        System.out.println( "*"+ '\t'  + '*' );

    }
}