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

        Collections.reverse(list);//翻转顺序
        System.out.println(list);

        Collections.shuffle(list);//随机排序
        System.out.println(list);

        Collections.sort(list);//字典升序排列
        System.out.println(list);

        Collections.swap(list,0,4);//替换两个元素的位置，后面的两个数字为被交换位置的元素的下标

        System.out.println(Collections.max(list));//返回集合中最大值
        System.out.println(Collections.min(list));//返回最小值

        System.out.println(Collections.frequency(list, "a"));//获得某元素在集合中出现的次数

        Collections.replaceAll(list, "a", "aa");//使用新值替换掉list中所有的旧值

        Student s1 = new Student(14,"zhangsan");
        Student s2 = new Student(12,"lisi");
        Student s3 = new Student(15,"wangwu");
        Student s4 = new Student(14,"lucy");

        List<Student> stus = new ArrayList<Student>();
        stus.add(s1);
        stus.add(s2);
        stus.add(s3);
        stus.add(s4);

        for (Student stu : stus){//观察原始顺序
            System.out.println(stu.name + "," + stu.age);
        }

        Collections.sort(stus,new Student());//根据指定的Comparator产生的顺序对List排序，Comparator需要用无参构造new出来。
        System.out.println("========");
        for (Student stu : stus){//观察排序后顺序
            System.out.println(stu.name + "," + stu.age);
        }

        Student s = Collections.max(stus,new Student());//根据自定义的方法取最大值
        System.out.println(s.name + s.age);
        Student si = Collections.min(stus,new Student());//根据自定义的方法取最小值
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
    public int compare(Student o1, Student o2) {//根据年龄升序排列对象
        if (o1.age > o2.age){
            return 1;
        }else if (o1.age < o2.age){
            return -1;
        }else{
            return 0;
        }

    }
    
}