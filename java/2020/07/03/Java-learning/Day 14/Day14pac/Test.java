package Day14pac;

public class Test {
    public static void main(String[] args) {
        Person p = new Person();
        Class clazz = p.getClass();// 返回当前类对象的具体信息,对象P所属的person类的所有信息包含于clazz中

        Class c0 = Person.class;// 通过类名创建指定类的Class实例
        Class c1 = p.getClass();// 通过类的实例对象.getClass()方法获取对应实例对象的类的Class实例
        
        try {//该方法最常用
            Class c2 = Class.forName("Person");//通过Class静态方法forName(String Classname)获取类的Class实例。该方法的参数为类的全路径（包名.类名）
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
}