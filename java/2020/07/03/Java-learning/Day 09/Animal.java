
public abstract class Animal {
    public abstract void test();//只要类中有一个抽象方法，这个类就必须是抽象类

    public abstract void move();
}

class Dog extends Animal{

    @Override
    public void test() {
        // TODO Auto-generated method stub

    }

    @Override
    public void move() {
        System.out.println("run");
    } 
}

class Fish extends Animal{

    @Override
    public void test() {
        // TODO Auto-generated method stub

    }

    @Override
    public void move() {
        System.out.println("swim");
    }
    
}

class Bird extends Animal{

    @Override
    abstract public void test() {//bird类不是抽象方法，故此处报错
        // TODO Auto-generated method stub

    }

    @Override
    public void move() {
        // TODO Auto-generated method stub

    }
    
}