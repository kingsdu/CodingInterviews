package DataStruct.MyOverride.Tree;

public class FormNode
{
    private String data;
    private FormNode left;
    private FormNode right;
    
    public FormNode(String data){
        this.data = data;
    }
    
    public FormNode(String data,FormNode left,FormNode right){
        this.data = data;
        this.left = left;
        this.right = right;
    }
    
    public String getData()
    {
        return data;
    }
    
    public void setData(String data)
    {
        this.data = data;
    }
    
    public FormNode getLeft()
    {
        return left;
    }
    
    public void setLeft(FormNode left)
    {
        this.left = left;
    }
    
    public FormNode getRight()
    {
        return right;
    }
    
    public void setRight(FormNode right)
    {
        this.right = right;
    }
}
