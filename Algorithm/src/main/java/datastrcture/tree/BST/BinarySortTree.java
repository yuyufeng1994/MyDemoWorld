package datastrcture.tree.BST;


/**
 * 二叉搜索树、二叉查找树
 * Created by yuyufeng on 2017/6/13.
 */
public class BinarySortTree {
    protected BiTreeNode root;   //根结点

    public BinarySortTree() {  //构造空二叉排序树
        root = null;
    }

    public BinarySortTree(BiTreeNode root) {  //构造根结点为root的二叉排序树
        this.root = root;
    }

    public BiTreeNode getRoot() {
        return root;
    }

    public void setRoot(BiTreeNode root) {
        this.root = root;
    }

    public void inOrderTraverse(BiTreeNode T) { //中根次序遍历以T结点为根的二叉树(因为是中根遍历，所以先左后根再右，所以总是从小到大去遍历值)
        if (T != null) {
            inOrderTraverse(T.getLchild());
            System.out.print(T.getKey() + "  ");
            inOrderTraverse(T.getRchild());
        }
    }

    //查找关键字值为key的结点,若查找成功返回该结点，否则返回null
    public BiTreeNode searchBST(int key) {
        return searchBST(root, key);
    }

    //二叉排序树查找的递归算法
    private BiTreeNode searchBST(BiTreeNode p, int key) {
        if (p != null) {
            if (key == p.getKey()) //查找成功
            {
                return p;
            }
            //     System.out.print(((RecordNode) p.getData()).getKey() + "? ");
            if (key < p.getKey()) {
                return searchBST(p.getLchild(), key);     //在左子树中查找
            } else {
                return searchBST(p.getRchild(), key);    //在右子树中查找
            }
        }
        return null;
    }

    //在二叉排序树中插入关键字为Keyt的结点,若插入成功返回true,否则返回false
    public boolean insertBST(int key) {
        if (root == null) {
            root = new BiTreeNode(key); //建立根结点
            return true;
        }
        return insertBST(root, key);
    }

    //将关键字为keyt的结点插入到以p为根的二叉排序树中的递归算法
    private boolean insertBST(BiTreeNode p, int key) {
        if (key == p.getKey()) {
            return false;             //不插入关键字重复的结点
        }
        if (key < p.getKey()) {
            if (p.getLchild() == null) {        //若p的左子树为空
                p.setLchild(new BiTreeNode(key));  //建立叶子结点作为p的左孩子
                return true;
            } else {                      //若p的左子树非空
                return insertBST(p.getLchild(), key);   //插入到p的左子树中
            }
        } else if (p.getRchild() == null) {    //若p的右子树为空
            p.setRchild(new BiTreeNode(key));    //建立叶子结点作为p的右孩子
            return true;
        } else {                          //若p的右子树非空
            return insertBST(p.getRchild(), key);   //插入到p的右子树中
        }
    }

}
