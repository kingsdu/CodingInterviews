package DoExercise.JianzhiOffer;

/**
 * 牛客链接
 * https://www.nowcoder.com/practice/72a5a919508a4251859fb2cfb987a0e6?tpId=13&&tqId=11163&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
 *
 */
public class Offer010_矩形覆盖
{
    
    public static void main(String[] args)
    {
        System.out.println(rectCoverMethod(4));
    }
    
 
    
    public static int rectCoverMethod(int target)
    {
        if (target < 1)
        {
            return 0;
        }
        
        if (target <= 2)
        {
            return target;
        } else
        {
            return rectCoverMethod(target - 1) + rectCoverMethod(target - 2);
        }
    }
    
    
}
