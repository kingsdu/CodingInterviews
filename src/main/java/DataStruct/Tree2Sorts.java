package DataStruct;

/**
 * https://www.cnblogs.com/pecool/p/8046295.html
 */
public class Tree2Sorts {

    public Integer data;//每一个节点的值
    public static Tree2Sorts root;//根节点(有且仅有一个)
    public Tree2Sorts father;//父节点
    public Tree2Sorts leftSon;//左子节点
    public Tree2Sorts rightSon;//右子节点

    //左树是否为空
    public boolean hasLeftSon(){
        return leftSon!=null;
    }
    //右树是否为空
    public boolean hasRightSon(){
        return rightSon!=null;
    }

    //插入节点
    public void insert(Integer data,Tree2Sorts father){
        /**
         * 思想：先让data和root中的值进行比较，大于0插入右边，小于0插入左边，计划使用递归思想
         */
        //等于root.data
        if(data.compareTo(father.data)==0){
            return;
        }
        //大于root.data
        if(data.compareTo(father.data)>0){
            //父节点没有右节点
            if(!father.hasRightSon()){
                father.rightSon = new Tree2Sorts();//生成一个右节点
                father.rightSon.data = data;//给右节点赋值
                father.rightSon.father = father;//指定右节点的父亲是谁
            }else{
                insert(data,father.rightSon);
            }
        }

        //小于同上
        if(data.compareTo(father.data)<0){
            //父节点没有左节点
            if(!father.hasLeftSon()){
                father.leftSon = new Tree2Sorts();//生成一个右节点
                father.leftSon.data=data;//给右节点赋值
                father.leftSon.father=father;//指定右节点的父亲是谁
            }else{
                insert(data,father.leftSon);
            }
        }
    }

    /**
     * 总体插入操作
     * 1.判断是否有树根，没有的话将数据添加到树根里
     * 2.有树根调用insert的重载方法，判断插入到左son还是右son
     * @param data
     */
    public void insert(Integer data){
        if(root==null){
            root = new Tree2Sorts();
            root.data=data;
            return;
        }else{
            insert(data,root);
        }
    }



    public void outPutTree(Tree2Sorts tree){
        System.out.print(tree.data+" ");
        if(tree.hasLeftSon()){
            outPutTree(tree.leftSon);
        }
        if(tree.hasRightSon()){
            outPutTree(tree.rightSon);
        }
    }


    //找出树中最小的值
    public void getMinValue(Tree2Sorts tree){
        if(tree.hasLeftSon()){
            getMinValue(tree.leftSon);
        }else{
            System.out.println("最小值"+tree.data);
        }
    }


    //找出树中最大的值
    public void getMaxValue(Tree2Sorts tree){
        if(tree.hasRightSon()){
            getMaxValue(tree.rightSon);
        }else{
            System.out.println("最大值"+tree.data);
        }
    }
}
