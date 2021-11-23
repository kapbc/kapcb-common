package com.kapcb.framework.common.util;

import cn.hutool.core.lang.Assert;
import lombok.experimental.UtilityClass;
import org.springframework.cglib.beans.BeanCopier;

import java.util.concurrent.ConcurrentHashMap;

/**
 * <a>Title: BeanCopierUtil </a>
 * <a>Author: Kapcb <a>
 * <a>Description: BeanCopierUtil <a>
 *
 * @author Kapcb
 * @version 1.0.0
 * @date 2021/11/20 14:35
 */
@UtilityClass
public class BeanCopierUtil {

    private static final ConcurrentHashMap<String, BeanCopier> BEAN_COPIER_MAP = new ConcurrentHashMap<>(6);

    public static void copy(Object source, Object target) {
        Assert.notNull(source, "source can not be null");
        Assert.notNull(target, "target can not be null");
        String key = genKey(source.getClass(), target.getClass());
        BeanCopier beanCopier;
        if (BEAN_COPIER_MAP.containsKey(key)) {
            beanCopier = BEAN_COPIER_MAP.get(key);
        } else {
            beanCopier = BeanCopier.create(source.getClass(), target.getClass(), false);
            BEAN_COPIER_MAP.putIfAbsent(key, beanCopier);c
        }
        beanCopier.copy(source, target, null);
    }

    private static String genKey(Class<?> sourceClazz, Class<?> targetClazz) {
        return new String();
    }
}
