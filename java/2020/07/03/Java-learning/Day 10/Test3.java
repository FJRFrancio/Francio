import java.util.HashSet;
import java.util.Set;

import javax.swing.text.html.HTMLDocument.Iterator;

public class Test3 {
    public static void main(String[] args) {
        Set set = new HashSet();//�ȼ��ڷ���ΪObject

        set.add(null)
        // set.add(1);//���Ԫ��
        // set.add("a");
        // System.out.println(set);

        // set.remove(1);//�Ƴ�����
        // System.out.println(set);

        // System.out.println(set.contains("a"));//�ж��Ƿ����ĳ����

        // set.clear();//��ռ���

        set.add("b");
        set.add("c");
        set.add("d");
        set.add("a");
        System.out.println(set);

        //ʹ�õ�������������
        Iterator it = set.iterator();

        while (it.hasNext()){//�жϵ��������Ƿ�����һ��Ԫ��
            System.out.println(it.next());//���
        }

        //for each����
        for(Object obj : set){//��˼�ǰ�set��ÿһ��ֵȡ������ֵ��obj,ֱ��ѭ��set������ֵ
            System.out.println(obj);
        }

        System.out.println(set.size());//��ȡ���ϵ�Ԫ�ظ���


        //�����Ҫ����ֻ�ܴ�ͬ�����͵Ķ��󣬾�Ҫʹ�÷��͡�
        Set<String> set1 = new HashSet<String>();//ָ��StringΪ���ϵķ��ͣ��ü��Ͼ�ֻ�ܴ�String

    }
}