package DoExercise.HSP_ZCY.A027_位图;

import java.util.HashSet;

/**
 * @Author: Du
 * @Date: 2021/6/14 15:29
 *
 * 位图可以极大压缩空间
 * 功能方面：
 * 位图可以收集数字，并判断数字是否存在
 *
 * 程序功能：如何将数字存在一个long[]里面
 *
 * 程序注意点
 * 1 左移时必须用1L
 * 2 num & 63 == num % 64，该方法只适用于 被除数是 2的次幂（2 4 8 16 32 64）
 *
 * bit[num >> 6] |= (1L << (num & 63))
 * bit[num >> 6] &= ~(1L << (num & 63))
 * bit[num >> 6] & (1L << (num & 63)) != 0
 */
public class Code01_BitMap1
{
    public static class BitMap {
        
        private long[] bits;//[0,63][64,127][128,191].........
        
        public BitMap(int max) {
            bits = new long[(max + 64) >> 6];//有多少位数
        }
        //170为例子
        public void add(int num) {
            //bits[num >> 6] 定位num在哪个bit[?]
            //num & 63(111 1111) == num % 64，该方法只适用于 被除数是 2的次幂（2 4 8 16 32）
            //将num存入bit[i]中对应的64个空间中对应num的位置(42)
            bits[num >> 6] |= (1L << (num & 63));//这个地方1L没有64位，1默认是32位
        }
        //170为例子
        public void delete(int num) {
            // 001(41个0)
            //~000(41个0)
            //&000(41个0)
            //上述过程等于消除170在bit[3]中的标记
            bits[num >> 6] &= ~(1L << (num & 63));//将存入bit[i]中对应的64个空间中对应num的位置置为0
        }
        
        public boolean contains(int num) {
            return (bits[num >> 6] & (1L << (num & 63))) != 0;//没有标记就没有值，反之就有
        }
        
    }
    
    public static void main(String[] args) {
        System.out.println("测试开始！");
        int max = 10000;
        BitMap bitMap = new BitMap(max);
        HashSet<Integer> set = new HashSet<>();
        int testTime = 10000000;
        for (int i = 0; i < testTime; i++) {
            int num = (int) (Math.random() * (max + 1));
            double decide = Math.random();
            if (decide < 0.333) {
                bitMap.add(num);
                set.add(num);
            } else if (decide < 0.666) {
                bitMap.delete(num);
                set.remove(num);
            } else {
                if (bitMap.contains(num) != set.contains(num)) {
                    System.out.println("Oops!");
                    break;
                }
            }
        }
        for (int num = 0; num <= max; num++) {
            if (bitMap.contains(num) != set.contains(num)) {
                System.out.println("Oops!");
            }
        }
        System.out.println("测试结束！");
    }
}
