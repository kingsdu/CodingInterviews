package QiyeBishi;

/**
 *
 */
public class HengSheng {


    /**
     * 请对输入的一组数字（0~9）进行排序，规则：出现的次数越多，数字越大越靠前
     *
     * 1 3 2 5 6 结果：6 5 3 2 1
     * 1 3 3 6 2 1 结果：3 1 6 2
     *
     * 思路：（1）将数字映射到对应的数组下标中
     *      （2）统计出现次数最大的数字，从该数字起，从后向前，取出相同次数的数字
     *
     * 难点：（1）循环结束的条件
     *      （2）存结果数组的大小，0的处理
     */
    public static void sort(int []array){
        int []maps = new int[10];
        int []result = new int[10];
        for (int i = 0; i < array.length; i++) {
            maps[array[i]]++;
        }

        int t = 0;
        while (!isNull(maps)){
            int max = maps.length-1;
            for (int i = maps.length-1; i > 0; i--) {
                if(maps[max] < maps[i]){
                    max = i;
                }
            }
            result[t++] = max;
            maps[max] = 0;
        }

        for (int i :
                result) {
            System.out.println(i);
        }
    }

    public static boolean isNull(int []array){
        int i = 0;
        while (i < array.length && array[i] == 0){
            i++;
        }
        if(i == array.length){
            return true;
        }
        return false;
    }


    public static void main(String[] args) {
        int []array = new int[]{1,3,3,6,2,1,2,1,1};
        HengSheng.sort(array);
    }







}
