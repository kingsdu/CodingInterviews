package JavaSE.BLS.LanguageFeatures.Operator;

/**
 *
 * count = count++; 中count的值不会变
 *
 */
public class Jiajia
{
    public static void main(String[] args)
    {
        int count = 0, num = 0;
        for (int i = 0; i <= 100; i++)
        {
            num = num + i;
            count = count++;//temp = count;count = count+1;count = temp; 所以count始终是0
        }
        System.out.println(num * count);
    }
}
