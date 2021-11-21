package com.kapcb.framework.common.page;

import java.io.Serializable;

/**
 * <a>Title: PageRequest </a>
 * <a>Author: Kapcb <a>
 * <a>Description: PageRequest <a>
 *
 * @author Kapcb
 * @version 1.0.0
 * @date 2021/11/20 22:45
 */
public class PageRequest implements Page, Serializable {

    private static final long serialVersionUID = -3347283810042206322L;

    private long pageNum;

    private long pageSize;

    public PageRequest(long pageNum, long pageSize) {
        this.pageNum = pageNum;
        this.pageSize = pageSize;
    }

    public static PageRequest of(long pageNum, Integer pageSize) {
        return new PageRequest(pageNum, pageSize);
    }

    @Override
    public long getPageNum() {
        return this.pageNum;
    }

    @Override
    public long getPageSize() {
        return this.pageSize;
    }
}
