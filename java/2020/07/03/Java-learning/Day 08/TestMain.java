public class TestMain {
    public static void main(String[] args) {
        for(int i = 0; i < args.length ;i++){
            System.out.println(args[i]);
        }
    }
    
}
//通过javac编译，java运行
// PS F:\PKU\Freshman_summer\Java\Day 08> javac TestMain.java
// PS F:\PKU\Freshman_summer\Java\Day 08> java TestMain abc 123 lkh sss//传入参数
// abc
// 123
// lkh
// sss
// PS F:\PKU\Freshman_summer\Java\Day 08>