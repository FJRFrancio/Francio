
/**
 * ����ʽ�ĵ���ģʽ
 */

public class Single1 {
    //˽�л����죬����粻��ֱ��new
    private Single1(){

    }

    private static Single1 s1 = null;//�����ʽ����

    public static Single1 getInstance(){
        if (s1 == null){//�����ʽ����
            s1 = new Single1();
        }

        return s1;
    }
    
}