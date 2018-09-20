package DataStructBook;

/**
 * 二叉树节点
 */
public class BinTreeNode {
    int  value;
    BinTreeNode leftChild;
    BinTreeNode rightChild;

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
