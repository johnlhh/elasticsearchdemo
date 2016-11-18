package com.huamo.appservice.controller;

import com.huamo.appservice.service.OrderIndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by luohh on 2016/10/18.
 */
@RestController
@RequestMapping(("/order/index"))
public class OrderIndexController {

    @Autowired
    private OrderIndexService orderIndexService;

    @RequestMapping(value = "v1.0/create.do", method = RequestMethod.POST)
    public String getHomeBanners(HttpServletRequest request,
                                    HttpServletResponse response
                                  ) throws  Exception{
        Long indexAmount = orderIndexService.createAllOrderIndex();
        return  "订单索引创建成功，索引总数"+indexAmount;
    }
}
