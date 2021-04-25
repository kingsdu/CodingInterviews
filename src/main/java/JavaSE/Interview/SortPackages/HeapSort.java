package JavaSE.Interview.SortPackages;


/**
 * https://www.bilibili.com/video/BV1Eb41147dK?from=search&seid=11591651876658355142
 *
 * heap
 * 1、是一颗完全二叉树
 * 2、父节点 > 子节点的值
 * <p>
 * parent = (i-1)/2
 * child1 = 2 * i + 1
 * child2 = 2 * i + 2
 */
public class HeapSort
{
    
    public static void main(String[] args)
    {
        int[] tree = {2, 5, 3, 1, 10, 4};
        int n = 6;
        HeapSort h = new HeapSort();
        h.heapSort(tree, n);
        
        for (int i = 0; i < tree.length; i++)
        {
            System.out.print(tree[i] + " ");
        }
    }
    
    public void heapSort(int[] tree, int n)
    {
        //堆化
        buildHeap(tree, n);
        //交换最后一个节点和第一个节点，剪枝
        for (int i = n - 1; i >= 0; i--)
        {
            swap(tree,i,0);
            heapify(tree,i,0);
        }
    }
    
    
    /**
     *
     * 从最后一个节点开始做headify操作
     *
     * @param tree
     * @param n
     */
    public void buildHeap(int[] tree, int n)
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
    public void heapify(int[] tree, int n, int i)
    {
        if (i > n)
        {
            return;
        }
        
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
            swap(tree, max, i);
            heapify(tree, n, max);
        }
    }
    
    /**
     *
     * 大根堆
     *
     * @param tree
     * @param n
     * @param i
     */
//    public void headifyMin(int[] tree, int n, int i)
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
    
    public void swap(int[] tree, int i, int j)
    {
        int tmp = tree[i];
        tree[i] = tree[j];
        tree[j] = tmp;
    }
}
