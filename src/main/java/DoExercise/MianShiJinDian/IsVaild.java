package DoExercise.MianShiJinDian;


public class IsVaild {


    public static void main(String[] args) {
        IsVaild isVaild = new IsVaild();
        System.out.println(isVaild.isVaild("A1123"));
    }
    /**
     * 给定字符串str，如果符合日常的书写整数形式，并且属于32位整数范围
     * 返回str所代表的整数值，否则返回0
     *
     * str = "123"   结果 123
     * str = "-123"  结果 -123
     * str = "0123"  结果 0
     * str = "A12"   结果 0
     * str = "2147483648"  结果 0 越界
     *
     * @return
     */
    public int isVaild(String str){
        char[] chars = str.toCharArray();

        int cur;
        int num = 0;
        boolean posi = true;
        for (int i = 0; i < chars.length; i++) {
            cur = chars[i] - '0';
            if(cur<0 || cur>9){
                if(chars[i] == '-' && num==0 && posi == true){
                    posi = false;
                }else {
                    return 0;
                }
            }else{
                num = num*10+(posi?cur:-cur);
            }
        }
        return Integer.MIN_VALUE >= num || num < Integer.MAX_VALUE ? 0 :num;
    }

}
