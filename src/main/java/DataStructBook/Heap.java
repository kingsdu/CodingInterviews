package DataStructBook;

/**
 * 堆的数据结构
 */
public class Heap {


    /**
     *
     * 堆排序的思想：
     *
     * 已构建最小根堆为例
     * 1 根据buildMaxHeap，遍历整个堆，将堆中的最大数放入到root节点
     * 2 将root中保存的当前堆中的最大值，和堆最后位置的数据进行交换，最大数被交换到最后
     * 3 对剩下数据的堆再次进行buildMaxHeap，将最大数据放入root节点。
     * 4 在将其和堆最后位置 - 1 的数交换，次大的数被交换到倒数第二位
     * 。。。。。。。 循环
     * 直到程序结束，堆就是最小堆
     * @param args
     */
    public static void main(String[] args) {
        int[] array = { 9, 3, 2, 8, 1, -2, -3 };

        System.out.println("Before heap:");
        printArray(array);

        heapSort(array);

        System.out.println("After heap sort:");
        printArray(array);
    }



    public static void heapSort(int[] array) {
        if (array == null || array.length <= 1) {
            return;
        }
        buildMaxHeap(array);//构造最大堆，root是最大数

        //提供
        for (int i = array.length - 1; i >= 1; i--) {
            exchangeElements(array, 0, i);
            maxHeap(array, i, 0);
        }
    }



    private static void buildMaxHeap(int[] array) {
        if (array == null || array.length <= 1) {
            return;
        }

        int half = array.length / 2;
        for (int i = half; i <=array.length; i++) {
            maxHeap(array, array.length, i);
        }
    }


    private static void maxHeap(int[] array, int heapSize, int index) {
        int left = index * 2 + 1;
        int right = index * 2 + 2;

        int largest = index;
        //父节点 < 左子节点 交换
        if (left < heapSize && array[left] > array[index]) {
            largest = left;
        }

        //父节点 < 右子节点 交换
        if (right < heapSize && array[right] > array[largest]) {
            largest = right;
        }

        if (index != largest) {
            exchangeElements(array, index, largest);
            maxHeap(array, heapSize, largest);
        }
    }


    public static void printArray(int[] array) {
        System.out.print("{");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
            if (i < array.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("}");
    }

    public static void exchangeElements(int[] array, int index1, int index2) {
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }
}



