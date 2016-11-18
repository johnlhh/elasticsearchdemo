package com.huamo.appservice.service.impl;

import com.huamo.appservice.common.Constant;
import com.huamo.appservice.dao.BaseDao;
import com.huamo.appservice.entity.Order;
import com.huamo.appservice.service.OrderIndexService;

import org.elasticsearch.client.Client;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.query.IndexQuery;
import org.springframework.data.elasticsearch.core.query.IndexQueryBuilder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by luohh on 2016/10/17.
 */
@Service
public class OrderIndexServiceImpl implements OrderIndexService {

    private static final Logger logger = LoggerFactory.getLogger(OrderIndexServiceImpl.class);

    @Autowired
    private BaseDao baseDao;
   /* @Autowired
    private ElasticsearchTemplate elasticsearchTemplate;*/
    /**
     * 初始化订单索引
     */
   /* public void init() {
        if (elasticsearchTemplate.indexExists(Constant.IndexName.ORDER_INDEX)) {
            elasticsearchTemplate.deleteIndex(Constant.IndexName.ORDER_INDEX);
        }
        elasticsearchTemplate.createIndex(Constant.IndexName.ORDER_INDEX);
        elasticsearchTemplate.putMapping(Order.class);
    }*/

    @Override
    public Long createAllOrderIndex() {
        long start_time = new Date().getTime();
        //init();
        Long indexAmount = 0l;
        /*List<Order> orderList = baseDao.query("OrderMapper.queryOrders", null);
        List<IndexQuery> queries = new ArrayList<IndexQuery>();
        for (Order order : orderList) {
            IndexQuery indexQuery = new IndexQueryBuilder().withId(order.getId()+"").withObject(order).build();
            queries.add(indexQuery);
            if(queries.size() % Constant.IndexConstant.BLUK_SIZE == 0){
                elasticsearchTemplate.bulkIndex(queries);
                queries.clear();
            }
            indexAmount++;
        }
        if(queries.size() > 0){
            elasticsearchTemplate.bulkIndex(queries);
            queries.clear();
        }
        orderList.clear();
        long end_time = new Date().getTime();
        logger.info("创建订单索引总数目：{},耗时：{} 秒", indexAmount, (end_time - start_time) / 1000);
        System.out.println("创建订单索引总数目："+indexAmount+",耗时："+(end_time-start_time)/1000+" 秒");*/
        return indexAmount;
    }

    @Override
    public Long createOrderIndexIncrement() {
        return null;
    }

    @Override
    public Long updateOrderIndex() {
        return null;
    }

    @Override
    public Long deleteOrderIndex() {
        return null;
    }
}
