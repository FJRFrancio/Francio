import java.util.ArrayList;
import java.util.List;


public class Test {
    public static void main(String[] args) {
        List list = new ArrayList();
        list.add(1111);
        list.add(true);
        list.add("abc");//��ָ�����ͣ����Դ�������͵�����

        //����ֻ���ڼ����д��ַ���
        List<String> l = new ArrayList<String>();
        l.add("a");
        //l.add(1);//ֻ�����ַ����������ڼ��ɷ������⡢

        A<String> a1 = new A<String>();//��new A�Ķ���ָ���˷���
        a1.setKey("xxxx");//����ʹ�õ�set������key���βμ���ΪString���͡�
        String s = a1.getKey();

        A<Integer> a2 = new A<Integer>();
        a2.setKey(1);//����ʹ�õ�set������key���βμ���ΪInteger���͡�
        Integer s2 = a2.getKey();

        A a3 = new A();//��ָ�����ͣ�Ĭ��Object
        a3.setKey(1);
        Object s3 = a3.getKey();
        
        //ͬ�����࣬����new����ʱ����ָ���˲�ͬ���������ͣ���Щ�����ܻ��ำֵ
        //a1 = a2;//���ܻ��ำֵ

    }
}
/**
 * �˴��ķ���T���������ȡ����
 * @param <T>
 */
class A<T>{//������һ����֪��ɶ���͵ķ���T,ʹ��ʱ������һ����������
    private T key;

    public void setKey(T key){
        this.key = key;
    }

    public T getKey(){
        return this.key;
    }
}