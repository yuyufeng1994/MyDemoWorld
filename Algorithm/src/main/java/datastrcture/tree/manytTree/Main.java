package datastrcture.tree.manytTree;

import java.util.TreeSet;

/**
 * Created by yuyufeng on 2017/6/13.
 */
public class Main {
    public static void main(String[] args) {
        Node root = new Node("root");

        Node node1a = new Node("node1a");
        Node node1b = new Node("node1b");
        Node node1c = new Node("node1c");
        Node node1d = new Node("node1d");

        Node node2a = new Node("node2a");

        Node node3a = new Node("node3a");
        Node node3b = new Node("node3b");

        root.addChildNode(node1a);
        root.addChildNode(node1b);
        root.addChildNode(node1c);
        root.addChildNode(node1d);

        node1b.addChildNode(node2a);
        node2a.addChildNode(node3a);
        node2a.addChildNode(node3b);

        list(root);

    }

    public static void list(Node node){
        System.out.println(node.getData());
        for (int i = 0; i < node.getChilds().size(); i++) {
            if (node.getChilds().get(i).getChilds().size() > 0) {
                list(node.getChilds().get(i));
            }else{
                System.out.println(node.getChilds().get(i).getData());
            }
        }
    }
}
