package DoExercise.HSP_ZCY.A001_Array;

/**
 *
 * 稀疏数组：当一个数组中大部分元素为０，或者为同一个值的数组时，可以使用稀疏数组来保存该数组。
 *
 * 稀疏数组的处理方法是:
 * （1）记录数组一共有几行几列，有多少个不同的值
 * （2）把具有不同值的元素的行列及值记录在一个小规模的数组中，从而缩小程序的规模
 *
 *  具体见印象笔记
 *
 */
public class SparseArrayHSP
{

    /**
     *
     * 自己写的稀疏数组
     *
     * @param args
     */
    public static void main(String[] args)
    {
        int[][] tarArrays = getArrays();
        System.out.println("------原数组------");

        for (int[] array :
                tarArrays)
        {
            for (int number :
                    array)
            {
                System.out.print(number + " ");
            }
            System.out.println();
        }
        
        int arrayNum = getArrayCount(tarArrays);
        int[][] resArray = new int[arrayNum+1][3];
        int[][] arraysNumber = getXSArray(tarArrays, resArray);

        System.out.println("------稀疏数组------");
        for (int i = 0; i < arraysNumber.length; i++)
        {
            for (int j = 0; j < arraysNumber[0].length; j++)
            {
                System.out.print(arraysNumber[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println("------原数组------");
        int[][] recoverArray = recoverArray(arraysNumber);
        for (int[] array :
                recoverArray)
        {
            for (int number :
                    array)
            {
                System.out.print(number + " ");
            }
            System.out.println();
        }
    }


    /**
     * 将普通数组转化为二维稀疏数组
     *
     * 行 列 值
     *
     * @return
     */
    public static int[][] getXSArray(int[][] tarArray, int[][] resArray)
    {
        int n=0;
        //记录稀疏数组整个有多少行，多少列，多少个值
        resArray[0][0] = tarArray.length;
        resArray[0][1] = tarArray[0].length;
        resArray[0][2] = resArray.length;
        for (int i = 0; i < tarArray.length; i++)
        {
            for (int j = 0; j < tarArray[i].length; j++)
            {
                if (tarArray[i][j] != 0)
                {
                    n++;
                    resArray[n][0] = i;//行
                    resArray[n][1] = j;//列
                    resArray[n][2] = tarArray[i][j];//值
                }
            }
        }
        return resArray;
    }


    /**
     * 计算普通的二维数组中有几个数字
     *
     * @param arrays
     * @return
     */
    public static int getArrayCount(int[][] arrays)
    {
        int count = 0;
        for (int i = 0; i < arrays.length; i++)
        {
            for (int j = 0; j < arrays[i].length; j++)
            {
                if (arrays[i][j] != 0)
                {
                    count++;
                }
            }
        }
        return count;
    }


    /**
     * 生成一个二维数组
     *
     * @return
     */
    public static int[][] getArrays()
    {
        int[][] resArray = new int[11][11];
        for (int i = 0; i < 11; i++)
        {
            for (int j = 0; j < 11; j++)
            {
                resArray[i][j] = 0;
            }
        }
        resArray[1][2] = 1;
        resArray[2][3] = 2;
        return resArray;
    }


    /**
     *
     * 将稀疏数组恢复为二维数组
     *
     * @return
     */
    public static int[][] recoverArray(int[][] XSArray){
        int[][] rowArray = new int[XSArray[0][0]][XSArray[0][1]];

        for (int i = 1; i < XSArray.length; i++)
        {
            rowArray[XSArray[i][0]][XSArray[i][1]] = XSArray[i][2];
        }

        return rowArray;
    }


    /**
     *
     *
     * 课后练习
     *
     * 在前面的基础上，将稀疏数组保存到磁盘上，比如 map.data
     * 恢复原来的数组时，读取map.data 进行恢复
     *
     *
     * 思路：Java文件IO的操作，算法不变，就是将输出的内容换为JavaIO操作至数据库中
     */



}
