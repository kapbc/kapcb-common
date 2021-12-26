package com.kapcb.framework.common.function;

/**
 * <a>Title: BranchHandler </a>
 * <a>Author: Kapcb <a>
 * <a>Description: BranchHandler <a>
 *
 * @author Kapcb
 * @version 1.0
 * @date 2021/12/26 21:15
 * @since 1.0
 */
@FunctionalInterface
public interface BranchHandler extends Branch {

    /**
     * assert branch handler
     *
     * @param trueHandler  Runnable
     * @param falseHandler Runnable
     */
    void assertHandler(Runnable trueHandler, Runnable falseHandler);

}
