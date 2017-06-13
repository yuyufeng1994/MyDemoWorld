package datastrcture.tree.bitree;

import java.util.Scanner;

/**
 * Created by yuyufeng on 2017/6/13.
 */
public class Main {
    public static void main(String[] args) {
        BiTree biTree = new BiTree();
        BiTreeNode nodea = new BiTreeNode("a");
        BiTreeNode nodeb = new BiTreeNode("b");
        BiTreeNode nodec = new BiTreeNode("c");
        BiTreeNode noded = new BiTreeNode("d");
        BiTreeNode nodee = new BiTreeNode("e");
        BiTreeNode nodef = new BiTreeNode("f");
        BiTreeNode nodeg = new BiTreeNode("g");
        BiTreeNode nodeh = new BiTreeNode("h");
        BiTreeNode nodei = new BiTreeNode("i");
        BiTreeNode nodej = new BiTreeNode("j");
        BiTreeNode nodek = new BiTreeNode("k");
        BiTreeNode nodel = new BiTreeNode("l");
        BiTreeNode nodem = new BiTreeNode("m");


        biTree.setRoot(nodea);
        nodea.setLchild(nodeb);
        nodea.setRchild(nodeh);

        nodeb.setLchild(noded);
        nodeb.setRchild(nodee);

        noded.setLchild(nodef);
        noded.setRchild(nodeg);

        nodeh.setLchild(nodei);
        nodeh.setRchild(nodej);

        nodei.setLchild(nodek);
        nodei.setRchild(nodel);

        nodej.setLchild(nodem);

        Scanner sc = new Scanner(System.in);
//        while (true) {
//            System.out.println(" 1--先根遍历    2--中根遍历   3--后根遍历    4--退出 ");
//            System.out.print("请输入选择(1-4):");
        int i = 2;
        switch (i) {
            case 1:
                System.out.print("先根遍历为： ");
                biTree.preRootTraverse(biTree.getRoot());
                System.out.println();
                break;
            case 2:
                System.out.print("中根遍历为： ");
                biTree.inRootTraverse(biTree.getRoot());
                System.out.println();
                break;
            case 3:
                System.out.print("后根遍历为： ");
                biTree.postRootTraverse(biTree.getRoot());
                System.out.println();
                break;
            case 4:
                return;
        }
    }
//    }

}
