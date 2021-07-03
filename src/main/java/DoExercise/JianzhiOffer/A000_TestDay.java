package DoExercise.JianzhiOffer;

//0620:要刷的三道题:12;20;9
//0621:要刷的三道题:13;11;22
//0622:要刷的三道题:7;13;6
//0624:要刷的三道题:6;57;1
//0628:要刷的三道题:7;8;3
//0703:要刷的三道题:17;10;29
public class A000_TestDay
{
    
    public static void main(String[] args)
    {
        Offer000_Common.randomTM(35);
    }
    
    public boolean isSubStructure(Offer000_Common.TreeNode a, Offer000_Common.TreeNode b)
    {
        return a != null && b != null && (recur(a, b) || isSubStructure(a.left, b) || isSubStructure(a.right, b));
    }
    
    boolean recur(Offer000_Common.TreeNode a, Offer000_Common.TreeNode b)
    {
        if (b == null) return true;
        if (a == null || a.val != b.val) return false;
        return recur(a.left, b.left) && recur(a.right, b.right);
    }
    
}
