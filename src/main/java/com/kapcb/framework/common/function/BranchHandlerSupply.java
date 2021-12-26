package com.kapcb.framework.common.function;


import java.util.concurrent.Callable;

/**
 * <a>Title: BranchHandlerSupply </a>
 * <a>Author: Kapcb <a>
 * <a>Description: BranchHandlerSupply <a>
 *
 * @author Kapcb
 * @version 1.0
 * @date 2021/12/26 21:18
 * @since 1.0
 */
@FunctionalInterface
public interface BranchHandlerSupply<V> extends Branch {

    /**
     * supplier assert handler
     *
     * @param trueHandler  Callable<V>
     * @param falseHandler Callable<V>
     * @return V
     * @throws Exception Exception
     */
    V assertHandlerSupply(Callable<V> trueHandler, Callable<V> falseHandler);

}
