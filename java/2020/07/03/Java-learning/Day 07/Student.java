public class Student extends Person{

    public Student(){
        System.out.println("Mainkind");
    // }//�޲ι�����
        // public Student(String school){
        //     this.school = school;
        }//���ι�����.������ʽ���췽��ʱ���û���޲ι�����

    static String school;

    // public void showInfo(){
    //     System.out.println(this.age);
    //     System.out.println(this.name);
    //     System.out.println(this.sex);
    //     System.out.println(this.school);
    // }
    @Override
    public void showInfo() {
        // TODO Auto-generated method stub ����������������ɾȥ���ĳ���Ҫ�Ĳ���
        System.out.println("Student");
    }


}