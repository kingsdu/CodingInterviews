package QiyeBishi;

/**
 * 网易面试题
 */
public class WangYiInterview {

    public static void main(String[] args) {
        String rawStr = "bwbwb";
        System.out.println(WangYiInterview.calWhiteAndBlack(rawStr));
    }

    /**
     * 一个字符串，只有b和w，统计连续的b和w的个数
     */
    public static int calWhiteAndBlack(String inputArray){
        int count = 0;
        for (int i=0;i<inputArray.length();i++){
            if(i == inputArray.length()-1){
                if(inputArray.charAt(i-1) == 'b' && inputArray.charAt(i) == 'w'
                        || inputArray.charAt(i-1) == 'w' && inputArray.charAt(i) == 'b'){
                    if(inputArray.charAt(i) == 'b'||inputArray.charAt(i) == 'w'){
                        count++;
                    }
                }
            }else{
                if(inputArray.charAt(i) == 'b' && inputArray.charAt(i+1) == 'w'
                        || inputArray.charAt(i) == 'w' && inputArray.charAt(i+1) == 'b'){
                    if(inputArray.charAt(i) == 'b'||inputArray.charAt(i) == 'w'){
                        count++;
                    }
                }
            }
        }

        return count;
    }
}
