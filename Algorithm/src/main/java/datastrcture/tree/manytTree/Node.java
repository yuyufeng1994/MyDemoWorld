package datastrcture.tree.manytTree;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yuyufeng on 2017/6/13.
 */
public class Node {
    private String data;
    private List<Node> childs = new ArrayList<>();

    public Node(String data) {
        this.data = data;
    }

    public void addChildNode(Node child) {
        childs.add(child);
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public List<Node> getChilds() {
        return childs;
    }

    public void setChilds(List<Node> childs) {
        this.childs = childs;
    }

    @Override
    public String toString() {
        return "Node{" +
                "data='" + data + '\'' +
                '}';
    }
}
