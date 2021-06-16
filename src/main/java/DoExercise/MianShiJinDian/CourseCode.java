package DoExercise.MianShiJinDian;

/**
 * 大型企业面试讲解
 */
public class CourseCode {



    public static void calJieChen(int n){
        int sum = 1;
        while (n>0){
            sum *= n--;
        }
        System.out.println(sum);
    }


    /**
     * 求100的阶乘，这时结果的大小已经超出基本的数据范围
     * 所以需要自己定义计算的方法
     *
     * 使用数组存放每一位数字
     *
     * @param n
     * @return
     */
    public static void calBigDataJieChen(int n){
       int []num = new int[70];
       num[num.length-1] = 1;

        for (int i = 1; i <= n; i++) {
            num = calBig_data(num,i);
        }

        int[] ints = delZero(num);

        for (int i = 0; i < ints.length; i++) {
            System.out.print(ints[i]);
        }
    }



    public static int[] calBig_data(int []num,int key){
        // 相乘
        for (int i = 0; i < num.length; i++) {
            num[i]*=key;
        }

        // 进位、留位
        for (int i = num.length-1; i > 0; i--) {
            num[i-1]+=num[i]/10;
            num[i]%=10;
        }
        return num;
    }



    public static int[] delZero(int []num){
        int left = 0;

        while (num[left] == 0){
            left++;
        }


        if(left != 0){
            int []temp = new int[num.length - left];
            int t = 0;
            for (int i = left; i < num.length; i++) {
                temp[t++] = num[i];
            }
            return temp;
        }else{
            return num;
        }
    }
}
