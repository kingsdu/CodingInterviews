package DoExercise.HSP_ZCY.A008_Hash;

public class Emp_HSP
{
    public int id;
    public String name;
    public Emp_HSP next; //next 默认为 null
    
    public Emp_HSP(int id, String name)
    {
        super();
        this.id = id;
        this.name = name;
    }
}
