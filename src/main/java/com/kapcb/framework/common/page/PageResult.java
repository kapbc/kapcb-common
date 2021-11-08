package com.kapcb.framework.common.page;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * <a>Title: PageResult </a>
 * <a>Author: Kapcb <a>
 * <a>Description: PageResult <a>
 *
 * @author Kapcb
 * @version 1.0.0
 * @date 2021/11/8 21:04
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class PageResult<T> implements IPageResult<T>, Serializable {

    private static final long serialVersionUID = 5794340994984498956L;

    private long pageNum;

    private long pageSize;

    private long total;

    private long totalPage;

    private List<T> records;

}
