public class Test3 {
    public static void main(String[] args) {
        Season spr = Season.SPRING;//���ص���һ��ö�ٵĶ���
        spr.showInfo();

        Season spr1 = Season.SPRING;
        System.out.println(spr.equals(spr1));//ö������һ������ģʽ��ÿ��ִ��season.spring��õ�����ͬ����
        spr1.test();//ʵ�ֽӿڵ�ö����
    }
}


/**
 * ö����
 */
enum Season implements ITest {
    SPRING("spring","warm"),
    SUMMER("summer","hot"),
    AUTUMN("autumn","cool"),
    WINTER("winter","cold");//�൱�ڵ���Season(String name, String desc),�����ĸ�ö����

    private final String name;
    private final String desc;//˽�����Գ���

    private Season(String name, String desc){//�в�˽�й���
        this.name = name;
        this.desc = desc;
    }

    public void showInfo(){
        System.out.println(this.name + "," + this.desc);
    }

    @Override
    public void test() {//ö������Ե��ýӿ�
        System.out.println("this is an implement");

    }
}

interface ITest{
    void test();
}