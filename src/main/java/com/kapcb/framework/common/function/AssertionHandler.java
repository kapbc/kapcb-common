package com.kapcb.framework.common.function;

/**
 * <a>Title: AssertionHandler </a>
 * <a>Author: Kapcb <a>
 * <a>Description: AssertionHandler <a>
 *
 * @author Kapcb
 * @version 1.0
 * @date 2021/12/26 21:09
 * @since 1.0
 */
@FunctionalInterface
public interface AssertionHandler {

    /**
     * 抛出异常信息
     *
     * @param message 抛出的异常信息
     */
    void assertion(String message);

}
