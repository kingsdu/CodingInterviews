package DoExercise.Interview;

import java.util.ArrayList;
import java.util.Collections;

/**
 * 根据左边的数组，输出右边的统计结果。
 * <p>
 * [1] [1,1]
 * [2,1,2] [2 2,1 1]
 * [3,2,1,2,1][3 1,2 2,1 2]
 */
public class 享物说
{
    public static void main(String[] args)
    {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<Integer>()
        {{
            add(1);
        }});
        res.add(new ArrayList<Integer>()
        {{
            add(2);
            add(1);
            add(2);
        }});
        res.add(new ArrayList<Integer>()
        {{
            add(3);
            add(2);
            add(1);
            add(2);
            add(1);
        }});
        ArrayList<ArrayList<Integer>> arrayLists = calArr(res);
        for (ArrayList<Integer> li :
                arrayLists)
        {
            for (int i = 0; i < li.size(); i++)
            {
                System.out.print(li.get(i)+" ");
            }
            System.out.println();
        }
    }
    
    
    public static ArrayList<ArrayList<Integer>> calArr(ArrayList<ArrayList<Integer>> list)
    {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        for (ArrayList<Integer> li :
                list)
        {
            Collections.sort(li);
            int arr[] = new int[li.get(li.size() - 1) + 1];
            for (int i = 0; i < li.size(); i++)
            {
                arr[li.get(i)]++;
            }
            ArrayList<Integer> tmp = new ArrayList<>();
            for (int i = arr.length - 1; i > 0; i--)
            {
                if (arr[i] != 0)
                {
                    tmp.add(i);
                    tmp.add(arr[i]);
                }
            }
            res.add(tmp);
        }
        return res;
    }
}
