package QiyeBishi;
import java.util.*;

public class Yunmanman {


    public static void main(String[] args) {
        int n = 2,m = 5;
        int[] taoEnergy = new int[]{5,6,10,20,30};
        int[] kill = new int[]{4,34};
        int[] hungerys = new int[]{3,35};
        Yunmanman.eatTaozi(n,m,taoEnergy,kill,hungerys);
    }


    /**
     *
     * Practice.handleString("agcddeb");
     * 删除字符串中出现次数最少的字符后的字符串。
     *
     * 1 将字符串映射到maps中统计函数
     * 2 通过比较得出次数最小的字符出现的次数
     * 3 循环数组，如果不是最小的次数，则输出字符
     */
    public static void handleString(String str){
        int min = 21;
        int [] maps = new int[256];
        for (int i = 0; i < str.length(); i++) {
            int index = str.charAt(i);
            maps[index]++;
        }

        for (int i = 0; i < str.length(); i++) {
            int index = str.charAt(i);
            if(maps[index] < min){
                min = maps[index];
            }
        }

        for (int i = 0; i < str.length(); i++) {
            int index = str.charAt(i);
            if(maps[index] != min){
                System.out.print(str.charAt(i));
            }
        }
    }


    /**
     * 第一行两个正整数n和m，分别表示小猴子数量和桃子的数量。
     * （n <= 10, m <= 100） 第二行m个正整数，每个表示着颗桃子能填充的饥饿值。
     * 接下来的n行，每行2个正整数，分别代表每只小猴子的战斗力和当前饥饿值。
     * 题目中所有输入的数值小于等于100。
     *
     * 输出n行，每行一个整数，代表每只小猴子剩余的饥饿值。
     *
     * 2 5
     * 5 6 10 20 30
     * 4 34
     * 3 35
     *
     * 4
     * 0
     */
    public static void eatTaozi(int n,int m,int[] taoEnergy,int[] kill,int[] hungerys){
        int[] monkey = new int[n];
        int[] tao = new int[m];

        for (int i = 0; i < m; i++) {
            tao[i] = taoEnergy[i];
        }

        Map<Integer,Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < n; i++) {
            int killEnergy = kill[i];
            int hungery = hungerys[i];
            monkey[i]=killEnergy;
            map.put(killEnergy,hungery);
        }

        List<Map.Entry<Integer,Integer>> list = new LinkedList<Map.Entry<Integer, Integer>>();
        Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return o1.getKey()-o2.getKey() == 0 ?
                        (o1.getKey()-o2.getKey()):(o2.getKey()-o1.getKey());
            }
        });

        for (int i = 0; i < list.size(); i++) {
            int hunger = list.get(i).getValue();
            Arrays.sort(tao);
            for (int j = m-1; j >=0; j--) {
                if(hunger >= tao[j]){
                    hunger-=tao[j];
                    tao[j] = 0;
                }else{
                    continue;
                }
            }
            map.put(list.get(i).getKey(),hunger);
        }

        for (int i = 0; i < n; i++) {
            System.out.print(map.get(monkey[i]));
        }
    }

}
