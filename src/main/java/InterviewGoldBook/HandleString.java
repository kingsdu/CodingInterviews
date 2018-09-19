package InterviewGoldBook;

import java.util.Stack;

/**
 * 字符串处理
 */
public class HandleString {


    /**
     * 判断两个字符串是否互为变形词
     * <p>
     * 如果str1和str2中出现的字符种类和每种字符出现的次数都一样，那么str1和str2互为变形词。
     * <p>
     * str1 = "123"  str2 = "321"  返回ture
     * str1 = "123"  str2 = "2331" 返回false
     *
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
     *
     * 该方法行不通，因为栈内有元素的情况下，向其中添加元素只会在栈顶
     * @param str1
     * @param str2
     * @return
     */
    public boolean judgeString_me(String str1, String str2) {
        if (str1.length() != str2.length()) {
            return false;
        }

        Stack<Character> stack1 = new Stack<Character>();
        Stack<Character> stack2 = new Stack<Character>();

        for (int i = 0; i < str1.length(); i++) {
            stack1.push(str1.charAt(i));
        }

        for (int i = 0; i < str2.length(); i++) {
            stack2.push(str2.charAt(i));
        }

        int count = 0;

        while (!stack1.isEmpty()) {
            char ch = stack1.pop();
            while (!stack2.isEmpty()) {
                char chx = stack2.pop();
                if (ch == chx) {
                    count++;
                    break;
                }
                stack2.push(chx);
            }
        }

        if (count == str1.length()) {
            return true;
        }
        return false;
    }


    /**
     * 统计字符串中字母出现的次数
     */
    public void staticNumTime(String str){
        char[] chars = str.toCharArray();

        int [] maps = new int[256];

        for (int i = 0; i < chars.length; i++) {
            maps[chars[i]]++;
        }

        int max = 0;
        int index = 0;
        for (int i = 0; i < maps.length; i++) {
            if(maps[i] == 0){
                continue;
            }else{
                if(max < maps[i]){
                    max = maps[i];
                    index = i;
                }
            }
        }
        System.out.println(maps[index]);
    }


    /**
     * 统计下列数字出现的个数，并在右侧输出统计结果
     * 左边是数组，右边是统计结果
     *
     * [1] [1,1]
     * [2,1,2] [2 2,1 1]
     * [3,2,1,2,1] [1 3,2 2,2 1]
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


    public void quickSort(int[] array,int left,int right){
        if(right<left){
            return;
        }
        int key = array[left];
        int i = left,j = right;

        while (i!=j){
            while (i < j && array[j] >= key){
                j--;
            }

            while (i<j && array[i] <= key){
                i++;
            }

            if(i < j){
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }

        array[left] = array[i];
        array[i] = key;
        quickSort(array,left,i-1);
        quickSort(array,i+1,right);
    }
}
