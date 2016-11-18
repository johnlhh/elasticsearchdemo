package com.huamo.appservice.service.impl;

import com.huamo.appservice.dao.BaseDao;
import com.huamo.appservice.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by luohh on 2016/10/18.
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private BaseDao baseDao;

    @Override
    public List<Map<String, Object>> getMonthsOrderCount(Map<String, Object> params) {
        return baseDao.selectList("OrderMapper.monthsOrderCount", params);
    }

    @Override
    public  List<Map<String, Object>>  getCitySessionTicketandOrder(Map<String, Object> params) {
        return baseDao.selectList("OrderMapper.citySessionTicketAndOrder", params);
    }

    @Override
    public List<Map<String, Object>> getCitySessionSummary(Map<String, Object> params) {
        return baseDao.selectList("OrderMapper.citySessionSummary", params);
    }
}
