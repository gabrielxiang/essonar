package org.yang.essnoar.ast;

import org.jetbrains.annotations.NotNull;

public class EsFloat extends Node {

    public double value;

    public EsFloat(String s, String file, int start, int end) {
        super(NodeType.ESFLOAT, file, start, end);
        s = s.replaceAll("_", "");
        if (s.equals("inf")) {
            this.value = Double.POSITIVE_INFINITY;
        } else if (s.equals("-inf")) {
            this.value = Double.NEGATIVE_INFINITY;
        } else {
            this.value = Double.parseDouble(s);
        }
    }

    @NotNull
    @Override
    public String toString() {
        return "(float:" + value + ")";
    }

}
