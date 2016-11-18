package com.huamo.appservice.service;

import java.util.List;
import java.util.Map;

/**
 * Created by luohh on 2016/10/18.
 */
public interface OrderService {


    List<Map<String,Object>> getMonthsOrderCount(Map<String,Object> params);

    List<Map<String,Object>> getCitySessionTicketandOrder(Map<String,Object> params);

    List<Map<String,Object>> getCitySessionSummary(Map<String,Object> params);

}
