package com.kapcb.framework.common.util;

import com.kapcb.framework.common.constants.enums.IntegerPool;
import com.kapcb.framework.common.model.BaseTree;
import lombok.experimental.UtilityClass;
import org.springframework.lang.NonNull;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * <a>Title: TreeUtil </a>
 * <a>Author: Kapcb <a>
 * <a>Description: TreeUtil <a>
 *
 * @author Kapcb
 * @version 1.0.0
 * @date 2021/11/8 20:48
 */
@UtilityClass
public class TreeUtil {

    public static <T extends BaseTree<T>> List<T> convertTree(@NonNull List<T> originalList) {
        List<T> parentNode = originalList.parallelStream()
                .filter(Objects::nonNull)
                .filter(node -> Objects.equals(IntegerPool.ZERO.value(), node.getParentId()))
                .distinct()
                .collect(Collectors.toList());

        parentNode.forEach(parent -> parent = handlerTortoise(parent, originalList));
        return parentNode;
    }

    private static <T extends BaseTree<T>> T handlerTortoise(@NonNull T parent, @NonNull List<T> allNodeList) {
        allNodeList.forEach(child -> {
            if (Objects.equals(parent.getId(), child.getParentId())) {
                parent.getChildren().add(handlerTortoise(child, allNodeList));
            }
        });
        return parent;
    }

}
