
/**
 * ʵ��һ������ʽ�ĵ���ģʽ
 */

public class Single{
    // public Single(){
    //     //���蹹������ҩִ�кܶ��д��룬��ʱ�ܳ�������������ʺ�ʹ�õ���ģʽ��ֻnewһ�ζ���
    // }

    //����˽�еĹ���,���췽��˽�л��������������˾Ͳ���ֱ��ʹ��new����������
    private Single(){

    }

    //��һ��˽�е�Single���͵������
    private static Single single = new Single();

    public static Single getInstance(){
        return single;
    }

}