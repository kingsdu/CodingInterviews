package Java_SE.Book.InterviewGoldBook;

/**
 * 字符串的统计字符串
 */
public class GetCountString {


    public static void main(String[] args) {
        String str = "aaabbadddffc";
        System.out.println(getCountString(str));
    }

    /**
     * 给定一个字符串str，返回str的统计字符串
     * <p>
     * aaabbadddffc
     * a 3 b 2 a 1 d 3 f 2 c 1
     * <p>
     * 写while循环要注意控制结束条件
     */
    public static String getCountString(String str) {
        if (str == null || str.equals("")) {
            return "";
        }
        char[] chars = str.toCharArray();
        StringBuilder sb = new StringBuilder();
        int count = 0;
        int i = 0;
        while (i < chars.length) {
            char ch = chars[i];
            while (i < chars.length && ch == chars[i]) {
                count++;
                i++;
            }
            sb.append(ch).append("_").append(count).append("_");
            count = 0;
        }
        String s = sb.toString();
        return s.substring(0, s.length() - 1);
    }


    /**
     * 书上方法 1
     *
     * @param str
     */
    public String getCountString_1(String str) {
        if (str == null || str.equals("")) {
            return "";
        }

        char[] chars = str.toCharArray();
        String res = String.valueOf(chars[0]);
        int num = 1;

        for (int i = 1; i < chars.length; i++) {
            if (chars[i] != chars[i - 1]) {
                res = concat(res, String.valueOf(num), String.valueOf(chars[i]));
                num = 1;
            } else {
                num++;
            }
        }
        return concat(res,String.valueOf(num),"");
    }


    public String concat(String s1, String s2, String s3) {
        return s1 + "_" + s2 + (s3.equals("") ? s3 : s3 + "_");
    }
}
