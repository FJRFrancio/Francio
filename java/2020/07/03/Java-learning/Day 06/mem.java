
public class mem {
    /**
     * 基本数据类型的方法的参数传递
     * @param i
     */
    public static void swap(int i){
        i = 6;
        System.out.println("i in swap method: " + i);
    }

    public static void main(String[] args) {
        int a = 0;
        //先执行该句，在栈内开辟一块内存，设其地址为AD8500，存的值为0
        swap(a);
        //调用swap方法，执行int i部分，在栈中开辟一块内存，地址AD8600，值就是从a复制过来的值。然后执行swap的方法体里的代码，把
        //i在栈中的值改成6，最终i在栈中的值为6。
        System.out.println("a in main method: " + a);    
    }
    //方法不改变原参数a的值
}