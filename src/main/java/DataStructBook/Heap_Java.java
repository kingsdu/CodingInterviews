package DataStructBook;

/**
 * 提供Java自带方法进行堆操作
 */
public class Heap_Java {

    public static void main(String[] args) {
        Heap_Java heap_java = new Heap_Java();
        int[] array = {9, 3, 2, 8, 1, -2, -3};
        int[] ints = heap_java.heapSort(array, array.length);
        for (int i :
                ints) {
            System.out.print(i + " ");
        }
    }

    public int[] heapSort(int[] A, int n) {
        int lastIndex = n - 1;
        buildMaxHeap(A, lastIndex);//建立最大堆
        while (lastIndex > 0) {
            swap(A, 0, lastIndex);
            if (--lastIndex == 0) {
                break;
            }
            adjustHeap(A, 0, lastIndex);
        }
        return A;
    }


    public void buildMaxHeap(int[] arr, int lastIndex) {
        int j = (lastIndex - 1) / 2;

        while (j >= 0) {
            int rootIndex = j;
            adjustHeap(arr, rootIndex, lastIndex);
            j--;
        }
    }


    public void adjustHeap(int[] arr, int rootIndex, int lastIndex) {
        int biggerIndex = rootIndex;

        int leftChildIndex = rootIndex * 2 + 1;
        int rightChildIndex = rootIndex * 2 + 2;

        if (rightChildIndex <= lastIndex) {
            if (arr[rightChildIndex] > arr[rootIndex] || arr[leftChildIndex] > arr[rootIndex]) {
                //将子节点更大的元素下标赋值给biggerIndex
                biggerIndex = arr[rightChildIndex] > arr[leftChildIndex]
                        ? rightChildIndex : leftChildIndex;
            }
        } else if (leftChildIndex <= lastIndex) {//保证左孩子存在，且不能越界
            if (arr[leftChildIndex] > arr[rootIndex]) {
                biggerIndex = leftChildIndex;
            }
        }

        if (biggerIndex != rootIndex) {
            swap(arr, biggerIndex, rootIndex);
            adjustHeap(arr, biggerIndex, lastIndex);
        }
    }


    public void swap(int[] arr, int biggerIndex, int rootIndex) {
        int temp = arr[rootIndex];
        arr[rootIndex] = arr[biggerIndex];
        arr[biggerIndex] = temp;
    }


}
