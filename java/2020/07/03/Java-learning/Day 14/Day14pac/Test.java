package Day14pac;

public class Test {
    public static void main(String[] args) {
        Person p = new Person();
        Class clazz = p.getClass();// ���ص�ǰ�����ľ�����Ϣ,����P������person���������Ϣ������clazz��

        Class c0 = Person.class;// ͨ����������ָ�����Classʵ��
        Class c1 = p.getClass();// ͨ�����ʵ������.getClass()������ȡ��Ӧʵ����������Classʵ��
        
        try {//�÷������
            Class c2 = Class.forName("Person");//ͨ��Class��̬����forName(String Classname)��ȡ���Classʵ�����÷����Ĳ���Ϊ���ȫ·��������.������
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
}