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
        Integer[] array = new Integer[]{1, 2, 3, null, null, 4, 5};
        TreeNode treeNode = deserializeTreeNode(array);
        ArrayList<Integer> list = serializeTreeNode(treeNode);
        Integer[] integers = list.toArray(new Integer[list.size()]);
        Arrays.stream(integers).forEach(e -> System.out.print(e + " "));
        treeNode = deserializeTreeNode(integers);
        printTreeNode(treeNode);
    }
    
    //反序列化二叉树
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
}
