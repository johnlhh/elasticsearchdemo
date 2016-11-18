package com.huamo.appservice.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by luohh on 2016/11/17.
 */
@RestController
@RequestMapping("/test/")
public class TestController {
    @RequestMapping(value = "v1.0/mock1.do", method = RequestMethod.POST)
    public Map<String,Object>  getHomeBanners(HttpServletRequest request,
                                  HttpServletResponse response
    ) throws  Exception{
        Map<String,Object> map = new HashMap<>();
        map.put("success", true);
        List<Map<String,Object>> data = new ArrayList<>();
        for(int i = 0; i < 10 ; i++){
            Map<String,Object> obj = new HashMap<>();
            obj.put("id",i+1);
            obj.put("name","name"+(i+1));
            obj.put("age",20+i+1);
            obj.put("address","address"+(i+1));
            data.add(obj);
        }
        Map<String,Object> page = new HashMap<>();
        page.put("current",1);
        page.put("total",100);

        map.put("data",data);
        map.put("page",page);
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, PUT, DELETE");
        response.setHeader("Access-Control-Max-Age", "3600");
        response.setHeader("Access-Control-Allow-Headers", "token,Access-Control-Allow-Origin,Access-Control-Allow-   Methods,Access-Control-Max-Age,authorization");
      return map;
    }
}
