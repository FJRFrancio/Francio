public class Person {

    public Person(){}



    /**
     * ������ķ�ʽ���ݿɱ�����Ĳ���
     * @param args
     */
    public void printInfo(String[] args){//Ҫ���ӡ������Ϣȫ����Դ���β�
        //�����ڲ�����ȷ���������Դ������ٸ�
        for (int i = 0;i < args.length; i++){
            System.out.println(args[i]);
        }
    }
    /**
     * ��Java���е�...��ʽ���ݿɱ���������ֲ�����ʹ��ʱ�������ʹ�÷�ʽ��ͬ��
     * ����...������Դ���0���������
     * �ɱ��β�һ��Ҫ�������в��������
     * @param args
     */

    public void printInfo1(String...args){
        for (int i = 0;i < args.length; i++){
            System.out.println(args[i]);
        }
    }
}