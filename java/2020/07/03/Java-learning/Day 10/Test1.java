public class Test1 {
    public static void main(String[] args) throws Exception{//������main�ϼ����׳��쳣��ֱ���׸���������ڳ����в��ܴ���
        // B b = new B();
        // try {
        //     b.test();
        // }catch(Exception e){
        //     e.printStackTrace();
        // }

        B b = new B();
        try{
            b.test2(-100);
        }catch (Exception e){
            e.printStackTrace();
        }
        
        
    }
    
}


class B {
    int i;
    //NullPointerException�ĸ�����Exception
    public void test() throws NullPointerException{//ʹ��throws�ڴ��봦�׳��쳣���ڵ��÷���������
        B b = null;
        System.out.println(b.i);
    }

    int age;

    public void test1(int age) throws Exception {//�˹��׳��쳣
        if(age >= 0 && age <= 150){
            this.age = age;
            System.out.println(this.age);
        }else{
            throw new Exception("the age is out of range");
        }

    }

    public void test2(int age) throws MyException {//�˹��׳��쳣:�׳��Զ����쳣��
        if(age >= 0 && age <= 150){
            this.age = age;
            System.out.println(this.age);
        }else{
            throw new MyException("the age is out of range");
        }

    }
}

class C extends B{
    // @Override
    // public void test() throws Exception {//�����׳�Exception�����෶ΧҪ�ȸ���С��
    //     // TODO Auto-generated method stub
    //     super.test();
    // }
}

class MyException extends Exception{
    public MyException(String msg){
        super(msg);//���ø���Ĺ��췽��
    }
}