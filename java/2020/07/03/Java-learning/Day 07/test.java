public class test {

    /**
     * ���⣺���Test��������һ���βΣ����ò�����ȷ�����׻ᴫ����һ��ʲô��
     * ����ȷ�����Ǵ��ݵ�ʵ��һ������һ���࣬��ôTest�������βξ�Ҫ����һ��Object�࣬��Ϊ������Խ����������ࡣ
     */
    public void Test(Object obj){

    }

    public static void main(String[] args) {
        test t = new test();
        Person p = new Person();
        Student s = new Student();

        t.Test(p);
        t.Test(p);
        t.Test(new Kk());

        Person e = new Person();
        System.out.println(p.equals(e));//Object���еķ������ж����������Ƿ�Ϊͬһ��

        Object o = new Object();
        System.out.println(o.hashCode());//��ȡ��ϣֵ

        System.out.println(p.toString());//��ӡ��ǰ������ڴ��ַ
    }
}