import java.util.HashSet;
import java.util.Set;

import javax.swing.text.html.HTMLDocument.Iterator;

public class Test3 {
    public static void main(String[] args) {
        Set set = new HashSet();//等价于泛型为Object

        set.add(null)
        // set.add(1);//添加元素
        // set.add("a");
        // System.out.println(set);

        // set.remove(1);//移除数据
        // System.out.println(set);

        // System.out.println(set.contains("a"));//判断是否包含某数据

        // set.clear();//清空集合

        set.add("b");
        set.add("c");
        set.add("d");
        set.add("a");
        System.out.println(set);

        //使用迭代器遍历集合
        Iterator it = set.iterator();

        while (it.hasNext()){//判断迭代器中是否有下一个元素
            System.out.println(it.next());//输出
        }

        //for each迭代
        for(Object obj : set){//意思是把set的每一个值取出来赋值给obj,直到循环set的所有值
            System.out.println(obj);
        }

        System.out.println(set.size());//获取集合的元素个数


        //如果想要集合只能存同样类型的对象，就要使用泛型。
        Set<String> set1 = new HashSet<String>();//指定String为集合的泛型，该集合就只能存String

    }
}