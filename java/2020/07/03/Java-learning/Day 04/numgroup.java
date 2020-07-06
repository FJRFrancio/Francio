public class numgroup {
    public static void main(String[]args){
        int[] arr = new int[]{4,2,7,1,3,5};

        //最大值
        int max = arr[0];//假设arr[0]为最大值
        for(int i = 0;i<arr.length; i++){
            if(max < arr[i]){
                max = arr[i];//存放目前最大值
            }
        }
        System.out.println("max:" + max);

        //最小值
        int min = arr[0];//假设arr[0]为最小值
        for(int i = 0;i<arr.length; i++){
            if(min > arr[i]){
                min = arr[i];//存放目前最小值
            }
        }
        System.out.println("min:" + min);

        //求和与平均数
        int res = 0;
        for(int i = 0;i<arr.length; i++){
            res += arr[i];
        }
        System.out.println("total="+res);
        System.out.println("average="+(res / arr.length));

        //复制
        int[] copy = new int[arr.length];//首先声明一个与源数组长度一致的数组
        for(int i = 0;i<arr.length; i++){
            copy[i] = arr[i];//遍历arr，把arr的每个元素按照顺序拿出，给copy的每一个元素赋值，这里的i即为copy与arr的元素下标。
        }

        //翻转
        //考虑再声明一个数组temp，数组temp的长度与arr一致，倒序循环arr，正着给temp赋值，最后再把temp赋值给arr
        int[] temp = new int [arr.length];
        int k = 0; //用作temp的元素下标
        for(int i = arr.length-1;i >= 0;i--){
            temp[k] = arr[i];
            k++;
        }
        arr = temp;

        //冒泡排序
        int tmp = 0;
        for (int i = 0; i < arr.length - 1; i++){//外层为循环轮次，为数组长度-1
            for(int j = 0; j < arr.length-1-i; j++){//每一轮次的数字对比排序
                if(arr[j] > arr[j+1]){//比较并调换相邻两个数的位置,通过更改此行改变排列顺序。
                    tmp = arr[j];
                    arr[j] = arr [j+1];
                    arr[j+1] = tmp;
                }
            }
        }
    }
}