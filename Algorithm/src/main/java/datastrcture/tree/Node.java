package datastrcture.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yuyufeng on 2017/6/13.
 */
public class Node {
    private String data;
    private Node parent;

    public Node(String data, Node parent) {
        this.data = data;
        this.parent = parent;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Node getParent() {
        return parent;
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }

    @Override
    public String toString() {
        return "Node{" +
                "data='" + data + '\'' +
//                ", parent=" + parent +
                '}';
    }
}
