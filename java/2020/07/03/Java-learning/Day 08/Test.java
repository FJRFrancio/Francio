

public class Test{
    public static void main(String[] args) {
        //Student s = new Student();
       // Person p = s;//子类给父类，可自动进行

       // Person pe = new Person();
       // Student st = (Student) pe;//强制转换

        // Test t = new Test();
        // t.method(new Person());
        // t.method(new Student());

        // Order o1 = new Order(123,"a001");
        // Order o2 = new Order(123,"a001");
        // Order o3 = new Order(123,"a002");

        // System.out.println(o1.equals(o2));
        // System.out.println(o1.equals(o3));

        // Integer i = new Integer(111);//装箱
        // Integer i1 = 112;//自动装箱
        // System.out.println(i);

        // int i0 = i.intValue();//拆箱，得到基本数据类型
        // int i2 = i1;//自动拆箱

        // int i = Integer.parseInt("123");
        // float f = Float.parseFloat("0.40");//字符串转基本数据类型

        // String istr = String.valueOf(i);//基本数据类型转字符串

        // MyDate m = new MyDate(2030,12,12);
        // System.out.println(m.toString());
        // System.out.println(m);//打印m对象相当于打印m.toString()

        // Chinese c = new Chinese();
        // //c.country = "china";
        // Chinese.country = "china";//对ststic的变量只用书写一次，用类名.属性直接访问，又称为类变量
        // c.name = "xx";
        // c.age = 11;//写多个对象时，会重复出现“China”，使用ststic可以固定China属性，
        // Chinese.test();

        // String s = "11";
        // if (s != null && !s.equals("")){//判断字符串是否为空，先判断是不是null，同时是不是“”
        //     //在未来的开发中可能会多次使用这类判断，故可写成工具类
        // }
        // System.out.println(Utils.isEmpty(s));//使用工具类
        
        // //需求，想知道new了多少个Chinese对象
        // Chinese c1 = new Chinese();
        // Chinese c2 = new Chinese();
        // Chinese c3 = new Chinese();
        // Chinese c4 = new Chinese();
        // Chinese c5 = new Chinese();

        // Chinese.showCount();

        //Single s = new Single();//不能用，构造器被私有化
        // Single s1 = Single.getInstance();
        // Single s2 = Single.getInstance();
        // Single s3 = Single.getInstance();
        // Single s4 = Single.getInstance();//不管调用几次,调用的都是私有的类变量，ststic属性意味着该对象只被实例化了一次。

        Single1 s1 = Single1.getInstance();//第一次执行时，new一个静态的对象
        Single1 s2 = Single1.getInstance();
        Single1 s3 = Single1.getInstance();
        Single1 s4 = Single1.getInstance();//不管调用几次,调用的都是私有的类变量，ststic属性意味着该对象只被实例化了一次。


    }

    

    public void method(Person e) {
        //e.getSchool();//no such method
        if (e instanceof Student){//检验是不是子类或父类关系
            Student s = (Student)e;
            s.getSchool();
        }else{
            e.test();
        }
    }
}