public class Test4 {
    int i;
    public int z;
    private int k;

    class A {
        int i;//内部类定义与外部类同名的属性不会引起冲突。

        public void setTest3Fileds(){
            Test4.this.i = 1;
            Test4.this.z = 2;
            Test4.this.k = 3;

        }

        public void set(){
            this.i = 10;
        }
    }

    public void setInfo(){
        new A().setTest3Fileds();//外部类用自己的内部类的方法需要先new这个内部类的对象。
    }

    public void showInfo(){
        System.out.println(this.i);
        System.out.println(this.z);
        System.out.println(this.k);
    }

    public static void main(String[] args) {
        Test4 t = new Test4();
        t.setInfo();
        t.showInfo();
    }
}

