/**
 * 一个JavaBean
 * @author Francio
 */

public class PersonBean {
    private String name;
    private int sex;//性别，0男1女
    private int age;

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

    public void setSex(int sex){
        this.sex = sex;
    }

    public int getSex(){
        return this.sex;
    }

    public void setAge(int age){
        this.age = age;
    }

    public int getAge(){
        return this.age;
    }

}