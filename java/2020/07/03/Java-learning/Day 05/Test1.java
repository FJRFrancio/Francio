public class Test1{
    public static void main (String[] args){
        //实例化person类,即创建person对象
        Person person = new Person();//声明一个Person类型的变量，变量名为person,new Person()即为实例化Person类并给person赋值，其值为当前的实例。
        person.name = "Francio";//给person对象的name属性赋值
        person.showName();//方法的调用
        person.age = 20;//这里必须加注释，不加就报错，不知道为啥
        int i = person.getAge();//有返回值的方法在调用后就会有一个值，为方法中return的部分，可用一个变量来接收（此处为i）
        System.out.println(i);

        person.eat("apple");//含参方法的调用：括号内赋值
        person.move("walk");
    }
}