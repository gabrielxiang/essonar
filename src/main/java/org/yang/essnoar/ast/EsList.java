package org.yang.essnoar.ast;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class EsList extends Sequence {

    public EsList(@NotNull List<Node> elts, String file, int start, int end) {
        super(NodeType.ESLIST, elts, file, start, end);
    }

    @NotNull
    @Override
    public String toString() {
        return "<List:" + start + ":" + elts + ">";
    }

}
