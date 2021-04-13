package HSP.Day03;


/**
 *
 * 双向队列
 *
 */
public class DoubleNode
{
    
    public Integer val;
    public DoubleNode pre;
    public DoubleNode next;
    
    public DoubleNode(){
        this.val = null;
        this.pre = null;
        this.next = null;
    }
    
    public DoubleNode(DoubleNode pre,int val,DoubleNode next){
        this.pre = pre;
        this.val = val;
        this.next = next;
    }
    
    
}
