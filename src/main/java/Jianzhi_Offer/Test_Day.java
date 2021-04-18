package Jianzhi_Offer;


import java.util.ArrayList;

/**
 * 每日一练，自己写算法
 */
public class Test_Day
{
    
    public static void main(String[] args)
    {
        int[][] matrix = {{1, 2, 3, 4, 5}, {6, 7, 8, 9, 10}, {11, 12, 13, 14, 15}, {16, 17, 18, 19, 20}, {21, 22, 23, 24, 25}};
        Test_Day test_day = new Test_Day();
        int[] ints = test_day.printArray(matrix);
        for (int x :
                ints)
        {
            System.out.print(x + " ");
        }
    }
    
    
    public int[] printArray(int[][] maxtrix)
    {
        int up = 0, right = maxtrix[0].length - 1, down = maxtrix.length - 1, left = 0, index = 0;
        int[] result = new int[maxtrix.length * maxtrix[0].length];
        while (true)
        {
            for (int i = up; i <= right; i++)
            {
                result[index++] = maxtrix[up][i];
            }
            up++;
            if (up > down)
            {
                break;
            }
            
            for (int i = up; i <= down; i++)
            {
                result[index++] = maxtrix[i][right];
            }
            right--;
            if (left > right)
            {
                break;
            }
            
            for (int i = right; i >= left; i--)
            {
                result[index++] = maxtrix[down][i];
            }
            down--;
            if (up > down)
            {
                break;
            }
            
            for (int i = down; i >= up; i--)
            {
                result[index++] = maxtrix[i][left];
            }
            left++;
            if (left > right)
            {
                break;
            }
            
        }
        return result;
    }
    
    
    public ArrayList<Integer> printListFromTailToHead(ListNode.Node listNode)
    {
        ListNode.Node head = null;
        ListNode.Node next = null;
        ArrayList<Integer> resList = new ArrayList<>();
        
        
        /**
         *
         * 这段循环有技巧
         *
         */
        while (listNode != null)
        {
            next = listNode.next;
            listNode.next = head;
            head = listNode;
            listNode = next;
        }
        
        
        while (head != null)
        {
            resList.add(head.val);
            head = head.next;
        }
        
        return resList;
    }
    
}
