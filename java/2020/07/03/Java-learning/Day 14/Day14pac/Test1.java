package Day14pac;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Test1 {
    public static void main(String[] args) {
        try {
            Class clazz = Class.forName("Day14pac.Student");// ͨ������.�������ַ�������Class.forName������ȡָ�����ʵ��

            Class superClazz = clazz.getSuperclass();// ��ȡ����
            System.out.println(superClazz.getName());

            Class[] interfaces = clazz.getInterfaces();// ��ȡ��ǰ������нӿ�
            for (Class c : interfaces) {
                System.out.println(c.getName());
            }

            Constructor[] cons = clazz.getConstructors();// ��ȡ��Ĺ��й��췽��

            for (Constructor c : cons) {

                System.out.println(c.getName());// ��ȡ��������
                System.out.println(c.getModifiers());// ��ȡ���������η���

                Class[] paramClazz = c.getParameterTypes();// ��ȡ���췽���Ĳ�������,�м�������������;��м���Ԫ��
                for (Class pc : paramClazz) {
                    System.out.println("------------------------");
                    System.out.println(pc.getName());
                }
            }

            Constructor[] cons1 = clazz.getDeclaredConstructors();// ��ȡ���й��췽��

            for (Constructor c : cons1) {

                System.out.println(c.getName());// ��ȡ��������
                System.out.println(c.getModifiers());// ��ȡ���������η���

                Class[] paramClazz = c.getParameterTypes();// ��ȡ���췽���Ĳ�������
                for (Class pc : paramClazz) {
                    System.out.println("------------------------");
                    System.out.println(pc.getName());
                }
            }

            // ͨ�����䴴������
            try {
                Object obj = clazz.newInstance();//�൱�ڵ�������޲ι��й��죬����ֵΪObject����
                Student stu = (Student) obj;
                System.out.println(stu.school);

                Constructor c = clazz.getConstructor(String.class);//�˴����������class���͵Ĳ���������ǰ��Ҫ���������ù������в���������,��������ҪΪ���еġ�
                Student stul = (Student) c.newInstance("PKU");//��ʱ����ֵ��ΪObject����,Ҫǿת��Student����
                System.out.println(stul.school);

                //����ͨ��������ƣ�ǿ���Ƴ���װ������˽�з�����
                Constructor c1 = clazz.getDeclaredConstructor(String.class,int.class);//ָ����ȡ������������˽�й��췽��

                c1.setAccessible(true);//���˽�з�װ���˺󼴿ɶ�˽�з���ǿ�Ƶ��á�
                Student stu1 = (Student) c.newInstance("PKU",18);

            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } 


            //Method[] ms = clazz.getMethods();//��ȡ���ȫ�����еķ���
            Method[] ms = clazz.getDeclaredMethods();//��ȡ������з������������й�˽��

            for(Method m : ms){
                System.out.println(m.getName());//������
                System.out.println(m.getReturnType());//����ֵ����
                System.out.println(m.getModifiers());//��ȡ���η�

                Class[] pcs = m.getParameterTypes();//��ȡ�����Ĳ������ͣ���һ�����飬������ǰ�����췽��ʱ��ͬ������һ��
                if (pcs != null && pcs.length > 0){
                    for(Class pc : pcs){
                        System.out.println(pc.getName());
                    }
                }
                System.out.println("===========================");
            }

            Field[] fs =  clazz.getFields();//��ȡ��Ĺ������ԣ������˸���Ĺ�������
            Field[] fs1 =  clazz.getDeclaredFields();//��ȡ����������ԣ�ֻ�������������

            for(Field f : fs){
                System.out.println(f.getModifiers());//���η�
                System.out.println(f.getType());//����
                System.out.println(f.getName());//����
            }

            Package p = clazz.getPackage();//��ȡ�����ڵİ�
            System.out.println(p.getName());

            /**
             * ע�⣺������õķ�������obj����ķ������˴�obj����ʵ������Student����
             */
            //����setInfo����
            Constructor con = clazz.getConstructor();//��ȡ�޲ι���
            Object obj = con.newInstance();//ʹ���޲ι��촴������
            Method m = clazz.getMethod("setInfo",String.class,String.class);//������������������������������,�ɴ˵õ�������ΪsetInfo��������String String �ķ���
            m.invoke(obj, "zhangsan","PKU");//����һ����Ҫʵ�����Ķ��󣬺���Ĳ����ǵ��õ�ǰ�ķ�����ʵ�ʲ�����


            //��������һ��˽�з���
            Method m1 = clazz.getDeclaredMethod("test", String.class);
            m1.setAccessible(true);//�����װ
            m1.invoke(obj, "zhangsan");


            //�������ط���
            Method m2 = clazz.getMethod("setInfo",int.class);//setInfo �����ط���
            m2.invoke(obj, 123);

            //�����з���ֵ�ķ���
            Method m3 = clazz.getMethod("getSchool");
            String school = (String)m3.invoke(obj);
            System.out.println(school);
            
            //���䴴��һ������(����)
            Constructor con1 = clazz.getConstructor();
            Student stu = (Student)con.newInstance();

            Field f = clazz.getField("school");//��ȡ����Ϊschool������

            f.set(stu,"PKU");//��stu�����school��������ֵ
            String sch = (String)f.get(stu);//��ȡstu�����school���Ե�ֵ
            System.out.println(sch);

            //��˽������
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