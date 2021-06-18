package JavaSE.BLS.String;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;

/**
 * @Author: Du
 * @Date: 2021/6/18 11:32
 *
 *
 * String 和 数组 之间的转换
 */
public class C01_List2String
{
    public static void main(String[] args)
    {
        ArrayList<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
    
        String[] strings = List2String(list);
        System.out.println(StringSZ2String(strings));
    }
    
    //StringUtils 帮你遍历数组，用StringBuilder帮你拼好返回
    public static String StringSZ2String(String[] strs){
        return StringUtils.join(strs);
    }
    
    //List 转 String 数组
    public static String[] List2String(ArrayList<String> list){
        return list.toArray(new String[list.size()]);
    }
    
    
}
