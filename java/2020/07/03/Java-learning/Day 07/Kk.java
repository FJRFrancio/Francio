public class Kk extends Student{
    public void test(){
        super.age = 1;//
    }
public static void main(String[] args) {
    Student s = new Student();// �����޲ι�����:����û���޲ι��죬�˴�����
   // Student stu2 = new Student(school);// �����޲ι�����
    Person p = new Person();
    //�������������
    Person e = new Student();//�������ö������ָ������ʵ��
    //e.school = "xxxx";// �������ڱ���ʱȷ��������ʱeΪPerson���ͣ�û��Student��Ա�������ʱ��뱨��

    s.showInfo();
    p.showInfo();
    //����������д�������Ե��ø��Եķ���

    e.showInfo();
    //��ʱ���õ���Student�ķ����������Ǳ���ʱ����Person�ķ����������˱����ں������ڵĲ�ͬ��


    p = new Student();//��ʱP���õ���Studentʵ�����󣬶�����֮ǰ�����Person

}
    
}