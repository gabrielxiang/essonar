package org.yang.essnoar;

import org.jetbrains.annotations.Nullable;

/**
 * unsorted utility class
 */
public class $ {

    public static boolean same(@Nullable Object o1, @Nullable Object o2) {
        if (o1 == null) {
            return o2 == null;
        } else {
            return o1.equals(o2);
        }
    }

}
