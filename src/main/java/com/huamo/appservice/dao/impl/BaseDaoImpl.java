package com.huamo.appservice.dao.impl;


import com.huamo.appservice.dao.BaseDao;
import com.huamo.appservice.dao.PageInfo;
import com.huamo.appservice.dao.PageList;
import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/8/21 0021.
 */
@Repository
public class BaseDaoImpl<T> implements BaseDao<T> {

    @Autowired
    private SqlSessionTemplate sqlSession;


    @Override
    public T save(String statement, T t) {
        return sqlSession.selectOne(statement, t);
    }

    @Override
    public void delete(String statement, T t) {
        sqlSession.delete(statement, t);
    }

    @Override
    public int update(String statement, T t) {
        return sqlSession.update(statement, t);
    }

    @Override
    public List<T> query(String statement, T t) {
        return sqlSession.selectList(statement, t);
    }



    @Override
    public PageList<T> queryForPage(String statement, T t, final int toPage, final int pageSize) {

        RowBounds rowBounds = new RowBounds() {
            @Override
            public int getLimit() {
                return pageSize;
            }

            public int getOffset() {
                return (toPage - 1) * pageSize;
            }
        };
        List<T> list = sqlSession.selectList(statement, t, rowBounds);

        String totalStr = statement + "Count";
        Integer count = sqlSession.selectOne(totalStr, t);

        return new PageList<T>(create(list, count, toPage, pageSize), list);


    }

    @Override
    public Object selectOne(String statement, Object params) {
        return sqlSession.selectOne(statement,params);
    }

    @Override
    public List<Object> selectList(String statement, Object params) {
        return sqlSession.selectList(statement,params);
    }

    public PageInfo create(List<T> list, Integer count, final int toPage, final int pageSize) {
        PageInfo pageInfo = new PageInfo();
        Integer endPage = count.intValue() % pageSize == 0 ? (count.intValue() - count.intValue() % pageSize) / pageSize : (count.intValue() - count.intValue() % pageSize) / pageSize + 1;
        if (list != null) {
            pageInfo.setCurrPageRecord(list.size());
        }
        pageInfo.setEndPage(endPage);
        pageInfo.setTotalPage(endPage);
        pageInfo.setFirstPage(1);
        pageInfo.setIndexPage(toPage);
        pageInfo.setTotalRecord(count);
        pageInfo.setPageSize(pageSize);
        pageInfo.setNextPage(toPage + 1);
        pageInfo.setPrePage(toPage - 1);
        return pageInfo;
    }
}
