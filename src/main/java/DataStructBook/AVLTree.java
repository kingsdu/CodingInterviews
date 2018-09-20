package DataStructBook;

public class AVLTree <T extends Comparable> implements Tree<T>{


    /** The tree root. */
    public AVLNode<T> root;


    @Override
    public boolean isEmpty() {
        return root == null;
    }

    @Override
    public int size() {
        return size(root);
    }

    public int size(AVLNode<T> subtree){
        if(subtree==null){
            return 0;
        }else {
            return size(subtree.left) + 1 + size(subtree.right);
        }
    }


    @Override
    public int height() {
        return height(root);
    }

    /**
     * @param p
     * @return
     */
    public int height(AVLNode<T> p){
        return p == null ? -1 : p.height;
    }


    @Override
    public String preOrder() {
        return null;
    }

    @Override
    public String inOrder() {
        return null;
    }

    @Override
    public String postOrder() {
        return null;
    }

    @Override
    public String levelOrder() {
        return null;
    }

    @Override
    public void insert(T data) {

        if (data==null){
            throw new RuntimeException("data can\'t not be null ");
        }
        this.root=insert(data,root);
    }

    private AVLNode<T> insert(T data , AVLNode<T> p){
        //说明已没有孩子结点,可以创建新结点插入了.
        if(p==null){
            p=new AVLNode<T>(data);
        }

        int result = data.compareTo(p.data);

        if(result<0){//向左子树寻找插入位置
            p.left=insert(data,p.left);

            //插入后计算子树的高度,等于2则需要重新恢复平衡,由于是左边插入,左子树的高度肯定大于等于右子树的高度
            if(height(p.left)-height(p.right)==2){
                //判断data是插入点的左孩子还是右孩子
                if(data.compareTo(p.left.data)<0){
                    //进行LL旋转
                    p=singleRotateLeft(p);
                }else {
                    //进行左右旋转
                    p=doubleRotateWithLeft(p);
                }
            }
        }else if (result>0){//向右子树寻找插入位置
            p.right=insert(data,p.right);
            if(height(p.right)-height(p.left)==2){
                if (data.compareTo(p.right.data)<0){
                    //进行右左旋转
                    p=doubleRotateWithRight(p);
                }else {
                    p=singleRotateRight(p);
                }
            }
        }
        else
            ;//if exist do nothing
        //重新计算各个结点的高度
        p.height = Math.max( height( p.left ), height( p.right ) ) + 1;

        return p;//返回根结点
    }


    /**
     * 左左单旋转(LL旋转) w变为x的根结点, x变为w的右子树
     * @param x
     * @return
     */
    private AVLNode<T> singleRotateLeft(AVLNode<T> x){
        //把w结点旋转为根结点
        AVLNode<T> w =  x.left;
        //同时w的右子树变为x的左子树
        x.left=w.right;
        //x变为w的右子树
        w.right=x;
        //重新计算x/w的高度
        x.height=Math.max(height(x.left),height(x.right))+1;
        w.height=Math.max(height(w.left),x.height)+1;
        return w;//返回新的根结点
    }

    /**
     * 右右单旋转(RR旋转) x变为w的根结点, w变为x的左子树
     * @return
     */
    private AVLNode<T> singleRotateRight(AVLNode<T> w){

        AVLNode<T> x=w.right;

        w.right=x.left;
        x.left=w;

        //重新计算x/w的高度
        x.height=Math.max(height(x.left),w.height)+1;
        w.height=Math.max(height(w.left),height(w.right))+1;

        //返回新的根结点
        return x;
    }

    /**
     * 左右旋转(LR旋转) x(根) w y 结点 把y变成根结点
     * @return
     */
    private AVLNode<T> doubleRotateWithLeft(AVLNode<T> x){
        //w先进行RR旋转
        x.left=singleRotateRight(x.left);
        //再进行x的LL旋转
        return singleRotateLeft(x);
    }

    /**
     * 右左旋转(RL旋转)
     * @param w
     * @return
     */
    private AVLNode<T> doubleRotateWithRight(AVLNode<T> w){
        //先进行LL旋转
        w.right=singleRotateLeft(w.right);
        //再进行RR旋转
        return singleRotateRight(w);
    }


    @Override
    public void remove(T data) {

    }

    @Override
    public T findMin() {
        return null;
    }

    @Override
    public T findMax() {
        return null;
    }

    @Override
    public boolean contains(T data) throws Exception {
        return false;
    }

    @Override
    public void clear() {

    }


    private void printTree( AVLNode<T> t )
    {
        if( t != null )
        {
            printTree( t.left );
            System.out.println( t.data );
            printTree( t.right );
        }
    }


    public static void main(String[] args) {
        AVLTree<Integer> avlTree=new AVLTree<Integer>();

        for (int i = 1; i <18 ; i++) {
            avlTree.insert(i);
        }

        avlTree.printTree(avlTree.root);

        //删除11,8以触发旋转平衡操作
        avlTree.remove(11);
        avlTree.remove(8);

        System.out.println("================");

        avlTree.printTree(avlTree.root);
    }
}
