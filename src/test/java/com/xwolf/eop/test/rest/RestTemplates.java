package com.xwolf.eop.test.rest;

import org.junit.Test;
import org.springframework.web.client.RestTemplate;

/**
 * @author xwolf
 * @date 2016-12-13 12:49
 * @since V1.0.0
 */
public class RestTemplates {

    @Test
    public void test1(){
        RestTemplate template=new RestTemplate();
        String url="http://ip.taobao.com/service/getIpInfo.php?ip=192.68.122.21";
        String a= template.getForObject(url,String.class);
        System.out.println(a);
    }
}
