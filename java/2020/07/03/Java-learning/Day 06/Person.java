public class Person {

    public Person(){}



    /**
     * 用数组的方式传递可变个数的参数
     * @param args
     */
    public void printInfo(String[] args){//要求打印出的信息全部来源于形参
        //但现在并不能确定参数可以传进多少个
        for (int i = 0;i < args.length; i++){
            System.out.println(args[i]);
        }
    }
    /**
     * 用Java特有的...方式传递可变参数，这种参数在使用时与数组的使用方式相同。
     * 这种...代表可以传递0到多个参数
     * 可变形参一定要放在所有参数的最后。
     * @param args
     */

    public void printInfo1(String...args){
        for (int i = 0;i < args.length; i++){
            System.out.println(args[i]);
        }
    }
}