
public class DataSwap_main {
    public static void swap(DataSwap ds1){
        ds1.a = 6;
        System.out.println("ds1.a in swep method: " + ds1.a);
    }
    public static void main(String[] args) {
        DataSwap ds = new DataSwap();
        System.out.println("ds.a before call swep method: " + ds.a);
        swap(ds);
        //Ã»ÓÐÐ´ds.a = 6
        System.out.println("ds.a after call swep method: " + ds.a);
    }
}