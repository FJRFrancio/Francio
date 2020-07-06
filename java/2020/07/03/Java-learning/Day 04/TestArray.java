public class TestArray {
    public static void main(String[] args){
        int[] array1 = new int[]{2,3,5,7,11,13,17,19};
        int[] array2 = new int[8];
        array2 = array1;
        for(int i = 0; i <= array2.length-1;i++){
            if(i%2==0){
                array2[i] = i;
            }
            System.out.println(array2[i]);
        }
    }
}