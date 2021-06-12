package DoExercise.HSP_ZCY.A025_哈希表和有序表;

import java.util.HashMap;
import java.util.TreeMap;

/**
 * @Author: Du
 * @Date: 2021/6/12 15:53
 */
public class C01_HashMapTreeMap
{
    
    
    public static void main(String[] args)
    {
        t03();
    }
    
    /**
     *
     * TreeMap表不论有多少数据，其增删改查都是o(logn)时间
     * TreeMap比HashMap好的就是其有序
     */
    private static void t03()
    {
        TreeMap<Integer,String> t = new TreeMap();
        t.put(1,"1111");
        t.put(2,"2222");
        t.put(9,"9999");
        t.put(29,"2929");
    
        System.out.println(t.firstKey());//最小的Key
        System.out.println(t.lastKey());//最大的Key
    
        System.out.println(t.floorKey(3));//比3小的最近的数
        System.out.println(t.ceilingKey(3));//比3大的最近的数
    }
    
    
    /**
     *
     * 自定义类型是引用传递，传递的是地址值
     * Hash表不论有多少数据，其增删改查都是o(1)时间，但是o(1)是一个较大的o(1)时间，比+-*，数组寻址大
     */
    private static void t02()
    {
        
        Node n1 = new Node(1);
        Node n2 = new Node(1);
        
        HashMap<Node, String> map = new HashMap<>();
        map.put(n1, "111");
        
        System.out.println(map.containsKey(n1));
        System.out.println(map.containsKey(n2));//false
    }
    
    static class Node
    {
        int val;
        
        public Node(int v)
        {
            val = v;
        }
    }
    
    /**
     * Integer String Double等原生包装类型在HashMap中都是按照值转递
     */
    private static void t01()
    {
        HashMap<String, String> map = new HashMap<>();
        map.put("aaa", "111");
        map.put("bbb", "222");
        map.put("ccc", "333");
        
        String t1 = "aaa";
        String t2 = "bbb";
        System.out.println(map.containsKey(t1));//true
        System.out.println(map.containsKey(t2));//true
        
        Integer a = 111;
        Integer b = 222;
        System.out.println(a == b);
        
        HashMap<Integer, String> map1 = new HashMap<>();
        map1.put(111, "aaa");
        map1.put(222, "bbb");
        map1.put(333, "ccc");
        
        System.out.println(map1.containsKey(a));//true
        System.out.println(map1.containsKey(b));//true
    }
}
