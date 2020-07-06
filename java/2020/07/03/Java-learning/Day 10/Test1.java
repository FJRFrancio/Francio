public class Test1 {
    public static void main(String[] args) throws Exception{//可以在main上继续抛出异常，直接抛给虚拟机，在程序中不能处理
        // B b = new B();
        // try {
        //     b.test();
        // }catch(Exception e){
        //     e.printStackTrace();
        // }

        B b = new B();
        try{
            b.test2(-100);
        }catch (Exception e){
            e.printStackTrace();
        }
        
        
    }
    
}


class B {
    int i;
    //NullPointerException的父类是Exception
    public void test() throws NullPointerException{//使用throws在代码处抛出异常，在调用方处捕获处理
        B b = null;
        System.out.println(b.i);
    }

    int age;

    public void test1(int age) throws Exception {//人工抛出异常
        if(age >= 0 && age <= 150){
            this.age = age;
            System.out.println(this.age);
        }else{
            throw new Exception("the age is out of range");
        }

    }

    public void test2(int age) throws MyException {//人工抛出异常:抛出自定义异常类
        if(age >= 0 && age <= 150){
            this.age = age;
            System.out.println(this.age);
        }else{
            throw new MyException("the age is out of range");
        }

    }
}

class C extends B{
    // @Override
    // public void test() throws Exception {//不能抛出Exception，子类范围要比父类小。
    //     // TODO Auto-generated method stub
    //     super.test();
    // }
}

class MyException extends Exception{
    public MyException(String msg){
        super(msg);//调用父类的构造方法
    }
}