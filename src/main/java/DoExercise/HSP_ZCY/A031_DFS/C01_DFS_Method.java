package DoExercise.HSP_ZCY.A031_DFS;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * @Author: Du
 * @Date: 2021/6/18 10:44
 * <p>
 * <p>
 * DFS算法的两种写法
 * 1 通过控制元素下标是否重复
 * 2 控制元素交换
 */
public class C01_DFS_Method
{
    static ArrayList<String> result1 = new ArrayList();
    static HashSet<Integer> used = new HashSet<>();
    static String[] str1 = new String[10];
    
    static ArrayList<String> result2 = new ArrayList();
    static String[] str2 = null;
    
    
    public static void main(String[] args)
    {
        str1 = new String[]{"a", "b", "c", "d"};
        dfs1("");
        result1.stream().forEach(e -> System.out.print(e + " "));
        System.out.println();
        str2 = new String[]{"a", "b", "c", "d"};
        dfs2(0);
        result2.stream().forEach(e -> System.out.print(e + " "));
    }
    
    
    //方法1 ：通过控制下标
    public static void dfs1(String path)
    {
        if (used.size() == str1.length)
        {
            result1.add(path);
            return;
        }
        
        for (int i = 0; i < str1.length; i++)
        {
            if (!used.contains(i))
            {
                used.add(i);
                dfs1(path + str1[i]);
                used.remove(i);
            }
        }
    }
    
    
    public static void dfs2(int path)
    {
        if (path == str2.length - 1)
        {
            result2.add(StringUtils.join(str2));
            return;
        }
        
        for (int i = path; i < str2.length; i++)
        {
            swap(i, path);
            dfs2(path + 1);
            swap(i, path);
        }
    }
    
    static void swap(int i, int j)
    {
        String t = str2[i];
        str2[i] = str2[j];
        str2[j] = t;
    }
    
    
}
