/**
 * 汽车生产工厂接口
 */

public interface BWMFactory {
    BWM productBWM();
}

/**
 * 实现具体车型的生产工厂
 */
class BWM3Factory implements BWMFactory{

    @Override
    public BWM productBWM() {//返回值应为BWM接口
        System.out.println("Product BWM3");
        return new BWM3();//实际上返回了接口的重写，其类型仍为BWM
    } 
}

class BWM5Factory implements BWMFactory{

    @Override
    public BWM productBWM() {
        System.out.println("Product BWM5");
        return new BWM5();
    } 
}

class BWM7Factory implements BWMFactory{

    @Override
    public BWM productBWM() {
        System.out.println("Product BWM7");
        return new BWM7();
    } 
}