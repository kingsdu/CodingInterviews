package JavaSE.BLS.Generic.Inherit;

public class Manager extends Employee
{
    /**
     * @param n the employee's name
     * @param s the salary
     * @param year the hire year
     * @param month the hire month
     * @param day the hire day
     */
    public Manager(String n, double s, int year, int month, int day)
    {
        super(n, s, year, month, day);
        bonus = 0;
    }
    
    public double getSalary()
    {
        double baseSalary = super.getSalary();
        return baseSalary + bonus;
    }
    
    public void setBonus(double b)
    {
        bonus = b;
    }
    
    public double getBonus()
    {
        return bonus;
    }
    
    private double bonus;
}
