import java.util.ArrayList;
import java.util.List;

public class Test5 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();
        list.add("b");//��һ���������±�Ϊ0
        list.add("d");
        list.add("c");
        list.add("a");
        list.add("a");//Ԫ�ؿ��ظ�

        System.out.println(list);//�����˳������
        System.out.println(list.get(2));//ȡ�������ʼ���

        list.add(1,"f");//��λ��1���롰f"

        List<String> l = new ArrayList<String>();
        l.add("123");
        l.add("456");

        list.addAll(2,l);//���뼯��

        System.out.println(list.indexOf("d"));//��ȡָ��Ԫ���ڼ����е�һ�γ��ֵ������±�
        System.out.println(list.lastIndexOf("d"));//���һ�γ��ֵ������±�

        list.remove(2);//����ָ���������±��Ƴ�Ԫ��

        list.set(1,"ff");//����ָ�������±�λ�õ����ݵ�ֵ

        List<String> subl = list.subList(2, 4);//����Ԫ�صĽ�ȡ�����������±��λ�á���ȡʱ������ʼʱ������������������ʱ��������

        System.out.println(list.size());//���ϵĳ���

    }
    
}