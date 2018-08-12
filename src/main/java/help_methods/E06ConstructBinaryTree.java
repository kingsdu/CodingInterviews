package help_methods;


public class E06ConstructBinaryTree{

    /**
     *
     * @param preOrder 前序遍历数组
     * @param inOrder 中序遍历数组
     * @param length 数组长度
     * @return 根结点
     */
    public static BinaryTreeNode Construct(int[] preOrder, int[] inOrder,int length){
        if (preOrder == null || inOrder == null || length <= 0) {
            return null;
        }
        try {
            return ConstructCore(preOrder, 0, preOrder.length - 1, inOrder, 0,inOrder.length - 1);
        } catch (InvalidPutException e) {
            e.printStackTrace();
            return null;
        }
    }


    /**
     *
     *
     *
     * @param preOrder
     * @param startPreIndex
     *            前序序列开始位置
     * @param endPreIndex
     *            前序序列结束位置
     * @param inOrder
     * @param startInIndex
     *            中序序列开始位置
     * @param endInIndex
     *            中序序列结束位置
     * @return 根结点
     * @throws InvalidPutException
     */
    public static BinaryTreeNode ConstructCore(int[] preOrder,int startPreIndex, int endPreIndex,
                                               int[] inOrder,int startInIndex, int endInIndex) throws InvalidPutException {
        int rootValue = preOrder[startPreIndex];//先序遍历参与比较的值
        System.out.println("rootValue = " + rootValue);
        BinaryTreeNode root = new BinaryTreeNode(rootValue);
        // 只有一个元素
        if (startPreIndex == endPreIndex) {
            if (startInIndex == endInIndex
                    && preOrder[startPreIndex] == inOrder[startInIndex]) {
                System.out.println("only one element");
                return root;
            } else {
                throw new InvalidPutException();
            }
        }
        // 在中序遍历中找到根结点的索引
        //rootInIndex 记录了中序遍历和先序遍历相等的值的下标
        int rootInIndex = startInIndex;
        while (rootInIndex <= endInIndex && inOrder[rootInIndex] != rootValue) {
            ++rootInIndex;
        }
        /* 找到了中序遍历和先序遍历相等的值，该值的左边是左子树，右边是右子树，接下来就是通过下标取值 */

        //根节点的索引一定不等于尾部节点索引（相等说明结束） 且 中序遍历的值一定等于先序遍历的值（不相等说明有错误）
        if (rootInIndex == endInIndex && inOrder[rootInIndex] != rootValue) {
            throw new InvalidPutException();
        }

        int leftLength = rootInIndex - startInIndex;//中序遍历中的左子树的下标范围
        int leftPreOrderEndIndex = startPreIndex + leftLength;//先序遍历的结束下标值（中序遍历的范围 + 先序遍历的起点下标值）
        if (leftLength > 0) {
            // 构建左子树
            root.leftNode = ConstructCore(preOrder, startPreIndex + 1,
                    leftPreOrderEndIndex, inOrder, startInIndex,
                    rootInIndex - 1);
        }

        if (leftLength < endPreIndex - startPreIndex) {
            // 右子树有元素,构建右子树
            root.rightNode = ConstructCore(preOrder, leftPreOrderEndIndex + 1,
                    endPreIndex, inOrder, rootInIndex + 1, endInIndex);
        }
        return root;
    }



    static class InvalidPutException extends Exception {
        private static final long serialVersionUID = 1L;
    }



    public static void printPreOrder(BinaryTreeNode root) {
        if (root == null) {
            return;
        } else {
            System.out.print(root.value + " ");
        }
        if (root.leftNode != null) {
            printPreOrder(root.leftNode);
        }
        if (root.rightNode != null) {
            printPreOrder(root.rightNode);
        }
    }

}
