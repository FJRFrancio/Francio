public class Test{
    public static void main(String[] args) {
        // String[] strs = new String[]{"a","b","c"};

        // for (int i = 0; i < 4; i++ ){
        //     System.out.println(strs[i]);//数组越界异常java.lang.ArrayIndexOutOfBoundsException
        // }

        // A a = new A();
        // A a = null;
        // System.out.println(a.i);//空指针异常java.lang.NullPointerException

        // int i = 0;
        // try{//用try{}扩住一段可能出现的异常代码段
        //     System.out.println(3/i);//运算错误java.lang.ArithmeticException: / by zero
        // }catch(Exception e){//当不知道捕获的是什么类型的异常时，可以直接使用所有异常的父类Exception
        //     e.printStackTrace();
        //     System.out.println(e.getMessage());//输出异常，catch里可以啥都不写
        // }finally{
        //     //可写可不写，这是在捕获异常的过程中一定会执行的操作
        // }

        String[] strs = new String[]{"a","b"};
        A a = null;
            try{//try catch为了防止程序可能出现的异常
                System.out.println(strs[2]);//数组越界
                System.out.println(a.i);//空指针
            }catch (ArrayIndexOutOfBoundsException ei){
                System.out.println(ei.getMessage());
            }catch(NullPointerException e2){
                System.out.println(e2.getMessage());
            }
            System.out.println("=====");

    }
}

class A{
    int i;

}