package DoExercise.HSP_ZCY.A006_排序;


import DoExercise.JianzhiOffer.Offer000_Common;

import java.util.Arrays;

/**
 * 堆排序：时间复杂度：o(n log n)  空间复杂度：o(1)  不稳定算法
 * <p>
 * https://www.bilibili.com/video/BV1Eb41147dK?from=search&seid=11591651876658355142
 * <p>
 * heap
 * 1、是一颗完全二叉树
 * 2、父节点 > 子节点的值
 * <p>
 * parent = (i-1)/2
 * child1 = 2 * i + 1
 * child2 = 2 * i + 2
 * <p>
 * <p>
 * 99万个数字 耗时 1s
 */
public class A007_堆排序
{
    
    public static void main(String[] args)
    {
        int[] tree = {1, 2, 10, 4, 1, 4, 3, 3};
        //heapSort(tree, tree.length);
        buildHeap(tree,tree.length);
        Arrays.stream(tree).forEach(e -> System.out.print(e + " "));

//        SimpleDateFormat startTime = new SimpleDateFormat("yyyy:MM:dd:HH:mm:ss");
//        System.out.println("排序开始时间：" + startTime.format(new Date()));
//        heapSort_1_test();
//        SimpleDateFormat endTime = new SimpleDateFormat("yyyy:MM:dd:HH:mm:ss");
//        System.out.println("排序结束时间：" + endTime.format(new Date()));
    }
    
    public static void heapSort_1_test()
    {
        //测试80万个数据的排序
        int[] treeTest = new int[9999999];
        for (int index = 0; index < 9999999; index++)
        {
            treeTest[index] = (int) (Math.random() * 9999999);
        }
        //增量gap，并逐步缩小增量
        heapSort(treeTest, treeTest.length);
    }
    
    
    /**
     * 1 先堆化一次
     * 2 交换最后一个节点和第一个节点
     * 3 剪枝
     * 4 重新堆化
     *
     * @param tree
     * @param n
     */
    public static void heapSort(int[] tree, int n)
    {
        //先整体堆化一次，根结点一定是所有里面最大的值
        buildHeap(tree, n);
        //交换最后一个节点和第一个节点，剪枝
        for (int i = n - 1; i >= 0; i--)
        {
            Offer000_Common.swap(tree, i, 0);//最后一个节点 和 根节点交换
            //重写堆化
            heapify(tree, i, 0);//剪枝后，需要从最后一位开始
        }
    }
    
    
    /**
     * 从最后一个节点开始做headify操作
     *
     * @param tree
     * @param n
     */
    public static void buildHeap(int[] tree, int n)
    {
        int lastNode = n - 1;
        int parent = (lastNode - 1) / 2;
        for (int i = parent; i >= 0; i--)
        {
            heapify(tree, n, i);
        }
    }
    
    /**
     * @param tree
     * @param n    共有多少个节点
     * @param i    对哪个节点做heapify操作
     */
    public static void heapify(int[] tree, int n, int i)
    {
        if (i > n) return;
        int child1 = 2 * i + 1;
        int child2 = 2 * i + 2;
        int max = i;
        //子节点 > 父节点
        if (child1 < n && tree[child1] > tree[max])
        {
            max = child1;
        }
        if (child2 < n && tree[child2] > tree[max])
        {
            max = child2;
        }
        if (max != i)
        {
            Offer000_Common.swap(tree, i, max);
            heapify(tree, n, max);
        }
    }


//    /**
//     *
//     * 大根堆
//     *
//     * @param tree
//     * @param n
//     * @param i
//     */
//    public static void headifyMin(int[] tree, int n, int i)
//    {
//        if (i > n)
//        {
//            return;
//        }
//
//        int child1 = 2 * i + 1;
//        int child2 = 2 * i + 2;
//        int min = i;
//        //子节点 > 父节点
//        if (child1 < n && tree[child1] < tree[min])
//        {
//            min = child1;
//        }
//        if (child2 < n && tree[child2] < tree[min])
//        {
//            min = child2;
//        }
//        if (min != i)
//        {
//            swap(tree, min, i);
//            headifyMin(tree, n, min);
//        }
//    }

}
