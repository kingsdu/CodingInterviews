package DoExercise.HSP_ZCY.A017_Greedy;


import java.util.Arrays;
import java.util.Comparator;

/**
 * 一些项目要占用一个会议室宣讲，会议室不能同时容纳两个项目的宣讲。
 * 给你每一个项目开始的时间和结束的时间，你来安排宣讲的日程，
 * 要求会议室进行的宣讲的场次最多。返回最多的宣讲场次。
 */
public class BestArrange
{
    
    public static class Program
    {
        public int start;//会议开始时间
        public int end;//结束时间
        
        public Program(int start, int end)
        {
            this.start = start;
            this.end = end;
        }
    }
    
    /**
     *
     * 方法1：暴力递归
     *
     *
     * @param programs
     * @return
     */
    public static int bestArrange1(Program[] programs)
    {
        if (programs == null || programs.length == 0)
        {
            return 0;
        }
        return process(programs, 0, 0);
    }
    
    /**
     *
     * 选择思路：每次都选择时间最短的会议，逐步进行。
     *
     * @param programs 所有备选的方案
     * @param done  已经选择的数量
     * @param timeLine  时间花费
     * @return
     */
    public static int process(Program[] programs, int done, int timeLine)
    {
        //全部选完，结束方式1
        if (programs.length == 0)
        {
            return done;
        }
        int max = done;//完成数
        for (int i = 0; i < programs.length; i++)
        {
            //可以安排
            if (programs[i].start >= timeLine)
            {
                Program[] next = copyButExcept(programs, i);//返回的是新数组，不用还原现场
                max = Math.max(max, process(next, done + 1, programs[i].end));//返回完成的最大数
            }
        }
        return max;//当安排会议的时间已经超限了，但是还有会议没安排，就通过方式2结束
    }
    
    /**
     *
     * 将programs里的i会议删掉，返回新的数组
     *
     * @param programs
     * @param i
     * @return
     */
    public static Program[] copyButExcept(Program[] programs, int i)
    {
        Program[] ans = new Program[programs.length - 1];
        int index = 0;
        for (int k = 0; k < programs.length; k++)
        {
            if (k != i)
            {
                ans[index++] = programs[k];
            }
        }
        return ans;
    }
    
    
    /**
     *
     * 方法2：对所有的会议记录进行排序，然后再按照每次先选择花费时间最短的会议，逐步累加到最后的会议。
     *
     *
     * @param programs
     * @return
     */
    public static int bestArrange2(Program[] programs)
    {
        Arrays.sort(programs, new ProgramComparator());
        int timeLine = 0;
        int result = 0;
        //按照结束时间，谁早谁先
        for (int i = 0; i < programs.length; i++)
        {
            //start晚于timeLine，可以安排
            if (timeLine <= programs[i].start)
            {
                result++;
                timeLine = programs[i].end;
            }
        }
        return result;
    }
    
    /**
     *
     * 建立比较器
     * 只要最先开完会，就符合贪心算法
     *
     */
    public static class ProgramComparator implements Comparator<Program>
    {
        @Override
        public int compare(Program o1, Program o2)
        {
            return o1.end - o2.end;
        }
    }
    
    /**
     *
     * 测试用例
     *
     * @param programSize
     * @param timeMax
     * @return
     */
    public static Program[] generatePrograms(int programSize, int timeMax)
    {
        Program[] ans = new Program[(int) (Math.random() * (programSize + 1))];
        for (int i = 0; i < ans.length; i++)
        {
            int r1 = (int) (Math.random() * (timeMax + 1));
            int r2 = (int) (Math.random() * (timeMax + 1));
            if (r1 == r2)
            {
                ans[i] = new Program(r1, r1 + 1);
            } else
            {
                ans[i] = new Program(Math.min(r1, r2), Math.max(r1, r2));
            }
        }
        return ans;
    }
    
    public static void main(String[] args)
    {
        int programSize = 12;
        int timeMax = 20;
        int timeTimes = 1000000;
        for (int i = 0; i < timeTimes; i++)
        {
            Program[] programs = generatePrograms(programSize, timeMax);
            if (bestArrange1(programs) != bestArrange2(programs))
            {
                System.out.println("Oops!");
            }
        }
        System.out.println("finish!");
    }
}
