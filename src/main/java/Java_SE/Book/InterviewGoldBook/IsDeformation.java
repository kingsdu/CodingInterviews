package Java_SE.Book.InterviewGoldBook;

/**
 * 字符串处理
 */
public class IsDeformation {


    /**
     * 判断两个字符串是否互为变形词
     * <p>
     * 如果str1和str2中出现的字符种类和每种字符出现的次数都一样，那么str1和str2互为变形词。
     * <p>
     * str1 = "123"  str2 = "321"  返回ture
     * str1 = "123"  str2 = "2331" 返回false
     *
     * 方法思路和知识点
     * 1 tcCharArray方法的使用
     * 2 256长度的数组
     * 3 int到char类型的转换
     * 4 将char[i]映射到map[]中，统计次数较好
     */
    public boolean judgeString(String str1, String str2) {
        if (str1.length() != str2.length()) {
            return false;
        }

        char[] chars1 = str1.toCharArray();
        char[] chars2 = str2.toCharArray();

        int[] map = new int[256];

        for (int i = 0; i < chars1.length; i++) {
            map[chars1[i]]++;
        }

        for (int i = 0; i < chars2.length; i++) {
            if (map[chars2[i]]-- == 0) {
                return false;
            }
        }
        return true;
    }


    /**
     * 统计下列数字出现的个数，并在右侧输出统计结果
     * 左边是数组，右边是统计结果
     *
     * [1] [1,1]
     * [2,1,2] [2 2,1 1]
     * [3,2,1,2,1] [1 2,2 2,2 1]
     */
    public void xiangWuShuo(int[] array){

        int[] maps = new int[256];

        for (int i = 0; i < array.length; i++) {
            maps[array[i]]++;
        }

        for (int i = 0; i < maps.length; i++) {
            if(maps[i] == 0){
                continue;
            }
            System.out.println("["+i+","+maps[i]+"]");
        }

    }


    public void quickSort(int[] array,int start,int end){
        if(start > end){
            return;
        }

        int i = start;
        int j = end;

        int key = array[i];

        while (i != j){
            while (i<j && array[j]>key){
                j--;
            }

            while (i<j && array[i]<key){
                i++;
            }

            if(i<j){
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }

        array[start] = array[i];
        array[i] = key;

        quickSort(array,start,i-1);
        quickSort(array,i+1,end);
    }

}
