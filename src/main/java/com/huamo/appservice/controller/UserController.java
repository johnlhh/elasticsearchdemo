package com.huamo.appservice.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by luohh on 2016/11/18.
 */
@RestController
@RequestMapping("/user/")
public class UserController {

    @RequestMapping(value = "v1.0/login.do", method = RequestMethod.POST)
    public Map<String,Object> getHomeBanners(HttpServletRequest request,
                                             HttpServletResponse response,
                                             @RequestParam(required = true) String userName,
                                             @RequestParam(required = true) String password
    ) throws  Exception{
        Map<String,Object> map = new HashMap<>();

        if("john".equals(userName) && "123456".equals(password)){
            map.put("flag",true);
            map.put("message","success");
        }else{
            map.put("flag",false);
            map.put("message","failed");
        }
        return map;
    }
}
