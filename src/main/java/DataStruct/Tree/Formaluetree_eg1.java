package DataStruct.Tree;

import java.util.ArrayList;
/**
 * 学习别人的算法：
 * 思路是：按算式从左到右的顺序将数值和运算符依次加入到树中，然后按照中序遍历的顺序输出。
 * 可以完善的地方：
 * （1）没考虑算式的优先顺序，只是按照从左到右的顺序添加，这样无法计算算式的值。
 * （2）通过这样的方式生成的树只会是上面的结构，这样并不是二叉树实现表达式的真实意思。
 *
 */
public class Formaluetree_eg1
{
    private String s="";
    private FormNode root;     //根节点
    
    
    public void creatTree(String str){
        //声明一个数组列表，存放的操作符，加减乘除
        ArrayList<String> operList = new ArrayList<>();
        //声明一个数组列表，存放节点的数据
        ArrayList<FormNode> numList = new ArrayList<>();
        //第一，辨析出操作符与数据，存放在相应的列表中
        for(int i=0;i<str.length();i++){
            char ch = str.charAt(i);          //取出字符串的各个字符
            if(ch>='0'&&ch<='9'){
                s+=ch;
            }else{
                numList.add(new FormNode(s));
                s="";
                operList.add(ch+"");
            }
            
        }
        //把最后的数字加入到数字节点中
        numList.add(new FormNode(s));
        
        while(operList.size()>0){    //第三步，重复第二步，直到操作符取完为止
            //第二，取出前两个数字和一个操作符，组成一个新的数字节点
            FormNode left = numList.remove(0);
            FormNode right = numList.remove(0);
            String oper = operList.remove(0);
    
            FormNode node = new FormNode(oper,left,right);
            numList.add(0,node);       //关键操作：将新生的节点作为第一个节点，同时以前index=0的节点变为index=1
            
        }
        //第四步，让根节点等于最后一个节点
        root = numList.get(0);
        
    }
    
    
    public void output(){
        output(root);
    }
    
    /**
     *
     * 中序遍历输出
     *
     * @param root
     */
    public void output(FormNode root){
        if(root.getLeft() != null){
            output(root.getLeft());
        }
        System.out.println(root.getData());
        if(root.getRight() != null){
            output(root.getRight());
        }
    }
    
    
    public static void main(String[] args)
    {
        Formaluetree_eg1 formaluetree = new Formaluetree_eg1();
        formaluetree.creatTree("45+23*56/2-5");
        formaluetree.output();
    }
    
}
