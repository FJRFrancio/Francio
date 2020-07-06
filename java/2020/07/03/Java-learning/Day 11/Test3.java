public class Test3 {
    public static void main(String[] args) {
        Season spr = Season.SPRING;//返回的是一个枚举的对象
        spr.showInfo();

        Season spr1 = Season.SPRING;
        System.out.println(spr.equals(spr1));//枚举类是一个单例模式，每次执行season.spring获得的是相同对象
        spr1.test();//实现接口的枚举类
    }
}


/**
 * 枚举类
 */
enum Season implements ITest {
    SPRING("spring","warm"),
    SUMMER("summer","hot"),
    AUTUMN("autumn","cool"),
    WINTER("winter","cold");//相当于调用Season(String name, String desc),做了四个枚举类

    private final String name;
    private final String desc;//私有属性常量

    private Season(String name, String desc){//有参私有构造
        this.name = name;
        this.desc = desc;
    }

    public void showInfo(){
        System.out.println(this.name + "," + this.desc);
    }

    @Override
    public void test() {//枚举类可以调用接口
        System.out.println("this is an implement");

    }
}

interface ITest{
    void test();
}