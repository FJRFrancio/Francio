/**
 * 将age封装在类内，由类更改
 */


public class private0{
    //public int age;
    private int age;

    public void printAge(){//隐藏
        System.out.println(age);
    }

    public void setAge(int a){//封装
        if(a <= 150 && a >= 0){
            age = a;
        }else{
            System.out.println("error");
        }
    }
    
}