public class Test1{
    public static void main (String[] args){
        //ʵ����person��,������person����
        Person person = new Person();//����һ��Person���͵ı�����������Ϊperson,new Person()��Ϊʵ����Person�ಢ��person��ֵ����ֵΪ��ǰ��ʵ����
        person.name = "Francio";//��person�����name���Ը�ֵ
        person.showName();//�����ĵ���
        person.age = 20;//��������ע�ͣ����Ӿͱ�����֪��Ϊɶ
        int i = person.getAge();//�з���ֵ�ķ����ڵ��ú�ͻ���һ��ֵ��Ϊ������return�Ĳ��֣�����һ�����������գ��˴�Ϊi��
        System.out.println(i);

        person.eat("apple");//���η����ĵ��ã������ڸ�ֵ
        person.move("walk");
    }
}