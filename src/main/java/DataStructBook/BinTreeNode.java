package DataStructBook;

/**
 * 二叉树节点
 */
public class BinTreeNode {
    public int  value;
    public BinTreeNode leftChild;
    public BinTreeNode rightChild;

    public BinTreeNode(int value) {
        this.value = value;
    }

    public void display() {
        System.out.print(this.value + "\t");
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
