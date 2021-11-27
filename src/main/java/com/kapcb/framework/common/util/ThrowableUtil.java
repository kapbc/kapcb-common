package com.kapcb.framework.common.util;

import com.kapcb.framework.common.constants.enums.StringPool;
import lombok.extern.slf4j.Slf4j;

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
@Slf4j
public class ThrowableUtil {

    public static String getStackTrace(Throwable throwable) {
        String stackTrace = StringPool.EMPTY_STRING.value();
        try (StringWriter stringWriter = new StringWriter(); PrintWriter printWriter = new PrintWriter(stringWriter, true)) {
            throwable.printStackTrace(printWriter);
            stackTrace = stringWriter.toString();
        } catch (Exception e) {
            log.error("get stack trace error, error message is : {}", e.getMessage());
        }
        return stackTrace;
    }
}
