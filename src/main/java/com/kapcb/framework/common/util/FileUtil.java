package com.kapcb.framework.common.util;

import com.kapcb.framework.common.constants.enums.StringPool;
import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;

import java.io.InputStream;
import java.util.Objects;

/**
 * <a>Title: FileUtil </a>
 * <a>Author: Kapcb <a>
 * <a>Description: FileUtil <a>
 *
 * @author Kapcb
 * @version 1.0.0
 * @date 2021/11/8 20:47
 */
@Slf4j
@UtilityClass
public class FileUtil {

    public static InputStream getResourcesFileInputStream(String filename) {
        return Thread.currentThread().getContextClassLoader().getResourceAsStream(StringPool.EMPTY_STRING.value() + filename);
    }

    public static String getPath() {
        return Objects.requireNonNull(FileUtil.class.getResource(StringPool.SLASH.value())).getPath();
    }

}
