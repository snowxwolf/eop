package com.xwolf.eop.system.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author xwolf
 * @date 2016-12-13 12:37
 * @since V1.0.0
 */
@Controller
@Slf4j
public class IndexController {

    /**
     * 首页
     * @param ua
     * @return
     */
    @RequestMapping(value ="index")
    public String toIndex(@RequestHeader("User-Agent")String ua){
        log.info("ua:{}",ua);
        return "system/index";
    }

    /**
     * 授权失败
     * @return
     */
    @RequestMapping(value = "unAuth",method = RequestMethod.POST)
    public String toUnAuth(){
        return "system/error/unauthorized";
    }


}
