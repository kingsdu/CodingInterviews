package Java_SE.Book.InterviewGoldBook;

public class IsRotation {


    public static void main(String[] args) {
        IsRotation isRotation = new IsRotation();
        String a = "abcd";
        String b = "cdab";
        if(isRotation.isRotation(a,b)){
            System.out.println(true);
        }else {
            System.out.println(false);
        }
    }


    /**
     * a = "cdab" b = "abcd"  true
     * a = "1ab2" b = "ab12"  true
     * a = "2ab1" b = "ab12"  false
     * 字符串是否为旋转字符串
     */
    public boolean isRotation(String a, String b) {
        if (a == null || b == null || a.length() != b.length()) {
            return false;
        }

        String s = a + a;
        return getIndexOf(s, b);
    }


    public boolean getIndexOf(String s, String a) {
        char[] chars = s.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            for (int start = 0, end = chars.length - 1 - i; end < chars.length; start++, end++) {
                if (a.equals(s.substring(start, end)))
                    return true;
            }
        }
        return false;
    }
}
