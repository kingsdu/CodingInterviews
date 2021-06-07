package DoExercise.JianzhiOffer;

public class Offer069_PrintNumbers
{
    
    public static void main(String[] args)
    {
//        Arrays.stream(printNumbers1(2)).forEach(e -> System.out.print(e + " "));
        printNumbers2(2);
    }
    
    public static int[] printNumbers1(int n)
    {
        int total = 0, index = 1;
        while (n > 0)
        {
            total += index * 9;
            index *= 10;
            n--;
        }
        int res[] = new int[total];
        for (int i = 1; i <= total; i++)
        {
            res[i - 1] = i;
        }
        return res;
    }
    
    static StringBuilder res;
    static int total;
    static char[] num, loop = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
    
    /**
     * 考虑大数的情况
     * 方法1：dfs 全排列代码
     *
     * @param n
     * @return
     */
    public static String printNumbers2(int n)
    {
        total = n;
        res = new StringBuilder();
        num = new char[n];
        dfs(0);
        res.deleteCharAt(res.length() - 1);
        return res.toString();
    }
    
    /**
     * 标准的dfs
     *
     * @param x
     */
    public static void dfs(int x)
    {
        if (x == total)
        {
            res.append(String.valueOf(num) + ",");
            return;
        }
        for (char i : loop)
        {
            num[x] = i;
            dfs(x + 1);
        }
    }
    
    static int[] ans;
    static int count = 0;
    
    /**
     *
     * 考虑大数的情况
     * 方法2：去除高位的0
     *
     * @param n
     * @return
     */
    public static int[] printNumbers(int n)
    {
        total = n;
        num = new char[n];
        ans = new int[(int) (Math.pow(10, n) - 1)];
        dfs1(0);
        return ans;
    }
    
    
    private static void dfs1(int n)
    {
        if (n == total)
        {
            String tmp = String.valueOf(num);
            int curNum = Integer.parseInt(tmp);//去掉高位0
            if (curNum != 0) ans[count++] = curNum;
            return;
        }
        for (char i = '0'; i <= '9'; i++)
        {
            num[n] = i;
            dfs1(n + 1);
        }
    }
}
