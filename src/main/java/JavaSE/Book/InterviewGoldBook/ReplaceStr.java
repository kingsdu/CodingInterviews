package JavaSE.Book.InterviewGoldBook;

/**
 * 给定的三个字符串str,from,to，
 * 把str中所有from的子串全部替换成to字符串，
 * 对连续出现的from的部分要求只替换成一个to字符串
 */
public class ReplaceStr {


    public static String repalceStr(String str,String from,String to){
        if(str.length() < from.length() || to == null){
            return null;
        }

        String s = null;
        for (int begin = 0,end=from.length(); end < str.length(); begin++,end++) {
            String current = str.substring(begin, end);
            if(from.equals(current)){
               s = str.substring(0,begin)+to+str.substring(end,str.length());
            }
        }

        return s;
    }



}
