
public class mem {
    /**
     * �����������͵ķ����Ĳ�������
     * @param i
     */
    public static void swap(int i){
        i = 6;
        System.out.println("i in swap method: " + i);
    }

    public static void main(String[] args) {
        int a = 0;
        //��ִ�иþ䣬��ջ�ڿ���һ���ڴ棬�����ַΪAD8500�����ֵΪ0
        swap(a);
        //����swap������ִ��int i���֣���ջ�п���һ���ڴ棬��ַAD8600��ֵ���Ǵ�a���ƹ�����ֵ��Ȼ��ִ��swap�ķ�������Ĵ��룬��
        //i��ջ�е�ֵ�ĳ�6������i��ջ�е�ֵΪ6��
        System.out.println("a in main method: " + a);    
    }
    //�������ı�ԭ����a��ֵ
}