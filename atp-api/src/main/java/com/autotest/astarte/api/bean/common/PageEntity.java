package com.autotest.astarte.api.bean.common;

import java.io.Serializable;

public class PageEntity implements Serializable {

    protected Integer pageNumber; //页数
    protected Integer pageSize; //条数

    public Integer getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(Integer pageNumber) {
        this.pageNumber = pageNumber;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }
}
