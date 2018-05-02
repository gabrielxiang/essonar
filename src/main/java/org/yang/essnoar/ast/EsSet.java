package org.yang.essnoar.ast;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class EsSet extends Sequence {

    public EsSet(List<Node> elts, String file, int start, int end) {
        super(NodeType.ESSET, elts, file, start, end);
    }

    @NotNull
    @Override
    public String toString() {
        return "<List:" + start + ":" + elts + ">";
    }

}
