package com.huamo.appservice.service;

import java.util.List;
import java.util.Map;

/**
 * Created by luohh on 2016/10/24.
 */
public interface DataShowService {

    List<Map<String,Object>> getCitySessionSummary(Map<String,Object> params);

    List<Map<String, Object>> getCitys();

    List<Integer> getCitySessions(Integer city_id);

    List<String> getCitySrcs(Integer city_id);

    List<Map<String, Object>> getSrcdatabySessions(Map<String,Object> params);
}
