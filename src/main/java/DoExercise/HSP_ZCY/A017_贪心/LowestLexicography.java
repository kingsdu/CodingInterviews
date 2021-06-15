package DoExercise.HSP_ZCY.A017_贪心;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;

/**
 * 给定一个由字符串组成的数组strs，必须把所有的字符串拼接起来，返回所有可能的拼接结果中，字典序最小的结果
 * 字典序：两个字符串放入到字典中，谁放在前面谁的字典序就小
 *
 * strs[] = b,a,e,f,c;
 * ab < ba
 * abc < cba
 */
public class LowestLexicography
{
    
    
    /**
     * 方法1：暴力求解
     *
     * @param strs
     * @return
     */
    public static String lowestString1(String[] strs)
    {
        if (strs == null || strs.length == 0)
        {
            return "";
        }
        ArrayList<String> all = new ArrayList<>();
        HashSet<Integer> use = new HashSet<>();
        process(strs, use, "", all);
        String lowest = all.get(0);
        for (int i = 1; i < all.size(); i++)
        {
            if (all.get(i).compareTo(lowest) < 0)
            {
                lowest = all.get(i);
            }
        }
        return lowest;
    }
    
    /**
     * 暴力递归，得到所有的字符串组合
     *
     * @param strs 所有的字符串
     * @param use  已经被拼接过的字符串的下标
     * @param path 单个被拼接的字符累加
     * @param all  所有拼接的字符串集合
     */
    public static void process(String[] strs, HashSet<Integer> use, String path, ArrayList<String> all)
    {
        if (use.size() == strs.length)
        {
            all.add(path);
        } else
        {
            for (int i = 0; i < strs.length; i++)
            {
                if (!use.contains(i))
                {
                    use.add(i);//已经统计
                    process(strs, use, path + strs[i], all);
                    use.remove(i);//深度优先还原现场
                }
            }
        }
    }
    
    /**
     *
     * 方法2：利用排序的传递性，加入a+b < b+a 则a+b 放在 b+a前面
     *
     */
    public static class MyComparator implements Comparator<String>
    {
        @Override
        public int compare(String a, String b)
        {
            return (a + b).compareTo(b + a);
        }
    }
    
    public static String lowestString2(String[] strs)
    {
        if (strs == null || strs.length == 0)
        {
            return "";
        }
        Arrays.sort(strs, new MyComparator());
        String res = "";
        for (int i = 0; i < strs.length; i++)
        {
            res += strs[i];
        }
        return res;
    }
    
    /**
     *
     * @param strLen
     * @return
     */
    public static String generateRandomString(int strLen)
    {
        char[] ans = new char[(int) (Math.random() * strLen) + 1];
        for (int i = 0; i < ans.length; i++)
        {
            int value = (int) (Math.random() * 5);
            ans[i] = (char) (97 + value);
        }
        return String.valueOf(ans);
    }
    
    /**
     *
     * @param arrLen
     * @param strLen
     * @return
     */
    public static String[] generateRandomStringArray(int arrLen, int strLen)
    {
        String[] ans = new String[(int) (Math.random() * arrLen) + 1];
        for (int i = 0; i < ans.length; i++)
        {
            ans[i] = generateRandomString(strLen);
        }
        return ans;
    }
    
    /**
     *
     *
     * @param arr
     * @return
     */
    public static String[] copyStringArray(String[] arr)
    {
        String[] ans = new String[arr.length];
        for (int i = 0; i < ans.length; i++)
        {
            ans[i] = String.valueOf(arr[i]);
        }
        return ans;
    }
    
    public static void main(String[] args)
    {
        int arrLen = 6;
        int strLen = 5;
        int testTimes = 100000;
        for (int i = 0; i < testTimes; i++)
        {
            String[] arr1 = generateRandomStringArray(arrLen, strLen);
            String[] arr2 = copyStringArray(arr1);
            lowestString1(arr1);
            if (!lowestString1(arr1).equals(lowestString2(arr2)))
            {
                System.out.println("Oops!");
            }
        }
        System.out.println("finish!");
    }
    
}
