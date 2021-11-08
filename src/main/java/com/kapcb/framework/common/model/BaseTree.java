package com.kapcb.framework.common.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * <a>Title: BaseTree </a>
 * <a>Author: Kapcb <a>
 * <a>Description: BaseTree <a>
 *
 * @author Kapcb
 * @version 1.0.0
 * @date 2021/11/8 20:57
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class BaseTree<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * node id
     */
    private Integer id;

    /**
     * parent node id, if parentId's value is 0 the node must be parent node
     */
    private Integer parentId;

    /**
     * children node
     */
    private List<T> children = new ArrayList<>();
}
