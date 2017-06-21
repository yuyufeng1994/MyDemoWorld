package datastrcture.tree.BST;

import java.util.Hashtable;
import java.util.Map;

/**
 * Created by yuyufeng on 2017/6/13.
 */
public class Main {
    public static void main(String[] args) {
        BinarySortTree bst = new BinarySortTree();
        bst.insertBST(8);
        bst.insertBST(3);
        bst.insertBST(10);
        bst.insertBST(1);
        bst.insertBST(5);
        bst.insertBST(4);
        bst.insertBST(2);
        bst.insertBST(6);
        bst.insertBST(7);
        bst.insertBST(9);
        bst.inOrderTraverse(bst.getRoot());
        Map<String,String> map = new Hashtable<>();

    }
}
