package com.kapcb.framework.common.util;

import cn.hutool.core.util.PageUtil;
import com.kapcb.framework.common.page.IPageResult;
import com.kapcb.framework.common.page.PagePagination;
import com.kapcb.framework.common.page.PageResult;
import lombok.experimental.UtilityClass;
import org.apache.commons.collections.CollectionUtils;

import java.util.List;
import java.util.Objects;

/**
 * <a>Title: PageResultUtil </a>
 * <a>Author: Kapcb <a>
 * <a>Description: PageResultUtil <a>
 *
 * @author Kapcb
 * @version 1.0.0
 * @date 2021/11/8 21:29
 */
@UtilityClass
public class PageResultUtil {

    public static <T, D> IPageResult<T> restPage(List<T> data, IPageResult<D> result) {
        IPageResult<T> pageResult = new PageResult<>();
        if (CollectionUtils.isNotEmpty(data)) {
            pageResult.setRecords(data);
            pageResult.setTotal(result.getTotal());
            pageResult.setPageNum(result.getPageNum());
            pageResult.setPageSize(result.getPageSize());
            pageResult.setTotalPage(result.getTotalPage());
        }
        return pageResult;
    }

    public static <T, D> IPageResult<T> restPage(List<T> data, long total, PagePagination pagePagination) {
        IPageResult<T> pageResult = new PageResult<>();
        if (Objects.nonNull(pagePagination)) {
            pageResult.setRecords(data);
            pageResult.setTotal(total);
            pageResult.setTotalPage(PageUtil.totalPage((int) total, (int) pagePagination.getPageSize()));
            convertPageParam(pageResult, pagePagination);
        }
        return pageResult;
    }

    public static <T> void convertPageParam(IPageResult<T> pageResult, PagePagination pagePagination) {
        if (Objects.nonNull(pagePagination)) {
            pageResult.setPageNum(pagePagination.getPageNum());
            pageResult.setPageSize(pagePagination.getPageSize());
        }
    }
}
