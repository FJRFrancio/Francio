import java.util.ArrayList;
import java.util.List;

public class Test5 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();
        list.add("b");//第一个，索引下标为0
        list.add("d");
        list.add("c");
        list.add("a");
        list.add("a");//元素可重复

        System.out.println(list);//以添加顺序排序
        System.out.println(list.get(2));//取索引访问集合

        list.add(1,"f");//在位置1插入“f"

        List<String> l = new ArrayList<String>();
        l.add("123");
        l.add("456");

        list.addAll(2,l);//插入集合

        System.out.println(list.indexOf("d"));//获取指定元素在集合中第一次出现的索引下标
        System.out.println(list.lastIndexOf("d"));//最后一次出现的索引下标

        list.remove(2);//根据指定的索引下标移除元素

        list.set(1,"ff");//更改指定索引下标位置的数据的值

        List<String> subl = list.subList(2, 4);//集合元素的截取，根据索引下标的位置。截取时包含开始时的索引，不包含结束时的索引。

        System.out.println(list.size());//集合的长度

    }
    
}