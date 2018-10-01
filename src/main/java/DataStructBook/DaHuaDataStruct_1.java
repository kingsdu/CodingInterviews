package DataStructBook;

public class DaHuaDataStruct_1 {

    public static void main(String[] args) {
        DaHuaDataStruct_1.calSum(100);
    }

    /**
     * 计算1,100之和，要求提供更快捷的方法
     */
    public static void calSum(int n){
        int sum = 0;
        sum = (1+n)*100/2;
        System.out.println(sum);
    }
}
