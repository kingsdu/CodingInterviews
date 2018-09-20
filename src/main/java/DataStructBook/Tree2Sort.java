package DataStructBook;

/**
 * 二叉树：左子节点比自己小，右子节点比自己大。
 *
 * 算法思想
 *
 * 先将待排序序列逐个添加到二叉搜索树中去，
 * 再通过中序遍历二叉搜索树就可以将数据从小到大取出来
 *
 * https://blog.csdn.net/skylinesky/article/details/6611442
 * https://blog.csdn.net/s_842499467/article/details/70195610
 * https://blog.csdn.net/yixianfeng41/article/details/52802855
 */
public class Tree2Sort {
    public Tree2Node root;

    public Tree2Sort() {
        root = null;
    }

    public Tree2Node getRoot() {
        return root;
    }


    public static void main(String[] args) {
        int []source = new int[]{3,6,2,4,9,5};
        Tree2Sort tree2Sort = new Tree2Sort();
        tree2Sort.insertSort(source);
        tree2Sort.inOrder(tree2Sort.getRoot());
    }

    public void insertSort(int[] source) {
        for (int i = 0; i < source.length; i++) {
            int value = source[i];
            Tree2Node node = new Tree2Node(value);
            if (root == null) {
                root = node;
            } else {
                Tree2Node current = root;
                Tree2Node parent;
                while (true) {
                    parent = current;
                    if (value < current.value) {
                        current = current.leftChild;
                        if (current == null) {
                            parent.leftChild = node;
                            break;
                        }
                    } else {
                        current = current.rightChild;
                        if (current == null) {
                            parent.rightChild = node;
                            break;
                        }
                    }
                }
            }
        }
    }


       //中序遍历
    public void inOrder(Tree2Node current) {
        if (current != null) {
            inOrder(current.leftChild);
            System.out.print(current.value + " ");
            inOrder(current.rightChild);
        }
    }

}
