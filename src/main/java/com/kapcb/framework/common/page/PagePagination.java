package com.kapcb.framework.common.page;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * <a>Title: PagePagination </a>
 * <a>Author: Kapcb <a>
 * <a>Description: PagePagination <a>
 *
 * @author Kapcb
 * @version 1.0.0
 * @date 2021/11/8 21:06
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PagePagination implements Serializable {

    private static final long serialVersionUID = -3347283810042206322L;

    private long pageNum = 1L;

    private long pageSize = 10L;

}
