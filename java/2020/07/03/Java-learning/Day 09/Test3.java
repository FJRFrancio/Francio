public class Test3 {
    public static void main(String[] args) {
        BWM b3 = new BWM3Factory().productBWM();
        BWM b5 = new BWM5Factory().productBWM();
        BWM b7 = new BWM7Factory().productBWM();

        b3.showInfo();
        b5.showInfo();
        b7.showInfo();

    }
}