package QiyeBishi;

import DataStructBook.BinTreeNode;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 */
public class HengSheng {


    /**
     * 请对输入的一组数字（0~9）进行排序，规则：出现的次数越多，数字越大越靠前
     * <p>
     * 1 3 2 5 6 结果：6 5 3 2 1
     * 1 3 3 6 2 1 结果：3 1 6 2
     * <p>
     * 思路：（1）将数字映射到对应的数组下标中
     * （2）统计出现次数最大的数字，从该数字起，从后向前，取出相同次数的数字
     * <p>
     * 难点：（1）循环结束的条件
     * （2）存结果数组的大小，0的处理
     */
    public static void sort(int[] array) {
        int[] maps = new int[10];
        int[] result = new int[10];
        for (int i = 0; i < array.length; i++) {
            maps[array[i]]++;
        }

        int t = 0;
        while (!isNull(maps)) {
            int max = maps.length - 1;
            for (int i = maps.length - 1; i > 0; i--) {
                if (maps[max] < maps[i]) {
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

    public static boolean isNull(int[] array) {
        int i = 0;
        while (i < array.length && array[i] == 0) {
            i++;
        }
        if (i == array.length) {
            return true;
        }
        return false;
    }


    /**
     * 编码实现找出两个字符串中最长公共子串
     * 可能存在多个最长公共子串
     * 若有多个，输出在较短串中最先出现的那个
     * 字符串1：I  LOVE  HUNDSUN
     * 字符串2：HUNDSUN  LOVE ME
     * 最长公共子串：HUNDSUN
     * <p>
     * 思路：
     * 1 使用" "分割整个字段，遍历逐个比较其中的字符
     * 2
     */
    public static void findCommonStr(String str1,String str2) {
        List<String> res = new ArrayList<String>();
        String[] splitStr1 = str1.split(" ");
        String[] splitStr2 = str2.split(" ");
        for (int i = 0; i < splitStr1.length; i++) {
            for (int j = 0; j < splitStr2.length; j++) {
                if (res.size() != 0 && splitStr2[j].length() < res.get(0).length()) {
                    continue;
                } else {
                    if (splitStr1[i].length() != splitStr2[j].length()) {
                        continue;
                    } else {
                        int index = splitStr2[j].length() - 1;
                        while (index >= 0) {
                            if (splitStr1[i].charAt(index)!=splitStr2[j].charAt(index)) {
                                break;
                            }
                            index--;
                        }
                        if (index == -1) {
                            res.add(splitStr2[j]);
                        }
                    }
                }
            }
        }
        for (String s:
                res) {
            System.out.println(s);
        }
    }


    public static String findCommonStr_2(String strOne, String strTwo){
        if(strOne==null || strTwo==null){
            return null;
        }
        if(strOne.equals("") || strTwo.equals("")){
            return null;
        }

        String max = "";
        String min = "";

        if(strOne.length() < strTwo.length()){
            max = strTwo;
            min = strOne;
        }else{
            max = strOne;
            min = strTwo;
        }

        String current = "";

        for (int i = 0; i < min.length(); i++) {
            for (int begin = 0,end = min.length()-i; end <= min.length() ; begin++,end++) {
                current = min.substring(begin,end);
                if (max.contains(current)){
                    return current;
                }
            }
        }
        return null;
    }


    /**
     *
     */
    public static void printShuiXianHua(){
        for (int i = 100; i < 1000; i++) {
            int a = i/100;
            int b = i/10%10;
            int c = i%10;
            int value = (int)(Math.pow(a, 3) + Math.pow(b, 3) + Math.pow(c, 3));
            if(value == i){
                System.out.println(i);
            }
        }
    }

    public static String subsequences(String word) {
        if (word.isEmpty()) {
            return ""; // base case
        } else {
            char firstLetter = word.charAt(0);
            String restOfWord = word.substring(1);

            String subsequencesOfRest = subsequences(restOfWord);

            String result = "";
            for (String subsequence : subsequencesOfRest.split(",", -1)) {
                result += "," + subsequence;
                result += "," + firstLetter + subsequence;
            }
            result = result.substring(1); // remove extra leading comma
            return result;
        }
    }




    /**
     * 编写一个程序，从txt中读取一篇英文短文，并统计出英文中
     * 不同单词出现的次数，然后输出结果
     */
    public static String readTxt(String path){
        StringBuilder sb = new StringBuilder();
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(new File(path)));
            String s = null;
            while ((s = br.readLine())!= null){
                sb.append(s);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(br != null){
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return sb.toString();
    }


    /**
     * 统计单词的个数
     * @param txt
     */
    public static Map<String,Integer> calCharNum(String txt){
        Map<String,Integer> hashMap = new HashMap();
        String[] strings = txt.split(" ");
        for (int i = 0; i < strings.length; i++) {
            if(hashMap.containsKey(strings[i])){
                hashMap.put(String.valueOf(strings[i]),hashMap.get(strings[i])+1);
            }else{
                hashMap.put(String.valueOf(strings[i]),1);
            }
        }
        return hashMap;
    }





    /**
     * 二叉树查找
     * @return
     */
    public int binTreeSearch(BinTreeNode binTreeNode, Integer value){
        int compareResult = value.compareTo(binTreeNode.value);

        if(compareResult == 0){
            return binTreeNode.value;
        }else if(compareResult > 0 && binTreeNode.rightChild != null){
            return binTreeSearch(binTreeNode.rightChild,value);
        }else if(compareResult < 0 && binTreeNode.leftChild != null){
            return binTreeSearch(binTreeNode.leftChild,value);
        }else {
            return -1;
        }
    }




    /**
     * 计算小数点数的平均值
     */
    public static int calAverage(String str){
        String[] nums = str.split(",");
        int sum = 0;
        int i = 0;
        for (i = 0; i < nums.length; i++) {
            if(sum >= Integer.MAX_VALUE){
                return Integer.MAX_VALUE;
            }
            sum+=Integer.valueOf(nums[i]);
        }
        return sum/i;
    }


    /**
     * 输出结果
     */
    public void printResult(int result,String path){
        BufferedWriter bw = null;
        try {
            bw = new BufferedWriter(new FileWriter(new File(path)));
            bw.write(String.valueOf(result));
            bw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(bw!=null){
                try {
                    bw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    /**
     * 36进制 转 10进制
     * @param pSrc
     * @return
     */
    public int ThirdSix2Decimal(String pSrc){
        char[] chars = pSrc.toCharArray();
        int index = chars.length;
        int sum = 0;
        for (int i = 0; i < chars.length; i++) {
            int num = chars[i] - '0';
            sum+=Math.pow(num,index--);
        }
        return sum;
    }


    /**
     * 10进制 转 36进制
     * @param iSrc
     * @return
     */
    public static String Decimal2ThirdSix(int iSrc){
        Map<Integer, String> lastNum = getLastNum();
        StringBuilder sb = new StringBuilder();
        while (iSrc/36!=0){
            sb.append(iSrc/36);
            iSrc%=36;
        }
        sb.append(lastNum.get(iSrc%36));
        return sb.toString();
    }



    public static Map<Integer,String> getLastNum(){
        Map<Integer,String> hashMap = new HashMap();
        for (int i = 1; i <= 9; i++) {
            hashMap.put(i,String.valueOf(i));
        }

        for (int i = 10,j='A'; i < 36; i++,j++) {
            hashMap.put(i,String.valueOf((char)j));
        }
        return hashMap;
    }




    public static void main(String[] args) {
        System.out.println(Decimal2ThirdSix(100));
    }



}
