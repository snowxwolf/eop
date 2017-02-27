package com.xwolf.eop.erp.task;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;

/**
 * @author xwolf
 * @date 2016-12-19 13:09
 * @since V1.0.0
 */
public class HelloTask {
    private static final Logger log= LoggerFactory.getLogger(HelloTask.class);
    public void hello(){
       log.info("Hello Task:{},当前时间:{}","定时任务执行",new Date());
    }
}
