package com.huamo.appservice.service.impl;

import com.huamo.appservice.service.DataImportService;
import com.huamo.appservice.service.OrderService;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by luohh on 2016/10/24.
 */
@Service
public class DataImportServiceImpl implements DataImportService {

    private static final int BATCH_SIZE = 200;

    @Autowired
    private OrderService orderService;

    @Autowired
    private SqlSessionTemplate writeSqlSession;

    @Override
    public Integer insertCitySessionSummary(Map<String, Object> params) {
        int sum = 0;
        Integer type = (Integer) params.get("type");
        if(type != null && type.intValue() == 0){                 //指定届
            sum = insertBySession(params);
        }else  if (type != null && type.intValue() == -1){        //小于指定届
            Integer session = (Integer) params.get("session");
            for(int i = 1; i < session.intValue();i++ ){
                params.put("session",i);
                sum += insertBySession(params);
            }
        }else{                                                    //大于指定届
            int count = 1;
            Integer session = (Integer) params.get("session");
            while(count > 0){
                params.put("session",++session);
                count = insertBySession(params);
                sum += count;
            }
        }
        return sum;
    }

    public Integer insertBySession(Map<String, Object> params) {
        if(!checkIsAlreadyImport(params)){
            List<Map<String, Object>> summaryMaps = orderService.getCitySessionSummary(params);
            List<Map<String, Object>> temp = new ArrayList<>();
            for(int i = 0 ; i < summaryMaps.size(); i++){
                temp.add(summaryMaps.get(i));
                if(temp.size() == BATCH_SIZE){
                    writeSqlSession.insert("SummaryMapper.insertCitySessionSummary",temp);
                    temp.clear();
                }
            }
            if(temp.size() > 0){
                writeSqlSession.insert("SummaryMapper.insertCitySessionSummary",temp);
            }
            return summaryMaps.size();
        }
        return 0;
    }

    @Override
    public boolean checkIsAlreadyImport(Map<String, Object> params) {
        int count = writeSqlSession.selectOne("SummaryMapper.checkIsAlreadyImport",params);
        if(count < 1){
            return false;
        }
        return true;
    }
}
