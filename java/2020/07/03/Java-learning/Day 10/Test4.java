import java.util.Comparator;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class Test4 {
    public static void main(String[] args) {
    //     Set<Integer> set = new TreeSet<Integer>();
    //     //TreeSet��Ȼ����
    //     set.add(2);
    //     set.add(4);
    //     set.add(3);
    //     set.add(5);

    //     System.out.println(set);

    //     //ʹ�õ���������
    //     Iterator<Integer> it = set.iterator();
    //     while (it.hasNext()){

    //     }

    //     //for each
    //     for (Integer i : set){

    //     }
    
    Person p1 = new Person("zhangsan",23);
    Person p2 = new Person("lisi",20);
    Person p3 = new Person("wangwu",16);
    Person p4 = new Person("lucy",29);

    Set<Person> set = new TreeSet<Person>(new Person());
    set.add(p1);
    set.add(p2);
    set.add(p3);
    set.add(p4);

    for (Person p : set){
        System.out.println(p.name + "   " + p.age);
    }

    
    }
}

class Person implements Comparator<Person>{//��Person����浽TreeSet�в�������������
    int age;
    String name;

    public Person(){}

    public Person(String name,int age){
        this.name = name;
        this.age = age;

    }

	@Override
	public int compare(Person o1, Person o2) {//�Զ���ȽϷ���:��������������
		if (o1.age > o2.age){
            return 1;
        }else if (o1.age < o2.age){
            return -1;
        }else{
            return 0;
        }
	}
}
