package datastrcture.tree.bitree;

/**
 * Created by yuyufeng on 2017/6/13.
 */
public class BiTree {
    private BiTreeNode root;// 树的根结点

    public BiTree() {// 构造一棵空树
        this.root = null;
    }

    public BiTree(BiTreeNode root) {// 构造一棵树
        this.root = root;
    }

    // 由标明空子树的先根遍历序列建立一棵二叉树
    private static int index = 0;// 用于记录preStr的索引值

    public BiTree(String preStr) {
        char c = preStr.charAt(index++);// 取出字符串索引为index的字符，且index增1
        if (c != '#') {// 字符不为#
            root = new BiTreeNode(c);// 建立树的根结点
            root.setLchild(new BiTree(preStr).root);// 建立树的左子树
            root.setRchild(new BiTree(preStr).root);// 建立树的右子树
        } else
            root = null;
    }

    // 先根遍历二叉树基本操作的递归算法
    public void preRootTraverse(BiTreeNode T) {
        if (T != null) {
            System.out.print(T.getData()); // 访问根结点
            preRootTraverse(T.getLchild());// 访问左子树
            preRootTraverse(T.getRchild());// 访问右子树
        }
    }

    // 中根遍历二叉树基本操作的递归算法
    public void inRootTraverse(BiTreeNode T) {
        if (T != null) {
            inRootTraverse(T.getLchild());// 访问左子树
            System.out.print(T.getData()); // 访问根结点
            inRootTraverse(T.getRchild());// 访问右子树
        }
    }

    // 后根遍历二叉树基本操作的递归算法
    public void postRootTraverse(BiTreeNode T) {
        if (T != null) {
            postRootTraverse(T.getLchild());// 访问左子树
            postRootTraverse(T.getRchild());// 访问右子树
            System.out.print(T.getData()); // 访问根结点
        }
    }

    public BiTreeNode getRoot() {
        return root;
    }

    public void setRoot(BiTreeNode root) {
        this.root = root;
    }

}
