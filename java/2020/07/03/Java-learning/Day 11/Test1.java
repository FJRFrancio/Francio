public class Test1 {
    public static void main(String[] args) {
        B1<Object> b1 = new B1<Object>();//B1��ʹ��ʱ��Ҫ��ӷ���

        B2 b2 = new B2();//B2�������Ѿ�ȷ���˷��ͣ��ʲ���Ҫָ������

        Cc<Object> c  = new Cc<Object>();
        c.test2("xxx");
        //���ͷ����ڵ���֮ǰû�й̶����������ͣ��ڵ���ʱ������Ĳ�����ʲô���;ͻ�ѷ��͸���ʲô���͡�
        Boolean b = c.test3(true);
        Integer i = c.test3(1323);//���ͷ���ʹ��ʱ�����⴫�����ݣ�������������ͼ�ȷ����

    }
    
}

interface IB<T>{//�����͵Ľӿ�
    T test(T t);
}

class B1<T> implements IB<T>{//δ���뷺��ʵ�Σ��໹��ʹ�÷��ͣ�û��ʵ��ָ�����ͣ���ӿ�һ�¡�

    @Override
    public T test(T t) {
        // TODO Auto-generated method stub
        return t;
    }
    
}
/**
 * ���ʵ�ֽӿ�ʱָ���ӿڵķ������ݾ�������
 * �����ʵ�ֽӿ����з�����λ�ö�Ҫ�������滻��ʵ���������͡�
 */

class B2 implements IB<String>{

    @Override
    public String test(String t) {//���뷺��ʵ�Σ���д���ַ���ȫ������
        // TODO Auto-generated method stub
        return null;
    }
    
}

class Cc<E>{
    private E e;

    public static <T> void test5(T t){
        System.out.println(this.e);//ע�⣺��̬��������ʹ�����϶���ķ��͡�
        System.out.println(t);//���Ҫʹ�÷��ͣ�ֻ���þ�̬�����Լ�����ķ���
    }


    public void test(String s){//��ͨ����

    }

    public <T> void test2(T s){//���ͷ���
        T t = s;
        System.out.println(this.e);//�����϶���ķ��Ϳ�������ͨ������ʹ��

    }

    public String test1(String s){//�з���ֵ��ͨ����
        return s;
    }

    public <T> T test3(T s){//�з���ֵ�ķ��ͷ���
        return s;
    }

    public void test4(String...strs){//�ɱ��������ͨ����
        for(String s : strs){
            System.out.println(s);
        }
    }

    public <T> void test4(T...strs){//�ɱ�����ķ��ͷ���
        for(T s : strs){
            System.out.println(s);
        }
    }
}