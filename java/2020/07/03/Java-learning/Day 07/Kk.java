public class Kk extends Student{
    public void test(){
        super.age = 1;//
    }
public static void main(String[] args) {
    Student s = new Student();// 调用无参构造器:父类没有无参构造，此处报错
   // Student stu2 = new Student(school);// 调用无参构造器
    Person p = new Person();
    //以上是正常情况
    Person e = new Student();//父类引用对象可以指向子类实例
    //e.school = "xxxx";// 属性是在编译时确定，编译时e为Person类型，没有Student成员变量，故编译报错

    s.showInfo();
    p.showInfo();
    //以上是正常写法，各自调用各自的方法

    e.showInfo();
    //此时调用的是Student的方法，而不是编译时报的Person的方法。出现了编译期和运行期的不同。


    p = new Student();//此时P引用的是Student实例对象，而不是之前定义的Person

}
    
}