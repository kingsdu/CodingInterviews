package DataStruct;

import DataStructBook.BinTreeNode;
import Java_SE.Inherit.Parent;

/**
 *
 */
public class BinTree_Handle {

    private BinTree root;

    public BinTree_Handle(int val) {
        root = new BinTree(val);
        root.leftNode = null;
        root.rightNode = null;
    }


    /**
     * 增
     *
     * @param val
     */
    public void insertNode(int val) {
        BinTree node = new BinTree(val);

        if (root == null) {
            root = node;
            root.leftNode = node;
            root.rightNode = node;
        } else {
            BinTree current = root;
            BinTree parent = null;

            while (true) {
                if (current.val > val) {
                    parent = current;
                    current = current.leftNode;
                    if (current == null) {
                        parent.leftNode = node;
                        break;
                    }
                } else if (current.val < val) {
                    parent = current;
                    current = current.rightNode;
                    if (current == null) {
                        parent.rightNode = node;
                        break;
                    }
                } else {
                    return;
                }
            }
        }
    }


    /**
     * 查找
     *
     * @return
     */
    public BinTree find(int value) {
        BinTree current = new BinTree(value);

        while (true) {
            if (value == current.val) {
                return current;
            } else if (value < current.val) {
                return current.leftNode;
            } else if (value > current.val) {
                return current.rightNode;
            }

            if (current == null) {
                return null;
            }
        }
    }


    /**
     * 获取最大值
     */
    public int getMaxValue() {
        BinTree current = root;
        while (true) {
            if (current.rightNode != null) {
                return current.val;
            }
            current = current.rightNode;
        }
    }


    /**
     * 获得最小值
     *
     * @return
     */
    public int getMinValue() {
        BinTree current = root;
        while (true) {
            if (current.leftNode == null) {
                return current.val;
            }
            current = current.leftNode;
        }
    }


    /**
     *
     * 删除分为三种情况
     * 1 删除的节点为叶子节点：将叶子节点的父节点至空即可
     * 2 删除的是没有右子树或者没有右子树的结点：将父节点的左节点或右节点 = 该节点的左节点或右节点
     * 3 删除的既有左节点，也有右节点
     *
     * @param key
     * @return
     */
    public boolean deleteNode(int key) {
        BinTree current = root;
        BinTree parent = root;
        boolean isLeftChild = true;

        //判断删除元素处于左子树还是右子树
        while (current.val != key) {
            parent = current;
            if (key < current.val) {
                isLeftChild = true;
                current = current.leftNode;
            } else {
                isLeftChild = false;
                current = current.rightNode;
            }

            if (current == null) {
                return false;
            }
        }

        //叶子节点删除
        if (current.leftNode == null &&
                current.rightNode == null) {
            if (current == root) {
                root = null;
            } else if (isLeftChild) {
                parent.leftNode = null;
            } else {
                parent.rightNode = null;
            }
        } else if (current.rightNode == null) {
            if (current == root) {
                root = current.leftNode;
            } else if (isLeftChild) {
                parent.leftNode = current.leftNode;
            } else {
                parent.rightNode = current.rightNode;
            }
        } else if (current.leftNode == null) {
            if (current == root) {
                root = current.leftNode;
            } else if (isLeftChild) {
                parent.leftNode = current.rightNode;
            } else {
                parent.rightNode = current.rightNode;
            }
        } else {
            //即有左节点，也有右节点
            BinTree successor = getSuccessor(current);

            if (current == root) {
                root = successor;
            } else if (isLeftChild) {
                parent.leftNode = successor;
            } else {
                parent.rightNode = successor;
            }

            successor.leftNode = current.leftNode;
        }
        return true;
    }


    /**
     * 获取后继节点
     * 比delNode大的最小一个节点
     * @param delNode
     * @return
     */
    public BinTree getSuccessor(BinTree delNode) {
        BinTree successorParent = delNode;
        BinTree successor = delNode;
        BinTree current = delNode.rightNode;

        while (current != null) {
            successorParent = successor;
            successor = current;
            current = current.leftNode;
        }

        if (successor != delNode.rightNode) {
            successorParent.leftNode = successor.rightNode;
            successor.rightNode = delNode.rightNode;
        }
        return successor;
    }


    /**
     * 中序遍历
     */
    public void inOrderTraverse(BinTree node) {
        if(node == null){
            return;
        }
        inOrderTraverse(node.leftNode);
        node.display();
        inOrderTraverse(node.rightNode);
    }



    /**
     * 先序遍历
     */
    public void preOrderTraverse(BinTree node) {
        if(node == null){
            return;
        }
        node.display();
        inOrderTraverse(node.leftNode);
        inOrderTraverse(node.rightNode);
    }

}
