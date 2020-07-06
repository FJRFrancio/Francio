/**
 * 描述会唱歌的厨子是一个老师的类
 */

public class SCTeacher extends Person1 implements Cooking,Sing {
    String course;

    public void setInfo(){
        super.age = 27;
        super.sex = 1;
        super.name = "zhangsan";
        this.course = "math";
    }


    @Override
    public void singing() {
        System.out.println(super.name + "can sing");

    }

    @Override
    public void fry() {
        System.out.println(super.name + "can cook");
    }

    @Override
    public void showInfo() {
        System.out.println("teacher cookers singer");
        System.out.println(super.age);
        System.out.println(super.name);
        System.out.println(super.sex);
        System.out.println(this.course);
        

    }
    
}