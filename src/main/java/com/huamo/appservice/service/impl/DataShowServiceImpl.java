package com.huamo.appservice.service.impl;

import com.huamo.appservice.service.DataShowService;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by luohh on 2016/10/24.
 */
@Service
public class DataShowServiceImpl implements DataShowService {

    @Autowired
    private SqlSessionTemplate writeSqlSession;

    @Override
    public List<Map<String, Object>> getCitySessionSummary(Map<String, Object> params) {
        return writeSqlSession.selectList("SummaryMapper.getcitySessionSummary",params);
    }

    @Override
    public List<Map<String, Object>> getCitys() {
        return writeSqlSession.selectList("SummaryMapper.getCitys");
    }

    @Override
    public List<Integer> getCitySessions(Integer city_id) {
        return writeSqlSession.selectList("SummaryMapper.getCitySessions",city_id);
    }

    @Override
    public List<String> getCitySrcs(Integer city_id) {
        return writeSqlSession.selectList("SummaryMapper.getCitySrcs",city_id);
    }

    @Override
    public List<Map<String, Object>> getSrcdatabySessions(Map<String, Object> params) {
        return writeSqlSession.selectList("SummaryMapper.getSrcdatabySessions",params);
    }


}
