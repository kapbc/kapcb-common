package com.kapcb.framework.common.function;

import java.util.function.Consumer;

/**
 * <a>Title: PresentHandler </a>
 * <a>Author: Kapcb <a>
 * <a>Description: PresentHandler <a>
 *
 * @author Kapcb
 * @version 1.0
 * @date 2021/12/26 21:53
 * @since 1.0
 */
@FunctionalInterface
public interface PresentHandler<T> {

    /**
     * do present
     *
     * @param consumer Consumer<? super T>
     * @param runnable Runnable
     */
    void present(Consumer<? super T> consumer, Runnable runnable);

}
