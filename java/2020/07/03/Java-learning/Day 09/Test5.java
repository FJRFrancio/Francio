public class Test5 {
    public static void main(String[] args) {
        A a = new A();
        a.testB();
        a.testC();
    }
    
}

/**
 * 现在类A想要同时获得类B和类C的方法并重写
 * 用内部类变相实现类的多重继承，可以同时继承多个类
 */
class A {
    //变相重写testB testC 
    public void testB(){
        new InnerB().testB();
    }
    public void testC(){
        new InnerC().testC();
    }



    private class InnerB extends B{
        @Override
        public void testB() {
            System.out.println("this is a overrided test b method");
        }
    }
    private class InnerC extends C{
        @Override
        public void testC() {
            System.out.println("this is a overrided test c method");
        }
    }
}

class B{
    public void testB(){

    }
}

class C{
    public void testC(){
        
    }
}