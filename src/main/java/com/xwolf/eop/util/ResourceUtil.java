package com.xwolf.eop.util;

import org.apache.commons.lang3.StringUtils;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PropertiesLoaderUtils;

import java.util.Properties;

/**
 * @author xwolf
 * @date 2016-12-14 13:47
 * @since V1.0.0
 */
public class ResourceUtil {

    private static Properties properties;

    public ResourceUtil(String config){
        Resource resource=new ClassPathResource(config);
        try {
            properties= PropertiesLoaderUtils.loadProperties(resource);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 根据 配置文件key 获取value
     * @param key  对应key
     * @return
     */
    public  String getValue(String key){
      String value= String.valueOf(properties.get(key));
      if(StringUtils.isBlank(value)){
          return null;
      }
      return value;
    }
}
