package org.yang.essnoar.ast;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.yang.essnoar.$;

import java.util.Collection;

/**
 * A Node is a junction in the program.
 * Since there is no way to put different things in the same segment of the same file,
 * a node is uniquely identified by a file, a start and end point.
 */
public abstract class Node implements java.io.Serializable, Comparable<Object> {

    public NodeType nodeType;
    public String file;
    public int start;
    public int end;

    public String name;
    public Node parent = null;

    public Node() {
    }

    public Node(NodeType nodeType, String file, int start, int end) {
        this.nodeType = nodeType;
        this.file = file;
        this.start = start;
        this.end = end;
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }

    @NotNull
    public Node getAstRoot() {
        if (parent == null) {
            return this;
        }
        return parent.getAstRoot();
    }

    public int length() {
        return end - start;
    }

    public void addChildren(@Nullable Node... nodes) {
        if (nodes != null) {
            for (Node n : nodes) {
                if (n != null) {
                    n.setParent(this);
                }
            }
        }
    }

    public void addChildren(@Nullable Collection<? extends Node> nodes) {
        if (nodes != null) {
            for (Node n : nodes) {
                if (n != null) {
                    n.setParent(this);
                }
            }
        }
    }

    // nodes are equal if they are from the same file and same starting point
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Node)) {
            return false;
        } else {
            Node node = (Node) obj;
            String file = this.file;
            return (start == node.start &&
                    end == node.end &&
                    $.same(file, node.file));
        }
    }

    @Override
    public int hashCode() {
        return (file + ":" + start + ":" + end).hashCode();
    }

    @Override
    public int compareTo(@NotNull Object o) {
        if (o instanceof Node) {
            return start - ((Node) o).start;
        } else {
            return -1;
        }
    }

    public String toDisplay() {
        return "";
    }

    @NotNull
    @Override
    public String toString() {
        return "(node:" + file + ":" + name + ":" + start + ")";
    }

}
