/**
 * 宝马车的产品接口
 */

public interface BWM {
    //产品的信息介绍，发动方式等参数
    void showInfo();
}
/**
 * 构建具体的车的类
 */
class BWM3 implements BWM{

    @Override
    public void showInfo() {
        System.out.println("BWM3");
    }
}
class BWM5 implements BWM{

    @Override
    public void showInfo() {
        System.out.println("BWM5");
    }
}
class BWM7 implements BWM{

    @Override
    public void showInfo() {
        System.out.println("BWM7");
    }
}