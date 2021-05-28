package JavaSE.BLS.A001_InterView.Enum;

public class EnumOne
{
    public static void main(String[] args)
    {
        System.out.println(AccountType.FIXED);
    }
}

enum AccountType
{
    SAVING, FIXED, CURRENT;
    
    private AccountType()
    {
        System.out.println("It is a account type");
    }
}