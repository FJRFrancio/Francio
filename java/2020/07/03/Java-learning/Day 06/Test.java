public class Test {
    public static void main(String[] args) {
        Person p = new Person();
        String[] ss = new String[]{"zhangsan","11"};
        p.printInfo(ss);
        String[] ss1 = new String[]{"Beijing","13333333333","5555555555555"};
        p.printInfo(ss1);

        p.printInfo1("lisi","23","Francio");
        p.printInfo1(ss1);

        p.printInfo(null);//不填null会报错
        p.printInfo1();//不填不报错
    }
}