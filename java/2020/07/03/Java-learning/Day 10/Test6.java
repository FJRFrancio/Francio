
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.Map.Entry;

public class Test6 {
    public static void main(String[] args) {
        Map<String,Integer> map = new HashMap<String,Integer>();
        map.put("b",1);//��Ӽ�ֵ��
        map.put("c",2);
        map.put("e",2);//key���벻ͬ��ֵû��Ҫ��

        System.out.println(map);

        System.out.println(map.get("b"));//get�����Ǹ���keyȡֵ

        map.remove("c");//����key�Ƴ���ֵ��

        System.out.println(map.size());//map�ĳ���

        System.out.println(map.containsKey("b"));//�ж�map�������Ƿ����ָ����key
        System.out.println(map.containsValue(1));//�ж�map�����Ƿ����ָ����value
        
        map.keySet();//��ȡmap��key����
        map.values();//��ȡmap��value����
        
        //����map����
        //for each����
        Set<String> keys = map.keySet();
        for(String key : keys){

        }

        //map.entrySet����
        Set<Entry<String, Integer>> entrys =  map.entrySet();//set����entry
        for(Entry<String, Integer> en : entrys){
            System.out.println(en.getKey() + en.getValue());
        }


        Map<Integer,String> map1 = new TreeMap<Integer,String>();//����key����
        map1.put(4,"a");
        map1.put(2,"a");
        map1.put(3,"a");
        map1.put(1,"a");

        System.out.println(map1);

        Map<String,String> map2 = new TreeMap<String,String>();//�ַ�������Ȼ�����ֵ�����
        map2.put("b","a");
        map2.put("c","a");
        map2.put("d","a");
        map2.put("a","a");
        map2.put("ab","a");

        System.out.println(map2);



    }
}