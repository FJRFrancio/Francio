/**
 * 模板设计模式
 */


public abstract class Template {
    public abstract void code();

    public final void getTime(){
        long start = System.currentTimeMillis();
        code();
        long end = System.currentTimeMillis();

        System.out.println(end - start);
    }
}

class TestTmp extends Template{

    @Override
    public void code() {
        int k = 0;
        for(int i = 0;i<50000;i++){
            k+=1;
        }
        System.out.println(k);
    }

}