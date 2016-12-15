package com.xwolf.eop.system.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author xwolf
 * @date 2016-12-13 12:37
 * @since V1.0.0
 */
@Controller
public class IndexController {

    private static final Logger log= LoggerFactory.getLogger(IndexController.class);

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
}
