package DoExercise.HSP_ZCY.A006_排序;

import DoExercise.JianzhiOffer.Offer000_Common;

/**
 * @Author: Du
 * @Date: 2021/7/8 11:15
 */
public class Code04_Heap01
{
    
    public static class MyMaxHeap
    {
        private int[] heap;
        private final int limit;
        private int heapSize;
        
        public MyMaxHeap(int limit)
        {
            heap = new int[limit];
            this.limit = limit;
            heapSize = 0;
        }
        
        public boolean isEmpty()
        {
            return heapSize == 0;
        }
        
        public boolean isFull()
        {
            return heapSize == limit;
        }
        
        public void push(int value)
        {
            if (heapSize == limit)
            {
                throw new RuntimeException("heap is full");
            }
            heap[heapSize] = value;
            heapInsert(heap, heapSize++);//调整大根堆的操作复杂度时logN
        }
        
        public int pop()
        {
            int ans = heap[0];
            Offer000_Common.swap(heap, 0, --heapSize);
            heapify(heap, 0, heapSize);
            return ans;
        }
        
        //插入数据保证大根堆
        private void heapInsert(int[] arr, int index)
        {
            while (arr[index] > arr[(index - 1) / 2])//如果index结点比其父类的值大，交换
            {
                Offer000_Common.swap(arr, index, (index - 1) / 2);
                index = (index - 1) / 2;
            }
        }
        
        //从根部向下沉，保证大根堆，只需要调整一侧即可，因为整体已经是大根堆了
        private void heapify(int[] arr, int index, int heapSize)
        {
            int left = index * 2 + 1;
            while (left < heapSize)
            {
                int largest = left + 1 < heapSize && arr[left + 1] > arr[left] ? left + 1 : left;//子结点中值较大的
                largest = arr[largest] > arr[index] ? largest : index;//子中较大的和父类比较
                if (largest == index) break;
                Offer000_Common.swap(arr, largest, index);
                index = largest;
                left = index * 2 + 1;
            }
        }
        
    }
    
    public static class RightMaxHeap
    {
        private int[] arr;
        private final int limit;
        private int size;
        
        public RightMaxHeap(int limit)
        {
            arr = new int[limit];
            this.limit = limit;
            size = 0;
        }
        
        public boolean isEmpty()
        {
            return size == 0;
        }
        
        public boolean isFull()
        {
            return size == limit;
        }
        
        public void push(int value)
        {
            if (size == limit)
            {
                throw new RuntimeException("heap is full");
            }
            arr[size++] = value;
        }
        
        public int pop()
        {
            int maxIndex = 0;
            for (int i = 1; i < size; i++)
            {
                if (arr[i] > arr[maxIndex])
                {
                    maxIndex = i;
                }
            }
            int ans = arr[maxIndex];
            arr[maxIndex] = arr[--size];
            return ans;
        }
        
    }
    
    public static void main(String[] args)
    {
        int value = 1000;
        int limit = 100;
        int testTimes = 1000000;
        for (int i = 0; i < testTimes; i++)
        {
            int curLimit = (int) (Math.random() * limit) + 1;
            MyMaxHeap my = new MyMaxHeap(curLimit);
            RightMaxHeap test = new RightMaxHeap(curLimit);
            int curOpTimes = (int) (Math.random() * limit);
            for (int j = 0; j < curOpTimes; j++)
            {
                if (my.isEmpty() != test.isEmpty())
                {
                    System.out.println("Oops!");
                }
                if (my.isFull() != test.isFull())
                {
                    System.out.println("Oops!");
                }
                if (my.isEmpty())
                {
                    int curValue = (int) (Math.random() * value);
                    my.push(curValue);
                    test.push(curValue);
                } else if (my.isFull())
                {
                    if (my.pop() != test.pop())
                    {
                        System.out.println("Oops!");
                    }
                } else
                {
                    if (Math.random() < 0.5)
                    {
                        int curValue = (int) (Math.random() * value);
                        my.push(curValue);
                        test.push(curValue);
                    } else
                    {
                        if (my.pop() != test.pop())
                        {
                            System.out.println("Oops!");
                        }
                    }
                }
            }
        }
        System.out.println("finish!");
        
    }
}
