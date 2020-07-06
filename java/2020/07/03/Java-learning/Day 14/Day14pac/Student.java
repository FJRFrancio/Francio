package Day14pac;

public class Student extends Person implements Move,Studay{

    public Student(){
        System.out.println("01");
    }

    public Student(String school){
        System.out.println("02");
        this.school = school;
    }

    private Student(String name,int age){
        System.out.println("03");
        this.name = name;
        this.age = age;
    }

    public String school;
    private String privateField;

    public void showInfo(){
        System.out.println(school);
    }


    @Override
    public void studyInfo() {
        System.out.println("learning Java");

    }

    @Override
    public void moveType() {
        System.out.println("RUN!!!");

    }

    private void test(String name){
        System.out.println("private Method");
    }
     

    public String getSchool(){
        return this.school;
    }


    public void setInfo(String name,String school){
        this.name = name;
        this.school = school;
        System.out.println("setInfo Method");

    }
    public void setInfo(int age){
        
        System.out.println("setInfo-Age Method");

    }
}