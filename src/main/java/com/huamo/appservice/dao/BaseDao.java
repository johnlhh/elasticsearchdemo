package com.huamo.appservice.dao;

import java.util.List;

/**
 * Created by Administrator on 2016/8/21 0021.
 */
public interface BaseDao<T> {

    T save(String statement, T t);

    void delete(String statement, T t);

    int update(String statement, T t);

    List<T> query(String statement, T t);

    PageList<T> queryForPage(String statement, T t, int toPage, int pageSize);

    Object selectOne(String statement,Object params);

    List<Object> selectList(String statement,Object params);


}
