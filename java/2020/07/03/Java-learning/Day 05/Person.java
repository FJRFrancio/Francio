/**
 * person
 * @author Francio 
 * 
 */
public class Person {
    //属性，成员变量
    String name;
    int age;

    //行为，也叫函数
    /**
     * 打印姓名
     * 文档注释用于类和方法前
     */
    public void showName(){//驼峰命名法：方法名称首单词开头小写，其余单词首字母大写
        System.out.println("NAME " + name);
    }
    /**
     * 获取年龄
     * @return
     */
    public int getAge(){//如果是一个有返回值的方法，则方法体最后一行一定返回相应数据，使用return关键字，返回类型与定义一致
        return age;
    }

    /**
     * 含参数的方法
     * 输出吃的食物
     * @param food 食物
     */
    public void eat(String food){
        System.out.println("the food you eat is " + food);
    }

    public void move(String MoveType){
        System.out.println(MoveType);
    }


}