package datastrcture.tree.BST;

/**
 * Created by yuyufeng on 2017/6/13.
 */
public class BiTreeNode {
    private int key;// 结点的关键字
    private BiTreeNode lchild, rchild; // 左右孩子

    public BiTreeNode(int key) {// 构造一棵左右孩子为空的结点
        this(key, null, null);
    }

    public BiTreeNode(int key, BiTreeNode lchild, BiTreeNode rchild) {// 构造一棵数据元素和左右孩子都不为空的结点
        this.key = key;
        this.lchild = lchild;
        this.rchild = rchild;
    }

    public int getKey() {
        return key;
    }

    public BiTreeNode getLchild() {
        return lchild;
    }

    public BiTreeNode getRchild() {
        return rchild;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public void setLchild(BiTreeNode lchild) {
        this.lchild = lchild;
    }

    public void setRchild(BiTreeNode rchild) {
        this.rchild = rchild;
    }

}
