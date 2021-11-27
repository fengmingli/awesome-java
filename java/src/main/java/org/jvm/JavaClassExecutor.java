package org.jvm;

import java.lang.reflect.Method;

/**
 * @author lifengming
 * @date 2021.10.30
 */
public class JavaClassExecutor {

    public static String execute(byte[] classByte) {
        HackSystem.clearBuffer();
        ClassModifier cm = new ClassModifier(classByte);

        byte[] modifyBytes = cm.modifyUtf8Constant("java/lang/System", "org/jvm/HackSystem");

        HotSwapClassLoader loader = new HotSwapClassLoader();
        Class<?> clazz = loader.loadByte(modifyBytes);
        try {
            Method method = clazz.getMethod("main", new Class[]{String[].class});
            method.invoke(null, new String[]{null});
        } catch (Throwable e) {
            e.printStackTrace(HackSystem.out);
        }
        return HackSystem.getBufferString();
    }
}
