package project;

import java.util.Collection;
import java.util.LinkedList;

public class Node {

    char content;
    boolean marker;
    Collection<Node> children;

    public Node(char c) {
        content = c;
        marker = false;
        children = new LinkedList<Node>();
    }

    public Node subNode(char c) {
        if (children != null) {
            for (Node eachChild : children) {
                if (eachChild.content == c) {
                    return eachChild;
                }
            }
        }
        return null;
    }
}
