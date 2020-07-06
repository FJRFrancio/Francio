public class Student extends Person{

    public Student(){
        System.out.println("Mainkind");
    // }//无参构造器
        // public Student(String school){
        //     this.school = school;
        }//含参构造器.存在显式构造方法时类就没有无参构造了

    static String school;

    // public void showInfo(){
    //     System.out.println(this.age);
    //     System.out.println(this.name);
    //     System.out.println(this.sex);
    //     System.out.println(this.school);
    // }
    @Override
    public void showInfo() {
        // TODO Auto-generated method stub 这个大括号里面可以删去更改成需要的部分
        System.out.println("Student");
    }


}