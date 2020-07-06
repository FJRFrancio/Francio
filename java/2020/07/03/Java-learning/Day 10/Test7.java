import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Test7 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();
        list.add("b");
        list.add("cd");
        list.add("ca");
        list.add("a");
        list.add("a");
        list.add("1");

        System.out.println(list);

        Collections.reverse(list);//��ת˳��
        System.out.println(list);

        Collections.shuffle(list);//�������
        System.out.println(list);

        Collections.sort(list);//�ֵ���������
        System.out.println(list);

        Collections.swap(list,0,4);//�滻����Ԫ�ص�λ�ã��������������Ϊ������λ�õ�Ԫ�ص��±�

        System.out.println(Collections.max(list));//���ؼ��������ֵ
        System.out.println(Collections.min(list));//������Сֵ

        System.out.println(Collections.frequency(list, "a"));//���ĳԪ���ڼ����г��ֵĴ���

        Collections.replaceAll(list, "a", "aa");//ʹ����ֵ�滻��list�����еľ�ֵ

        Student s1 = new Student(14,"zhangsan");
        Student s2 = new Student(12,"lisi");
        Student s3 = new Student(15,"wangwu");
        Student s4 = new Student(14,"lucy");

        List<Student> stus = new ArrayList<Student>();
        stus.add(s1);
        stus.add(s2);
        stus.add(s3);
        stus.add(s4);

        for (Student stu : stus){//�۲�ԭʼ˳��
            System.out.println(stu.name + "," + stu.age);
        }

        Collections.sort(stus,new Student());//����ָ����Comparator������˳���List����Comparator��Ҫ���޲ι���new������
        System.out.println("========");
        for (Student stu : stus){//�۲������˳��
            System.out.println(stu.name + "," + stu.age);
        }

        Student s = Collections.max(stus,new Student());//�����Զ���ķ���ȡ���ֵ
        System.out.println(s.name + s.age);
        Student si = Collections.min(stus,new Student());//�����Զ���ķ���ȡ��Сֵ
        System.out.println(si.name + si.age);
    }
}

class Student implements Comparator<Student>{
    int age;
    String name;

    public Student(){}
    public Student(int age,String name ){
        this.age = age;
        this.name = name;
    }

    @Override
    public int compare(Student o1, Student o2) {//���������������ж���
        if (o1.age > o2.age){
            return 1;
        }else if (o1.age < o2.age){
            return -1;
        }else{
            return 0;
        }

    }
    
}