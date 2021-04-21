package Java_SE.Book.InterviewGoldBook;

/**
 * 字符串中数字子串求和
 */
public class NumSum {


    public static void main(String[] args) {
        String str = "A-1B--2C--D6E";
        System.out.println(NumSum.calStringSum(str));
    }


    /**
     *
     * 求字符串中的子串之和
     *
     * str = "A1CD2E33";
     * retrurn 36
     *
     * str = "A-1B--2C--D6E"
     * retrurn 7
     *
     * @return
     */
    public static int calStringSum(String str){
        if(str == null){
            return 0;
        }

        char[] charArr = str.toCharArray();
        int sum = 0;
        int num = 0;

        boolean posi = true;
        int cur = 0;
        for (int i = 0; i < charArr.length; i++) {
            cur = charArr[i] - '0';
            if(cur < 0 || cur > 9){
                sum+=num;
                num = 0;
                if(charArr[i] == '-'){
                    if(i-1 > -1 && charArr[i-1] =='-'){
                        posi = !posi;
                    }else{
                        posi = false;
                    }
                }else{
                    posi = true;
                }
            }else{
                num=num*10+(posi?cur:-cur);
            }
        }
        sum += num;
        return sum;
    }


}
