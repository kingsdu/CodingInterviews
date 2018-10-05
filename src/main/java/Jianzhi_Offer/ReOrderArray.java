package Jianzhi_Offer;

/**
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，
 * 使得所有的奇数位于数组的前半部分，所有的偶数位于数组的后半部分，
 * 并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 */
public class ReOrderArray {


    public static void main(String[] args) {
        int []array = new int[]{1,2,3,4,5,6,7};
        int[] ints = ReOrderArray.reOrderArray_bubble(array);
        for (int i = 0; i < ints.length; i++) {
            System.out.print(ints[i]);
        }
    }

    public static int[] reOrderArray(int []array){
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        int [] arrayRes = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            if(array[i] % 2 != 0){
                sb1.append(array[i]);
            }else {
                sb2.append(array[i]);
            }
        }
        String res = sb1.toString() + sb2.toString();
        char[] chars = res.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            arrayRes[i] = chars[i] - '0';
        }

        return arrayRes;
    }


    /**
     * 通过冒泡排序创建数组
     * @return
     */
    public static int[] reOrderArray_bubble(int []array){
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length-1-i; j++) {
                //前偶后奇交换
                if(array[j]%2 == 0 && array[j+1]%2==1){
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
            }
        }
        return array;
    }

}
