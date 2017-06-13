package datastrcture.tree.bitree;

import java.util.Scanner;

/**
 * Created by yuyufeng on 2017/6/13.
 */
public class Main {
    public static void main(String[] args) {
        String preStr = "abc##d##e#f##";// 标明空子树的先根遍历序列
        BiTree T = new BiTree(preStr);
        Scanner sc = new Scanner(System.in);
//        while (true) {
//            System.out.println(" 1--先根遍历    2--中根遍历   3--后根遍历    4--退出 ");
//            System.out.print("请输入选择(1-4):");
        int i = 1;
        switch (i) {
            case 1:
                System.out.print("先根遍历为： ");
                T.preRootTraverse(T.getRoot());
                System.out.println();
                break;
            case 2:
                System.out.print("中根遍历为： ");
                T.inRootTraverse(T.getRoot());
                System.out.println();
                break;
            case 3:
                System.out.print("后根遍历为： ");
                T.postRootTraverse(T.getRoot());
                System.out.println();
                break;
            case 4:
                return;
        }
    }
//    }

}
