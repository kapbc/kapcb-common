package com.kapcb.framework.common.util;

import com.kapcb.framework.common.function.AssertionHandler;
import com.kapcb.framework.common.function.BranchHandler;
import com.kapcb.framework.common.function.BranchHandlerSupply;
import com.kapcb.framework.common.function.PresentHandler;
import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.formula.functions.T;

import java.util.concurrent.Callable;
import java.util.function.Consumer;


/**
 * <a>Title: AssertionUtil </a>
 * <a>Author: Kapcb <a>
 * <a>Description: AssertionUtil <a>
 *
 * @author Kapcb
 * @version 1.0
 * @date 2021/12/26 21:11
 * @since 1.0
 */
@Slf4j
@UtilityClass
public class AssertionUtil {

    /**
     * 如果参数为 true则抛出异常
     *
     * @param assertion boolean
     * @return AssertionFunction
     */
    public static AssertionHandler assertion(boolean assertion) {
        return (message) -> {
            if (assertion) {
                throw new RuntimeException(message);
            }
        };
    }

    public static BranchHandler handler(boolean assertion) {
        return ((trueHandler, falseHandler) -> {
            if (assertion) {
                trueHandler.run();
            } else {
                falseHandler.run();
            }
        });
    }

    public static <V> BranchHandlerSupply<V> handlerSupply(boolean assertion, Class<V> v) {
        return ((trueHandler, falseHandler) -> {
            if (assertion) {
                return handler(trueHandler);
            } else {
                return handler(falseHandler);
            }
        });
    }

    private static <V> V handler(Callable<V> handler) {
        try {
            return handler.call();
        } catch (Exception e) {
            log.error("Branch Handler's true handler error, error message is : {}", e.getMessage());
        }
        return null;
    }

//    public static PresentHandler<?> present(T value, boolean assertion) {
//        return (consumer, runnable) -> {
//            if (assertion) {
//                runnable.run();
//            } else {
//                consumer.accept(value);
//            }
//        };
//    }

    public static void main(String[] args) throws Exception {
        String a = "111";

        String b = "222";

        AssertionUtil.handler(a.equals(b)).assertHandler(
                () -> System.out.println("a == b"),
                () -> System.out.println("a != b"));

        String s = AssertionUtil.handlerSupply(!a.equals(b), String.class).assertHandlerSupply(
                () -> a + b,
                () -> b + a
        );
        System.out.println("s = " + s);

//        AssertionUtil.present(a, a.equals(b)).present();
    }

}
