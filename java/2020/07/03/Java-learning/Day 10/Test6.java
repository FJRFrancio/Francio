
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.Map.Entry;

public class Test6 {
    public static void main(String[] args) {
        Map<String,Integer> map = new HashMap<String,Integer>();
        map.put("b",1);//添加键值对
        map.put("c",2);
        map.put("e",2);//key必须不同，值没有要求

        System.out.println(map);

        System.out.println(map.get("b"));//get方法是根据key取值

        map.remove("c");//根据key移除键值对

        System.out.println(map.size());//map的长度

        System.out.println(map.containsKey("b"));//判断map集合中是否包含指定的key
        System.out.println(map.containsValue(1));//判断map集合是否包含指定的value
        
        map.keySet();//获取map的key集合
        map.values();//获取map的value集合
        
        //遍历map集合
        //for each遍历
        Set<String> keys = map.keySet();
        for(String key : keys){

        }

        //map.entrySet遍历
        Set<Entry<String, Integer>> entrys =  map.entrySet();//set里套entry
        for(Entry<String, Integer> en : entrys){
            System.out.println(en.getKey() + en.getValue());
        }


        Map<Integer,String> map1 = new TreeMap<Integer,String>();//按照key排序
        map1.put(4,"a");
        map1.put(2,"a");
        map1.put(3,"a");
        map1.put(1,"a");

        System.out.println(map1);

        Map<String,String> map2 = new TreeMap<String,String>();//字符串的自然排序：字典排序
        map2.put("b","a");
        map2.put("c","a");
        map2.put("d","a");
        map2.put("a","a");
        map2.put("ab","a");

        System.out.println(map2);



    }
}