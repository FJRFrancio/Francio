public class Test{
    public static void main(String[] args) {
        // String[] strs = new String[]{"a","b","c"};

        // for (int i = 0; i < 4; i++ ){
        //     System.out.println(strs[i]);//����Խ���쳣java.lang.ArrayIndexOutOfBoundsException
        // }

        // A a = new A();
        // A a = null;
        // System.out.println(a.i);//��ָ���쳣java.lang.NullPointerException

        // int i = 0;
        // try{//��try{}��סһ�ο��ܳ��ֵ��쳣�����
        //     System.out.println(3/i);//�������java.lang.ArithmeticException: / by zero
        // }catch(Exception e){//����֪���������ʲô���͵��쳣ʱ������ֱ��ʹ�������쳣�ĸ���Exception
        //     e.printStackTrace();
        //     System.out.println(e.getMessage());//����쳣��catch�����ɶ����д
        // }finally{
        //     //��д�ɲ�д�������ڲ����쳣�Ĺ�����һ����ִ�еĲ���
        // }

        String[] strs = new String[]{"a","b"};
        A a = null;
            try{//try catchΪ�˷�ֹ������ܳ��ֵ��쳣
                System.out.println(strs[2]);//����Խ��
                System.out.println(a.i);//��ָ��
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