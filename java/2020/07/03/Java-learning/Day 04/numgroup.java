public class numgroup {
    public static void main(String[]args){
        int[] arr = new int[]{4,2,7,1,3,5};

        //���ֵ
        int max = arr[0];//����arr[0]Ϊ���ֵ
        for(int i = 0;i<arr.length; i++){
            if(max < arr[i]){
                max = arr[i];//���Ŀǰ���ֵ
            }
        }
        System.out.println("max:" + max);

        //��Сֵ
        int min = arr[0];//����arr[0]Ϊ��Сֵ
        for(int i = 0;i<arr.length; i++){
            if(min > arr[i]){
                min = arr[i];//���Ŀǰ��Сֵ
            }
        }
        System.out.println("min:" + min);

        //�����ƽ����
        int res = 0;
        for(int i = 0;i<arr.length; i++){
            res += arr[i];
        }
        System.out.println("total="+res);
        System.out.println("average="+(res / arr.length));

        //����
        int[] copy = new int[arr.length];//��������һ����Դ���鳤��һ�µ�����
        for(int i = 0;i<arr.length; i++){
            copy[i] = arr[i];//����arr����arr��ÿ��Ԫ�ذ���˳���ó�����copy��ÿһ��Ԫ�ظ�ֵ�������i��Ϊcopy��arr��Ԫ���±ꡣ
        }

        //��ת
        //����������һ������temp������temp�ĳ�����arrһ�£�����ѭ��arr�����Ÿ�temp��ֵ������ٰ�temp��ֵ��arr
        int[] temp = new int [arr.length];
        int k = 0; //����temp��Ԫ���±�
        for(int i = arr.length-1;i >= 0;i--){
            temp[k] = arr[i];
            k++;
        }
        arr = temp;

        //ð������
        int tmp = 0;
        for (int i = 0; i < arr.length - 1; i++){//���Ϊѭ���ִΣ�Ϊ���鳤��-1
            for(int j = 0; j < arr.length-1-i; j++){//ÿһ�ִε����ֶԱ�����
                if(arr[j] > arr[j+1]){//�Ƚϲ�����������������λ��,ͨ�����Ĵ��иı�����˳��
                    tmp = arr[j];
                    arr[j] = arr [j+1];
                    arr[j+1] = tmp;
                }
            }
        }
    }
}