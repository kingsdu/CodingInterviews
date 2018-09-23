package InterviewGoldBook;

/**
 * 字符串中数字子串求和
 */
public class NumSum {


    public static void main(String[] args) {
//        String str = "A1CD2E33";
    }



    /**
     * 求字符串中的子串之和
     *
     * str = "A1CD2E33";
     * retrurn 36
     *
     * str = "A-1B--2C--D6E"
     */
    public static int calNumStr(String str){
        if(str == null){
            return 0;
        }

        char[] charArr = str.toCharArray();
        int res = 0;
        int num = 0;
        boolean posi = true;
        int cur = 0;

        for (int i = 0; i < charArr.length; i++) {
            cur = charArr[i] - '0';
            if(cur < 0 || cur > 9){
                res +=num;
                num = 0;
                if(charArr[i] == '-'){

                }
            }
        }
        return 0;
    }




}
