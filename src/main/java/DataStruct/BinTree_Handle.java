package DataStruct;

/**
 *
 */
public class BinTree_Handle {

    private BinTree root;

    public BinTree_Handle(int val){
        root = new BinTree(val);
        root.leftNode = null;
        root.rightNode = null;
    }


    /**
     * 增
     * @param val
     */
    public void insertNode(int val){
        BinTree binTree = new BinTree(val);

        if(root == null){
            root = binTree;
            root.leftNode = null;
            root.rightNode = null;
        }else {
            BinTree parent = null;
            BinTree current = root;
            while (true){
                if(current.val > val){
                    parent = current;
                    current = current.leftNode;
                    if(current == null){
                        parent.leftNode = binTree;
                        break;
                    }
                }else if(current.val < val){
                    parent = current;
                    current = current.rightNode;
                    if(current == null){
                        parent.rightNode = binTree;
                        break;
                    }
                }else {
                    return;
                }
            }
        }
    }



}
