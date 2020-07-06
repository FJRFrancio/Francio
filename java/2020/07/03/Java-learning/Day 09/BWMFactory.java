/**
 * �������������ӿ�
 */

public interface BWMFactory {
    BWM productBWM();
}

/**
 * ʵ�־��峵�͵���������
 */
class BWM3Factory implements BWMFactory{

    @Override
    public BWM productBWM() {//����ֵӦΪBWM�ӿ�
        System.out.println("Product BWM3");
        return new BWM3();//ʵ���Ϸ����˽ӿڵ���д����������ΪBWM
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