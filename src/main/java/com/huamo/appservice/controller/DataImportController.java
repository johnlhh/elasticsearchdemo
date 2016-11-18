package com.huamo.appservice.controller;

import com.huamo.appservice.service.DataImportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by luohh on 2016/10/24.
 */
@RestController
@RequestMapping("/data/import/")
public class DataImportController {

    @Autowired
    private DataImportService dataImportService;

    //,produces = {"application/json;charset=UTF-8"}
    @RequestMapping(value = "v1.0/summary.do", method = RequestMethod.POST)
    public String  getHomeBanners(HttpServletRequest request,
                                  HttpServletResponse response,
                                      @RequestParam(required = true) Integer city_id,
                                      @RequestParam(required = true) Integer session,
                                      @RequestParam(required = false,defaultValue = "0") Integer type
    ) throws  Exception{
        Map<String,Object> params = new HashMap<>();
        params.put("cityid",city_id);
        params.put("session", session);
        params.put("type", type);
        int count = dataImportService.insertCitySessionSummary(params);
        return "汇总记录数："+count;
    }
}
