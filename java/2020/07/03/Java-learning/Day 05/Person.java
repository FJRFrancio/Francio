/**
 * person
 * @author Francio 
 * 
 */
public class Person {
    //���ԣ���Ա����
    String name;
    int age;

    //��Ϊ��Ҳ�к���
    /**
     * ��ӡ����
     * �ĵ�ע��������ͷ���ǰ
     */
    public void showName(){//�շ������������������׵��ʿ�ͷСд�����൥������ĸ��д
        System.out.println("NAME " + name);
    }
    /**
     * ��ȡ����
     * @return
     */
    public int getAge(){//�����һ���з���ֵ�ķ������򷽷������һ��һ��������Ӧ���ݣ�ʹ��return�ؼ��֣����������붨��һ��
        return age;
    }

    /**
     * �������ķ���
     * ����Ե�ʳ��
     * @param food ʳ��
     */
    public void eat(String food){
        System.out.println("the food you eat is " + food);
    }

    public void move(String MoveType){
        System.out.println(MoveType);
    }


}