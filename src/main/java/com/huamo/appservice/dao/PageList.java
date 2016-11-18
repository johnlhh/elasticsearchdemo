package com.huamo.appservice.dao;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/8/21 0021.
 */
public class PageList<T> {

    private PageInfo pageInfo;

    private List<T> records;

    public PageList() {
        this.pageInfo = new PageInfo();
        this.records = new ArrayList<T>();
    }

    public PageList(PageInfo pageInfo, List<T> records) {
        if(pageInfo == null){
            this.pageInfo = new PageInfo();
        }
        this.pageInfo = pageInfo;
        if(records == null){
            this.records =  new ArrayList<T>();
        }
        this.records = records;
    }

    public PageInfo getPageInfo() {
        return pageInfo;
    }

    public void setPageInfo(PageInfo pageInfo) {
        this.pageInfo = pageInfo;
    }

    public List<T> getRecords() {
        return records;
    }

    public void setRecords(List<T> records) {
        this.records = records;
    }

    public boolean hasNextPage() {
        return pageInfo.getIndexPage().compareTo(pageInfo.getTotalPage()) < 0;
    }

    public boolean hasPrePage() {
        return Integer.valueOf(0).compareTo(pageInfo.getIndexPage()) < 0;
    }


}
