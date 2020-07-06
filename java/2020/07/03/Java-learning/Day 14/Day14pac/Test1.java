package Day14pac;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Test1 {
    public static void main(String[] args) {
        try {
            Class clazz = Class.forName("Day14pac.Student");// 通过包名.类名的字符串调用Class.forName方法获取指定类的实例

            Class superClazz = clazz.getSuperclass();// 获取父类
            System.out.println(superClazz.getName());

            Class[] interfaces = clazz.getInterfaces();// 获取当前类的所有接口
            for (Class c : interfaces) {
                System.out.println(c.getName());
            }

            Constructor[] cons = clazz.getConstructors();// 获取类的公有构造方法

            for (Constructor c : cons) {

                System.out.println(c.getName());// 获取方法名称
                System.out.println(c.getModifiers());// 获取方法的修饰符。

                Class[] paramClazz = c.getParameterTypes();// 获取构造方法的参数类型,有几个参数数组里就就有几个元素
                for (Class pc : paramClazz) {
                    System.out.println("------------------------");
                    System.out.println(pc.getName());
                }
            }

            Constructor[] cons1 = clazz.getDeclaredConstructors();// 获取所有构造方法

            for (Constructor c : cons1) {

                System.out.println(c.getName());// 获取方法名称
                System.out.println(c.getModifiers());// 获取方法的修饰符。

                Class[] paramClazz = c.getParameterTypes();// 获取构造方法的参数类型
                for (Class pc : paramClazz) {
                    System.out.println("------------------------");
                    System.out.println(pc.getName());
                }
            }

            // 通过反射创建对象
            try {
                Object obj = clazz.newInstance();//相当于调用类的无参公有构造，返回值为Object类型
                Student stu = (Student) obj;
                System.out.println(stu.school);

                Constructor c = clazz.getConstructor(String.class);//此处参数填的是class类型的参数，参数前面要点上所调用构造器中参数的类型,构造器需要为公有的。
                Student stul = (Student) c.newInstance("PKU");//此时返回值仍为Object类型,要强转成Student类型
                System.out.println(stul.school);

                //可以通过反射机制，强制破除封装，调用私有方法。
                Constructor c1 = clazz.getDeclaredConstructor(String.class,int.class);//指定获取有两个参数的私有构造方法

                c1.setAccessible(true);//解除私有封装，此后即可对私有方法强制调用。
                Student stu1 = (Student) c.newInstance("PKU",18);

            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } 


            //Method[] ms = clazz.getMethods();//获取类的全部公有的方法
            Method[] ms = clazz.getDeclaredMethods();//获取类的所有方法，包含公有哈私有

            for(Method m : ms){
                System.out.println(m.getName());//方法名
                System.out.println(m.getReturnType());//返回值类型
                System.out.println(m.getModifiers());//获取修饰符

                Class[] pcs = m.getParameterTypes();//获取方法的参数类型，是一个数组，性质与前述构造方法时的同名方法一致
                if (pcs != null && pcs.length > 0){
                    for(Class pc : pcs){
                        System.out.println(pc.getName());
                    }
                }
                System.out.println("===========================");
            }

            Field[] fs =  clazz.getFields();//获取类的公有属性，包含了父类的公有属性
            Field[] fs1 =  clazz.getDeclaredFields();//获取类的所有属性，只包含本类的属性

            for(Field f : fs){
                System.out.println(f.getModifiers());//修饰符
                System.out.println(f.getType());//类型
                System.out.println(f.getName());//名称
            }

            Package p = clazz.getPackage();//获取类所在的包
            System.out.println(p.getName());

            /**
             * 注意：下面调用的方法都是obj对象的方法，此处obj对象实际上是Student对象。
             */
            //调用setInfo方法
            Constructor con = clazz.getConstructor();//获取无参构造
            Object obj = con.newInstance();//使用无参构造创建对象
            Method m = clazz.getMethod("setInfo",String.class,String.class);//传入两个参数：方法名和数据类型,由此得到了名称为setInfo，参数是String String 的方法
            m.invoke(obj, "zhangsan","PKU");//参数一是需要实例化的对象，后面的参数是调用当前的方法的实际参数。


            //如果想调用一个私有方法
            Method m1 = clazz.getDeclaredMethod("test", String.class);
            m1.setAccessible(true);//解除封装
            m1.invoke(obj, "zhangsan");


            //调用重载方法
            Method m2 = clazz.getMethod("setInfo",int.class);//setInfo 的重载方法
            m2.invoke(obj, 123);

            //调用有返回值的方法
            Method m3 = clazz.getMethod("getSchool");
            String school = (String)m3.invoke(obj);
            System.out.println(school);
            
            //反射创建一个对象(公有)
            Constructor con1 = clazz.getConstructor();
            Student stu = (Student)con.newInstance();

            Field f = clazz.getField("school");//获取名称为school的属性

            f.set(stu,"PKU");//对stu对象的school属性设置值
            String sch = (String)f.get(stu);//获取stu对象的school属性的值
            System.out.println(sch);

            //对私有属性
            Field f1 = clazz.getDeclaredField("privateField");
            f1.setAccessible(true);
            f1.set(stu,"test");
            System.out.println(f1.get(stu));


        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
}