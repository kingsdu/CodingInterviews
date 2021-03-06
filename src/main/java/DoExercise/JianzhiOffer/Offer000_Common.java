package DoExercise.JianzhiOffer;

import java.util.*;

/**
 * @Author: Du
 * @Date: 2021/6/17 9:18
 */
public class Offer000_Common
{
    
    public static void main(String[] args)
    {
    }
    
    public static void randomTM(int N)
    {
        int TM1 = 0;
        int TM2 = 0;
        int TM3 = 0;
        do
        {
            TM1 = (int) (Math.random() * N);
            TM2 = (int) (Math.random() * N);
            TM3 = (int) (Math.random() * N);
        } while (TM1 == TM2 || TM2 == TM3 || TM1 == TM3);
        System.out.println("今天要刷的三道题:" + TM1 + ";" + TM2 + ";" + TM3);
    }
    
    /**
     * 反序列化二叉树
     *
     * @param array
     * @return
     */
    public static TreeNode deserializeTreeNode(Integer[] array)
    {
        int size = array.length;
        TreeNode[] res = new TreeNode[size];
        //初始化节点
        TreeNode root = new TreeNode(array[0]);
        //首结点是null
        if (root == null) return null;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int i = 1;
        //建立联系
        while (i < size && !queue.isEmpty())
        {
            TreeNode curNode = queue.poll();
            if (!(array[i] == null))
            {
                curNode.left = new TreeNode(array[i]);
                queue.offer(curNode.left);
            }
            i++;
            if (!(array[i] == null))
            {
                curNode.right = new TreeNode(array[i]);
                queue.offer(curNode.right);
            }
            i++;
        }
        return root;
    }
    
    //序列化二叉树
    public static ArrayList<Integer> serializeTreeNode(TreeNode root)
    {
        if (root == null)
        {
            return null;
        }
        ArrayList<Integer> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty())
        {
            TreeNode node = queue.poll();
            if (node != null)//这种if可以防止 node 报空指针异常的情况
            {
                res.add(node.val);
                queue.add(node.left);
                queue.add(node.right);
            } else
            {
                res.add(null);
            }
        }
        return res;
    }
    
    
    public static String serialize_str(TreeNode root)
    {
        if (root == null) return null;
        StringBuilder res = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty())
        {
            TreeNode node = queue.poll();
            if (node != null)
            {
                res.append(node.val).append(",");
                queue.add(node.left);
                queue.add(node.right);
            } else
            {
                res.append("null,");
            }
        }
        res.deleteCharAt(res.length() - 1);
        return res.toString();
    }
    
    public static TreeNode deserialize_str(String data)
    {
        if (data == null || data == "") return null;
        String[] vals = data.split(",");
        TreeNode root = new TreeNode(Integer.parseInt(vals[0]));
        if (root == null)
        {
            return null;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int i = 1;
        while (!queue.isEmpty())
        {
            TreeNode node = queue.poll();
            if (vals[i] == null)
            {
                node.left = new TreeNode(Integer.parseInt(vals[i]));
                queue.add(node.left);
            }
            i++;
            if (vals[i] == null)
            {
                node.right = new TreeNode(Integer.parseInt(vals[i]));
                queue.add(node.right);
            }
            i++;
        }
        return root;
    }
    
    //树结点信息
    public static class TreeNode
    {
        public int val;
        public TreeNode left;
        public TreeNode right;
        
        public TreeNode(int val)
        {
            this.val = val;
        }
    }
    
    
    public static class TreeLinkNode
    {
        public int val;
        public TreeLinkNode left = null;
        public TreeLinkNode right = null;
        public TreeLinkNode next = null;
        
        public TreeLinkNode(int val)
        {
            this.val = val;
        }
    }
    
    //单链表结点信息
    public static class ListNode
    {
        public int val;
        public ListNode next;
        
        public ListNode(int x)
        {
            val = x;
        }
    }
    
    /**
     * 将int[]数组 转化为 ListNode
     *
     * @param arr
     * @return
     */
    public static ListNode deserialize_ListNode(int[] arr)
    {
        if (arr.length == 0 || arr == null) return null;
        ListNode head = new ListNode(arr[0]);
        ListNode cur = head;
        for (int i = 1; i < arr.length; i++)
        {
            cur.next = new ListNode(arr[i]);
            cur = cur.next;
        }
        return head;
    }
    
    //双端链表
    public static class DoubleListNode
    {
        public int val;
        public DoubleListNode next;
        public DoubleListNode pre;
        
        public DoubleListNode(int x)
        {
            val = x;
        }
    }
    
    
    public static void printTreeNode(TreeNode node)
    {
        if (node == null)
        {
            return;
        }
        System.out.print(node.val + " ");
        printTreeNode(node.left);
        printTreeNode(node.right);
    }
    
    public static List<Integer> Copy(List<Integer> path)
    {
        List<Integer> ans = new ArrayList<>();
        for (Integer num : path)
        {
            ans.add(num);
        }
        return ans;
    }
    
    public static void printListNode(ListNode head)
    {
        while (head != null)
        {
            System.out.print(head.val + " ");
            head = head.next;
        }
    }
    
    // for test
    public static void printArray(int[] arr)
    {
        if (arr == null)
        {
            return;
        }
        for (int i = 0; i < arr.length; i++)
        {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
    
    // for test
    public static int[] generateRandomArray(int maxSize, int maxValue)
    {
        int[] arr = new int[(int) ((maxSize + 1) * Math.random())];
        for (int i = 0; i < arr.length; i++)
        {
            arr[i] = (int) ((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random());
        }
        return arr;
    }
    
    // for test
    public static int[] copyArray(int[] arr)
    {
        if (arr == null)
        {
            return null;
        }
        int[] res = new int[arr.length];
        for (int i = 0; i < arr.length; i++)
        {
            res[i] = arr[i];
        }
        return res;
    }
    
    // for test
    public static boolean isEqual(int[] arr1, int[] arr2)
    {
        if ((arr1 == null && arr2 != null) || (arr1 != null && arr2 == null))
        {
            return false;
        }
        if (arr1 == null && arr2 == null)
        {
            return true;
        }
        if (arr1.length != arr2.length)
        {
            return false;
        }
        for (int i = 0; i < arr1.length; i++)
        {
            if (arr1[i] != arr2[i])
            {
                return false;
            }
        }
        return true;
    }
    
    public static void printfBinaryNum(int num)
    {
        for (int i = 31; i >= 0; i--)
        {
            System.out.print((num & (1 << i)) == 0 ? "0" : "1");
        }
        System.out.println();
    }
    
    public static void swap(int[] arr, int i, int j)
    {
        if (i == j) return;
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }

}
