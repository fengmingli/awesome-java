package org.jvm;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

/**
 * @author lifengming
 * @date 2021.10.30
 */
public class HackSystem {
    public static final InputStream in = System.in;

    private static ByteArrayOutputStream buffer = new ByteArrayOutputStream();

    public static final PrintStream out = new PrintStream(buffer);

    public static final PrintStream err = out;

    public static String getBufferString() {
        return buffer.toString();
    }

    public static void clearBuffer() {
        buffer.reset();
    }

    public static void setSecurityManager(final java.lang.SecurityManager s) {
        System.setSecurityManager(s);
    }

    public static java.lang.SecurityManager getSecurityManager() {
        return System.getSecurityManager();
    }

    public static long currentTimeMillis() {
        return System.currentTimeMillis();
    }

    public static void arraycopy(Object str, int srcPos, Object dest, int destPost, int length) {
        System.arraycopy(str, srcPos, dest, destPost, length);
    }

    public static int identityHashCode(Object x) {
        return System.identityHashCode(x);
    }

}
