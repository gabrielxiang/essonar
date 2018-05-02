package org.yang.essnoar;

import org.jetbrains.annotations.Nullable;

import java.io.File;

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

    public static void die(String msg) {
        die(msg, null);
    }


    public static void die(String msg, Exception e) {
        System.err.println(msg);

        if (e != null) {
            System.err.println("Exception: " + e + "\n");
        }

        Thread.dumpStack();
        System.exit(2);
    }

    /**
     * Given an absolute {@code path} to a file (not a directory),
     * returns the module name for the file.  If the file is an __init__.py,
     * returns the last component of the file's parent directory, else
     * returns the filename without path or extension.
     */
    public static String moduleName(String path) {
        // todo
        return null;
    }

}
