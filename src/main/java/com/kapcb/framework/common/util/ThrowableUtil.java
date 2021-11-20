package com.kapcb.framework.common.util;

import java.io.PrintWriter;
import java.io.StringWriter;

/**
 * <a>Title: ThrowableUtil </a>
 * <a>Author: Kapcb <a>
 * <a>Description: ThrowableUtil <a>
 *
 * @author Kapcb
 * @version 1.0.0
 * @date 2021/11/19 23:05
 */
public class ThrowableUtil {

    public static String getStackTrace(Throwable throwable) {
        StringWriter stringWriter = new StringWriter();
        try (PrintWriter printWriter = new PrintWriter(stringWriter)) {
            throwable.printStackTrace(printWriter);
            return stringWriter.toString();
        }
    }

}
