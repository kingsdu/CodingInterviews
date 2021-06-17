package DoExercise.JianzhiOffer;

public class TestDay
{
    public static void main(String[] args)
    {
    }
    
    

    private static void t02()
    {
        String[] vals = {null, null};
        if (null == vals[0])
        {
            System.out.println(true);
        }
    }
    
    private static void t01()
    {
        Integer a = null;
        Integer b = 1;
        if (null instanceof Integer)
        {
            System.out.println(true);
        }
    }
    
    
    public static class TreeNode
    {
        int val;
        TreeNode left;
        TreeNode right;
        
        TreeNode(int x)
        {
            val = x;
        }
    }
}
