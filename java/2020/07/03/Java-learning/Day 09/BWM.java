/**
 * �����Ĳ�Ʒ�ӿ�
 */

public interface BWM {
    //��Ʒ����Ϣ���ܣ�������ʽ�Ȳ���
    void showInfo();
}
/**
 * ��������ĳ�����
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