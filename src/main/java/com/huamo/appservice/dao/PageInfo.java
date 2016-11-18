package com.huamo.appservice.dao;

/**
 * Created by Administrator on 2016/8/21 0021.
 */
public class PageInfo {

    //当前页
    private Integer indexPage;
    //每页的大小
    private Integer pageSize;
    //总共多少页
    private Integer totalPage;
    //下一页
    private Integer nextPage;
    //上一页
    private Integer prePage;
    //尾页
    private Integer endPage;
    //首页
    private Integer firstPage;
    //总共记录数
    private Integer totalRecord;
    //当前记录数
    private Integer currPageRecord;

    public PageInfo() {
        this.indexPage = 0;
        this.pageSize = 10;
        this.totalPage = 0;
        this.totalRecord = 0;
        this.currPageRecord = 0;
    }

    public Integer getIndexPage() {
        return indexPage;
    }

    public void setIndexPage(Integer indexPage) {
        this.indexPage = indexPage;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
    }

    public Integer getNextPage() {
        return nextPage;
    }

    public void setNextPage(Integer nextPage) {
        this.nextPage = nextPage;
    }

    public Integer getPrePage() {
        return prePage;
    }

    public void setPrePage(Integer prePage) {
        this.prePage = prePage;
    }

    public Integer getEndPage() {
        return endPage;
    }

    public void setEndPage(Integer endPage) {
        this.endPage = endPage;
    }

    public Integer getFirstPage() {
        return firstPage;
    }

    public void setFirstPage(Integer firstPage) {
        this.firstPage = firstPage;
    }

    public Integer getTotalRecord() {
        return totalRecord;
    }

    public void setTotalRecord(Integer totalRecord) {
        this.totalRecord = totalRecord;
    }

    public Integer getCurrPageRecord() {
        return currPageRecord;
    }

    public void setCurrPageRecord(Integer currPageRecord) {
        this.currPageRecord = currPageRecord;
    }

    @Override
    public String toString() {
        return "PageInfo{" +
                "indexPage=" + indexPage +
                ", pageSize=" + pageSize +
                ", totalPage=" + totalPage +
                ", nextPage=" + nextPage +
                ", prePage=" + prePage +
                ", endPage=" + endPage +
                ", firstPage=" + firstPage +
                ", totalRecord=" + totalRecord +
                ", currPageRecord=" + currPageRecord +
                '}';
    }
}
